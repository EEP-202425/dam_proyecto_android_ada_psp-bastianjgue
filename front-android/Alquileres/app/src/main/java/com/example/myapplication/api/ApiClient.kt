package com.example.myapplication.api

import com.example.myapplication.api.AlquilerApiService
import com.example.myapplication.models.AlquilerDTO
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "http://10.0.2.2:8081/api/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val clienteApiService: ClienteApiService = retrofit.create(ClienteApiService::class.java)
    val alquilerApiService: AlquilerApiService = retrofit.create(AlquilerApiService::class.java)

    suspend fun crearAlquiler(nuevoAlquiler: AlquilerDTO): AlquilerDTO? {
        val response = alquilerApiService.crearAlquiler(nuevoAlquiler)
        return if (response.isSuccessful) {
            response.body()
        } else {
            // Puedes loguear el error si quieres
            null
        }
    }
}
