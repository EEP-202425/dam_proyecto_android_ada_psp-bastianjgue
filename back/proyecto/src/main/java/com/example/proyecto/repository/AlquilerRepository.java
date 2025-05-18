package com.example.proyecto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.proyecto.models.Alquiler;


@Repository
public interface AlquilerRepository extends CrudRepository <Alquiler, Integer>{

}
	
