package com.example.proyecto.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto.models.Vehiculo;
import com.example.proyecto.service.VehiculoService;




@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

	private final VehiculoService vehiculoService;

	public VehiculoController (VehiculoService vehiculoService) {
		this.vehiculoService = vehiculoService;
	}

	@GetMapping
	public ResponseEntity<List<Vehiculo>> findAll() {
		return ResponseEntity.ok(vehiculoService.obtenerTodos());
	}
	    

}
