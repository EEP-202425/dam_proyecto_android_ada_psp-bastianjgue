package com.example.proyecto.dto;

public class AlquilerDTO {

    private int registroAlquiler;
    private String horasAlquiladas;
    private String nombreCliente;
    private String apellidoCliente;
    private String tipoVehiculo;
    private String color;
    private int idVehiculo;
    
    public AlquilerDTO() {
    	
    }

    public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public int getRegistroAlquiler() {
        return registroAlquiler;
    }

    public void setRegistroAlquiler(int registroAlquiler) {
        this.registroAlquiler = registroAlquiler;
    }

    public String getHorasAlquiladas() {
        return horasAlquiladas;
    }

    public void setHorasAlquiladas(String horasAlquiladas) {
        this.horasAlquiladas = horasAlquiladas;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
