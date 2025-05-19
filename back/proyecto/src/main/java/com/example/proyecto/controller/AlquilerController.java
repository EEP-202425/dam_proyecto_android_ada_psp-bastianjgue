package com.example.proyecto.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto.dto.AlquilerDTO;
import com.example.proyecto.mapper.AlquilerMapper;
import com.example.proyecto.models.Alquiler;
import com.example.proyecto.models.Cliente;
import com.example.proyecto.models.Vehiculo;
import com.example.proyecto.service.AlquilerService;
import com.example.proyecto.service.ClienteService;
import com.example.proyecto.service.VehiculoService;


@RestController
@RequestMapping("/api/alquileres")
public class AlquilerController {


    private final AlquilerService alquilerService;

    private final ClienteService clienteService;
    private final VehiculoService vehiculoService;


    public AlquilerController(AlquilerService alquilerService, ClienteService clienteService, VehiculoService vehiculoService) {
        this.alquilerService = alquilerService;
        this.clienteService = clienteService;
        this.vehiculoService = vehiculoService;
    }

    @GetMapping
    public ResponseEntity<List<Alquiler>> findAll() {
        return ResponseEntity.ok(alquilerService.obtenerTodos());
    }
    
    @PostMapping
    public ResponseEntity<AlquilerDTO> crearAlquiler(@RequestBody AlquilerDTO alquilerDTO) {
        Cliente cliente = new Cliente();
        cliente.setNombre(alquilerDTO.getNombreCliente());
        cliente.setApellido(alquilerDTO.getApellidoCliente());
        cliente = clienteService.guardar(cliente); 

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setTipoVehiculo(Vehiculo.TipoVehiculo.valueOf(alquilerDTO.getTipoVehiculo()));
        vehiculo.setColorVehiculo(Vehiculo.ColorVehiculo.valueOf(alquilerDTO.getColor()));
        vehiculo = vehiculoService.guardar(vehiculo);

        Alquiler alquiler = AlquilerMapper.toEntity(alquilerDTO, cliente, vehiculo);
        Alquiler nuevo = alquilerService.guardar(alquiler);

        return ResponseEntity.ok(AlquilerMapper.toDTO(nuevo));
    }





}
