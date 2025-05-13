package com.example.proyecto.service;

import java.util.ArrayList;
import java.util.List;

import com.example.proyecto.models.Vehiculo;
import com.example.proyecto.repository.VehiculoRepository;




public class VehiculoService {
	
	private final VehiculoRepository vehiculoRepository;

	public VehiculoService(VehiculoRepository vehiculoRepository) {
		this.vehiculoRepository = vehiculoRepository;
	}

	public List<Vehiculo> obtenerTodos() {
		List<Vehiculo> vehiculos = new ArrayList<>();
		vehiculoRepository.findAll().forEach(vehiculos::add);
		return vehiculos;
	}

	public Vehiculo guardar(Vehiculo vehiculo) {
	    return vehiculoRepository.save(vehiculo);
	}
}
