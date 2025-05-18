package com.example.alquileresok.api

import com.example.alquileresok.models.AlquilerDTO
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AlquilerApiService {
    @POST("alquileres")
    suspend fun crearAlquiler(@Body alquiler: AlquilerDTO): Response<AlquilerDTO>
}

