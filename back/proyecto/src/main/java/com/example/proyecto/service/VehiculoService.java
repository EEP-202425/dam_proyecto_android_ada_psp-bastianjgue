package com.example.proyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.proyecto.models.Vehiculo;
import com.example.proyecto.repository.VehiculoRepository;

@Service
public class VehiculoService {
	
	private final VehiculoRepository vehiculoRepository;

    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public Vehiculo guardar(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    public List<Vehiculo> obtenerTodos() {
        return (List<Vehiculo>) vehiculoRepository.findAll();
    }

    public Vehiculo buscarPorId(Integer id) {
        return vehiculoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Vehículo no encontrado con ID: " + id));
    }
}