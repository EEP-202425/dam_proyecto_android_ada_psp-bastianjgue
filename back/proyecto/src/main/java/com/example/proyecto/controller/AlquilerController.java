package com.example.proyecto.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto.models.Alquiler;
import com.example.proyecto.service.AlquilerService;



@RestController
@RequestMapping("/alquileres")
public class AlquilerController {


    private final AlquilerService alquilerService;

    public AlquilerController(AlquilerService alquilerService) {
        this.alquilerService = alquilerService;
    }

    @GetMapping
    public ResponseEntity<List<Alquiler>> findAll() {
        return ResponseEntity.ok(alquilerService.obtenerTodos());
    }

}
