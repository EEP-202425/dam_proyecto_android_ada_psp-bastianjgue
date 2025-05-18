package com.example.proyecto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.proyecto.models.Vehiculo;


@Repository
public interface VehiculoRepository extends CrudRepository <Vehiculo, Integer>{
	
}
