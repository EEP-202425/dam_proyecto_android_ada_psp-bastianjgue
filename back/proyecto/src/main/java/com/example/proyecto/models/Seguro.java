package com.example.proyecto.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Seguro {

    public enum TipoSeguro {
        COCHE("seguro caro"), BICI("seguro medio"), SCOOTER("seguro barato");
    
    	private final String descripcion;

    	TipoSeguro(String descripcion) {
    	    this.descripcion = descripcion;
    	}

    	public String getDescripcion() {
    	    return descripcion;
    	}
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoSeguro;

    private TipoSeguro tipo; 

    public Seguro() {
    }

    public Seguro(int codigoSeguro, TipoSeguro tipo) {
        this.codigoSeguro = codigoSeguro;
        this.tipo = tipo;
    }

    public int getCodigoSeguro() {
        return codigoSeguro;
    }

    public void setCodigoSeguro(int codigoSeguro) {
        this.codigoSeguro = codigoSeguro;
    }

    public TipoSeguro getTipo() {
        return tipo;
    }

    public void setTipo(TipoSeguro tipo) {
        this.tipo = tipo;
    }

	@Override
	public String toString() {
		return "Seguro [codigoSeguro=" + codigoSeguro + ", tipo=" + tipo + "]";
	}
    
}

