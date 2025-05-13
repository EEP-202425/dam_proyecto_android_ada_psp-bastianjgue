package com.example.proyecto.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.proyecto.models.Vehiculo;



public interface VehiculoRepository extends CrudRepository <Vehiculo, Integer>{
	
}
