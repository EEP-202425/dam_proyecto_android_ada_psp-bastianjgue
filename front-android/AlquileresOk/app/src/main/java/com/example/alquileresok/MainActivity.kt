package com.example.alquileresok

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import com.example.alquileresok.pantallas.EscogeElVehiculoScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.alquileresok.nav.AppNavGraph
import com.example.alquileresok.nav.Screens
import com.example.alquileresok.ui.theme.AlquileresOkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlquileresOkTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavGraph(navController = navController, padding = innerPadding)
                }
            }
        }
    }
}


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate("alquiler")
                }
            )
        }
        composable("alquiler/{nombre}/{apellido}") { backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
            val apellido = backStackEntry.arguments?.getString("apellido") ?: ""

            EscogeElVehiculoScreen(
                nombreCliente = nombre,
                apellidoCliente = apellido,
                onAlquilerConfirmado = { alquiler ->
                    // Aquí puedes navegar a la pantalla de resumen, pasando el alquiler si lo deseas
                    // navController.navigate("resumen")
                }
            )
        }
    }
}

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {

}

