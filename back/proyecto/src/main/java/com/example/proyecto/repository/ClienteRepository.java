package com.example.proyecto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.proyecto.models.Cliente;


@Repository
public interface ClienteRepository extends CrudRepository <Cliente, Integer>{

}
	

