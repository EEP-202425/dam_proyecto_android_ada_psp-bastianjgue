package com.example.proyecto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.proyecto.models.Seguro;


@Repository
public interface SeguroRepository extends CrudRepository <Seguro, Integer>{
}
	

