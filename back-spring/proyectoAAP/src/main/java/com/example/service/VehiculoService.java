package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.dao.VehiculoRepository;
import com.example.model.Vehiculo;


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
