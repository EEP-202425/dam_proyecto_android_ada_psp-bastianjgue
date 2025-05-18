package com.example.alquileresok.pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.alquileresok.models.AlquilerDTO

@Composable
fun TicketAlquilerScreen(
    alquilerDTO: AlquilerDTO,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp), // Aplicamos el modifier recibido
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center // Centrado vertical
    ) {
        Text("Ticket de Alquiler", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(10.dp))

        Text("Cliente: ${alquilerDTO.nombreCliente} ${alquilerDTO.apellidoCliente}")
        Text("Vehículo: ${alquilerDTO.tipoVehiculo}")
        Text("Color: ${alquilerDTO.color}")
        Text("ID Vehículo: ${alquilerDTO.idVehiculo}")
        Text("Horas alquiladas: ${alquilerDTO.horasAlquiladas}")
        Text("Código de Alquiler: ${alquilerDTO.registroAlquiler}")
    }
}



