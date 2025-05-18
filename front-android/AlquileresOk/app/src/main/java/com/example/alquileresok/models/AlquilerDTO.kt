package com.example.alquileresok.models

data class AlquilerDTO(
    val nombreCliente: String,
    val apellidoCliente: String,
    val tipoVehiculo: String,
    val color: String,
    val horasAlquiladas: String,
    val idVehiculo: Int? = null,          // ← opcional
    val registroAlquiler: Int? = null

)
