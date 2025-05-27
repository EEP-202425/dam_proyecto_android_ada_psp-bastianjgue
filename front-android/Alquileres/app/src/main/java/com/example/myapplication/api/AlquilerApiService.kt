package com.example.myapplication.api

import com.example.myapplication.models.AlquilerDTO
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AlquilerApiService {
    @POST("alquileres")
    suspend fun crearAlquiler(@Body alquiler: AlquilerDTO): Response<AlquilerDTO>

    @GET("alquileres")
    suspend fun getAlquileres(): List<AlquilerDTO>
}