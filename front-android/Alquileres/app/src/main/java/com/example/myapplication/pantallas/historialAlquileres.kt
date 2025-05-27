package com.example.myapplication.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.api.AlquilerApiService
import com.example.myapplication.models.AlquilerDTO
import kotlinx.coroutines.launch

@Composable
fun HistorialAlquileresScreen(
    alquilerApi: AlquilerApiService,
    navController: NavHostController
) {
    val scope = rememberCoroutineScope()
    var alquileres by remember { mutableStateOf<List<AlquilerDTO>>(emptyList()) }
    var error by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        scope.launch {
            try {
                alquileres = alquilerApi.getAlquileres()
            } catch (e: Exception) {
                error = "Error cargando alquileres: ${e.message}"
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Historial de Alquileres", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(8.dp))

        if (error != null) {
            Text(error!!, color = Color.Red)
        } else {
            LazyColumn {
                items(alquileres) { alquiler ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text("Cliente: ${alquiler.nombreCliente} ${alquiler.apellidoCliente}")
                            Text("Vehículo: ${alquiler.tipoVehiculo} (${alquiler.color})")
                            Text("Horas: ${alquiler.horasAlquiladas}")
                            Text("ID Registro: ${alquiler.registroAlquiler}")
                        }
                    }
                }
            }
        }
    }
}
