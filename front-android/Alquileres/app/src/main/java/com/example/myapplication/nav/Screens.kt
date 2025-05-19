package com.example.myapplication.nav

sealed class Screens(val route: String) {
    object Login : Screens("login")
    object EscogeElVehiculo : Screens("escoge_vehiculo/{nombre}/{apellido}") {
        fun createRoute(nombre: String, apellido: String) = "escoge_vehiculo/$nombre/$apellido"
    }
    object TicketAlquiler : Screens("ticket_alquiler/{alquilerJson}") {
        fun createRoute(alquilerJson: String) = "ticket_alquiler/$alquilerJson"
    }
}