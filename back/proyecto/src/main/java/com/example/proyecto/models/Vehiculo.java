package com.example.proyecto.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.JoinColumn;

@Entity
public class Vehiculo {
	
    public enum TipoVehiculo {
        COCHE("Volkswagen Polo"), BICI("Bianchi Alivio"), SCOOTER("Bongo V70");
        
    	private final String marcaVehiculo;

    	TipoVehiculo(String marcaVehiculo) {
    	    this.marcaVehiculo = marcaVehiculo;
    	}

    	public String getDescripcion() {
    	    return marcaVehiculo;
    	}
    }
	
	
    public enum ColorVehiculo {
        ROJO, AZUL, NEGRO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVehiculo;

    @Enumerated(EnumType.STRING)
    private TipoVehiculo tipo;

    @Enumerated(EnumType.STRING)
    private ColorVehiculo color;
	
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "codigo_seguro")
    private Seguro seguro;
    
    public Vehiculo() {
    	
    }
	
	public Vehiculo(TipoVehiculo tipo, ColorVehiculo color, int idVehiculo) {
		this.tipo = tipo;
		this.color = color;
		this.idVehiculo = idVehiculo;
	}
	
    public TipoVehiculo getTipoVehiculo() {
        return tipo;
    }

    public ColorVehiculo getColorVehiculo() {
        return color;
    }

	public void setTipoVehiculo(TipoVehiculo tipo) {
		this.tipo = tipo;
	}

	public void setColorVehiculo(ColorVehiculo color) {
		this.color = color;
	}
	
	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	
	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	@Override
	public String toString() {
		return "Vehiculo [idVehiculo=" + idVehiculo + ", tipo=" + tipo + ", color=" + color + ", seguro=" + seguro
				+ "]";
	}

}
