package com.example.proyecto.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Alquiler {
	
	public enum HorasAlquiladas{
		PLAZO_CORTO("5 horas"), PLAZO_MEDIO("7 horas"), PLAZO_LARGO("10 horas");
		
		private final String cantidadHoras;
		
		HorasAlquiladas(String cantidadHoras) {
			this.cantidadHoras = cantidadHoras;
		}
		
		public String getCantidadHoras() {
			return cantidadHoras;
		}
		
	}

	private HorasAlquiladas horasAlquiladas;
	
	@OneToOne
	@JoinColumn(name = "cliente_id", referencedColumnName = "id")
	
	private Cliente clienteId;
	
    @OneToOne
    @JoinColumn(name = "vehiculo_id", referencedColumnName = "idVehiculo")
	private Vehiculo vehiculoId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int registroAlquiler;
	
	public Alquiler() {
		
	}
	
	public Alquiler(HorasAlquiladas horasAlquiladas, Cliente clienteId, Vehiculo vehiculoId, int registroAlquiler) {
		this.vehiculoId = vehiculoId;
		this.horasAlquiladas = horasAlquiladas;
		this.clienteId = clienteId;
		this.registroAlquiler = registroAlquiler;
	}

	public HorasAlquiladas getHorasAlquiladas() {
		return horasAlquiladas;
	}

	public void setHorasAlquiladas(HorasAlquiladas horasAlquiladas) {
		this.horasAlquiladas = horasAlquiladas;
	}

	public Cliente getClienteId() {
		return clienteId;
	}

	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
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

	@Override
	public String toString() {
		return "Alquiler [horasAlquiladas=" + horasAlquiladas + ", clienteId=" + clienteId + ", vehiculoId="
				+ vehiculoId + ", registroAlquiler=" + registroAlquiler + "]";
	}
	
	
}
