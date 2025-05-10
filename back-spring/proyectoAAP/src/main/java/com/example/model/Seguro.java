package com.example.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Seguro {
	
	public enum TipoSeguro {
		COCHE("Seguro caro"), BICI("Seguro medio"), SCOOTER("Seguro barato"); 
		
		private String string;
		
		 TipoSeguro (String string) {
			 this.string = string;
		 }
		 
		 public String getString() {
			 return string;
		 }
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoSeguro;
	private String seguroCoche;
	private String seguroBici;
	private String seguroScooter;

	public Seguro(String seguroCoche, String seguroBici, String seguroScooter) {
		this.seguroCoche = seguroCoche;
		this.seguroBici = seguroBici;
		this.seguroScooter = seguroScooter;
	}

	public String getSeguroCoche() {
		return seguroCoche;
	}

	public void setSeguroCoche(String seguroCoche) {
		this.seguroCoche = seguroCoche;
	}

	public String getSeguroBici() {
		return seguroBici;
	}

	public void setSeguroBici(String seguroBici) {
		this.seguroBici = seguroBici;
	}

	public String getSeguroScooter() {
		return seguroScooter;
	}

	public void setSeguroScooter(String seguroScooter) {
		this.seguroScooter = seguroScooter;
	}
	
	
	
}
