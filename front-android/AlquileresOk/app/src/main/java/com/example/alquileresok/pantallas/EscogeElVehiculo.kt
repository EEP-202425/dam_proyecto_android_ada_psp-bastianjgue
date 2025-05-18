package com.example.alquileresok.pantallas

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.alquileresok.api.ApiClient
import com.example.alquileresok.models.AlquilerDTO
import com.example.alquileresok.enums.Enums // Asegúrate de importar tu objeto Enums
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun EscogeElVehiculoScreen(
    nombreCliente: String,
    apellidoCliente: String,
    onAlquilerConfirmado: (AlquilerDTO) -> Unit
) {
    val context = LocalContext.current
    var tipoVehiculo by remember { mutableStateOf<Enums.TipoVehiculo?>(null) }
    var colorVehiculo by remember { mutableStateOf<Enums.ColorVehiculo?>(null) }
    var horasAlquiladas by remember { mutableStateOf<Enums.HorasAlquiladas?>(null) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Bienvenido, $nombreCliente $apellidoCliente",
                style = MaterialTheme.typography.headlineSmall
            )

            EnumDropdownSelector<Enums.TipoVehiculo>(
                label = "Tipo de Vehículo",
                options = Enums.TipoVehiculo.values().toList(),
                selected = tipoVehiculo,
                onOptionSelected = { tipoVehiculo = it }
            )

            EnumDropdownSelector<Enums.ColorVehiculo>(
                label = "Color del Vehículo",
                options = Enums.ColorVehiculo.values().toList(),
                selected = colorVehiculo,
                onOptionSelected = { colorVehiculo = it }
            )

            EnumDropdownSelector<Enums.HorasAlquiladas>(
                label = "Horas de Alquiler",
                options = Enums.HorasAlquiladas.values().toList(),
                selected = horasAlquiladas,
                onOptionSelected = { horasAlquiladas = it }
            )

            Button(
                onClick = {
                    if (tipoVehiculo != null && colorVehiculo != null && horasAlquiladas != null) {
                        val alquiler = AlquilerDTO(
                            nombreCliente = nombreCliente,
                            apellidoCliente = apellidoCliente,
                            tipoVehiculo = tipoVehiculo!!.name,
                            color = colorVehiculo!!.name,
                            horasAlquiladas = horasAlquiladas!!.name
                        )

                        CoroutineScope(Dispatchers.IO).launch {
                            val respuesta = ApiClient.crearAlquiler(alquiler)
                            if (respuesta != null) {
                                withContext(Dispatchers.Main) {
                                    onAlquilerConfirmado(respuesta)
                                }
                            } else {
                                withContext(Dispatchers.Main) {
                                    Toast.makeText(context, "Error al conectar con el servidor", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Confirmar Alquiler")
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T : Enum<T>> EnumDropdownSelector(
    label: String,
    options: List<T>,
    selected: T?,
    onOptionSelected: (T) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        OutlinedTextField(
            value = selected?.toString() ?: "",
            onValueChange = {},
            readOnly = true,
            label = { Text(label) },
            modifier = Modifier
                .menuAnchor() // esto vincula el menú con el textfield
                .fillMaxWidth()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option.toString()) },
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}





