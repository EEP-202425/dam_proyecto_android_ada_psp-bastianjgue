package com.example.proyecto.dto;

public class VehiculoDTO {
    private String tipo; // COCHE, BICI, SCOOTER
    private String color;
    
    public VehiculoDTO() {
    	
    }

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
    
    
}
