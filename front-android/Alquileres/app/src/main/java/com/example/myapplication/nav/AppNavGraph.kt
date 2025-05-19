package com.example.myapplication.nav

import android.net.Uri
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.models.AlquilerDTO
import com.example.myapplication.pantallas.EscogeElVehiculoScreen
import com.example.myapplication.pantallas.LoginScreen
import com.example.myapplication.pantallas.TicketAlquilerScreen
import com.google.gson.Gson

@Composable
fun AppNavGraph(navController: NavHostController,
                padding: PaddingValues) {
    NavHost(navController = navController, startDestination = Screens.Login.route) {
        composable(Screens.Login.route) {
            LoginScreen(
                modifier = Modifier.padding(padding)
            ) { nombre, apellido ->
                navController.navigate("${Screens.EscogeElVehiculo.route}/$nombre/$apellido")
            }
        }
        composable("${Screens.EscogeElVehiculo.route}/{nombre}/{apellido}") { backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
            val apellido = backStackEntry.arguments?.getString("apellido") ?: ""

            EscogeElVehiculoScreen(
                nombreCliente = nombre,
                apellidoCliente = apellido,
                onAlquilerConfirmado = { alquiler ->
                    val alquilerJson = Uri.encode(Gson().toJson(alquiler))
                    navController.navigate(Screens.TicketAlquiler.createRoute(alquilerJson))
                }
            )
        }
        composable("ticket_alquiler/{alquilerJson}") { backStackEntry ->
            val alquilerJson = backStackEntry.arguments?.getString("alquilerJson") ?: ""
            val alquiler = Gson().fromJson(alquilerJson, AlquilerDTO::class.java)

            TicketAlquilerScreen(
                alquilerDTO = alquiler,
                modifier = Modifier.padding(padding)
            )
        }
    }
}

