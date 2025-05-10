package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dao.AlquilerRepository;
import com.example.model.Alquiler;

@Service
public class AlquilerService {

	private final AlquilerRepository alquilerRepository;

	public AlquilerService(AlquilerRepository alquilerRepository) {
		this.alquilerRepository = alquilerRepository;
	}

	public List<Alquiler> obtenerTodos() {
		List<Alquiler> alquileres = new ArrayList<>();
		alquilerRepository.findAll().forEach(alquileres::add);
		return alquileres;
		}

	public Alquiler guardar(Alquiler alquiler) {
	    return alquilerRepository.save(alquiler);
	}
	
}
