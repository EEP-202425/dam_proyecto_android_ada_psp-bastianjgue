package com.example.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Vehiculo;

public interface VehiculoRepository extends CrudRepository <Vehiculo, Integer>{
	
}
