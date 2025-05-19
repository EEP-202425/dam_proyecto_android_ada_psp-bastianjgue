package com.example.proyecto.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto.dto.VehiculoDTO;
import com.example.proyecto.models.Seguro;
import com.example.proyecto.models.Vehiculo;
import com.example.proyecto.models.Vehiculo.ColorVehiculo;
import com.example.proyecto.models.Vehiculo.TipoVehiculo;
import com.example.proyecto.service.SeguroService;
import com.example.proyecto.service.VehiculoService;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

	private final VehiculoService vehiculoService;
	private final SeguroService seguroService;

	public VehiculoController (VehiculoService vehiculoService, SeguroService seguroService) {
		this.vehiculoService = vehiculoService;
		this.seguroService = seguroService;
	}

	@GetMapping
	public ResponseEntity<List<Vehiculo>> findAll() {
		return ResponseEntity.ok(vehiculoService.obtenerTodos());
	}
	    
	@PostMapping
	public ResponseEntity<Vehiculo> crearVehiculo(@RequestBody VehiculoDTO dto) {
	    Vehiculo vehiculo = new Vehiculo();
	    vehiculo.setTipoVehiculo(TipoVehiculo.valueOf(dto.getTipo().toUpperCase()));
	    vehiculo.setColorVehiculo(ColorVehiculo.valueOf(dto.getColor().toUpperCase()));

	    Seguro seguro = seguroService.crearSeguroPorTipoVehiculo(vehiculo.getTipoVehiculo());
	    vehiculo.setSeguro(seguro);

	    Vehiculo nuevo = vehiculoService.guardar(vehiculo);
	    return ResponseEntity.ok(nuevo);
	}

}
