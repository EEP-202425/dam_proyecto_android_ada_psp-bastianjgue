package com.example.proyecto.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
public class Alquiler {

	private String horasAlquiladas;
	
	@OneToOne
	@JoinColumn(name = "cliente_id", referencedColumnName = "id")
	
	private Cliente clienteId;
	private LocalDateTime horaAlquiler;
	
    @OneToOne
    @JoinColumn(name = "vehiculo_id", referencedColumnName = "idVehiculo")
	private Vehiculo vehiculoId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int registroAlquiler;
	
	public Alquiler(String horasAlquiladas, Cliente clienteId, 
			LocalDateTime horaAlquiler, Vehiculo vehiculoId, int registroAlquiler) {
		this.vehiculoId = vehiculoId;
		this.horasAlquiladas = horasAlquiladas;
		this.clienteId = clienteId;
		this.horaAlquiler = horaAlquiler;
		this.registroAlquiler = registroAlquiler;
	}

	public String getHorasAlquiladas() {
		return horasAlquiladas;
	}

	public void setHorasAlquiladas(String horasAlquiladas) {
		this.horasAlquiladas = horasAlquiladas;
	}

	public Cliente getClienteId() {
		return clienteId;
	}

	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}

	public LocalDateTime getHoraAlquiler() {
		return horaAlquiler;
	}

	public void setHoraAlquiler(LocalDateTime horaAlquiler) {
		this.horaAlquiler = horaAlquiler;
	}

	public Vehiculo getVehiculoId() {
		return vehiculoId;
	}

	public void setVehiculoId(Vehiculo vehiculoId) {
		this.vehiculoId = vehiculoId;
	}

	public int getRegistroAlquiler() {
		return registroAlquiler;
	}

	public void setRegistroAlquiler(int registroAlquiler) {
		this.registroAlquiler = registroAlquiler;
	}
	
	
}
