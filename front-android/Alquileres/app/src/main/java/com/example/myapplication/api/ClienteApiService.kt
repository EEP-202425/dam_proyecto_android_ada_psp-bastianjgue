package com.example.myapplication.api
import com.example.myapplication.models.Cliente
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ClienteApiService {

    @POST("usuarios")
    suspend fun registrarCliente(@Body cliente: Cliente): Cliente
}


