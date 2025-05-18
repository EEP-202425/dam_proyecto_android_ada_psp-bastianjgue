package com.example.proyecto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.proyecto.models.Cliente;
import com.example.proyecto.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public List<Cliente> obtenerTodos() {
		List<Cliente> clientes = new ArrayList<>();
		clienteRepository.findAll().forEach(clientes::add);
		return clientes;
		}

	public Cliente guardar(Cliente alquiler) {
	    return clienteRepository.save(alquiler);
	}
}
