package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.dao.ClienteRepository;
import com.example.model.Cliente;


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
