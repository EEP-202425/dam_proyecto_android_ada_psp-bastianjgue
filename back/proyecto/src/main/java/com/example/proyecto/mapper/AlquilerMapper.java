package com.example.proyecto.mapper;

import com.example.proyecto.dto.AlquilerDTO;
import com.example.proyecto.models.Alquiler;
import com.example.proyecto.models.Alquiler.HorasAlquiladas;
import com.example.proyecto.models.Cliente;
import com.example.proyecto.models.Vehiculo;

public class AlquilerMapper {
	public static Alquiler toEntity(AlquilerDTO dto, Cliente cliente, Vehiculo vehiculo) {
        Alquiler alquiler = new Alquiler();
        alquiler.setClienteId(cliente);
        alquiler.setVehiculoId(vehiculo);
        alquiler.setHorasAlquiladas(HorasAlquiladas.valueOf(dto.getHorasAlquiladas()));
        return alquiler;
    }

    public static AlquilerDTO toDTO(Alquiler alquiler) {
        AlquilerDTO dto = new AlquilerDTO();
        dto.setNombreCliente(alquiler.getClienteId().getNombre());
        dto.setApellidoCliente(alquiler.getClienteId().getApellido());
        dto.setTipoVehiculo(alquiler.getVehiculoId().getTipoVehiculo().toString());
        dto.setColor(alquiler.getVehiculoId().getColorVehiculo().toString());
        dto.setHorasAlquiladas(alquiler.getHorasAlquiladas().toString());
        return dto;
    }
}
