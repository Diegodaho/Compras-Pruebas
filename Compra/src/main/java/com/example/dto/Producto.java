package com.example.dto;

import javax.validation.constraints.NotNull;

public class Producto {
	
	@NotNull(message="Porfavor ingrese el Serial del Producto")
	private String serial;
	
	@NotNull(message="Porfavor ingrese el Nombre del Producto")
	private String nombre;
	
	@NotNull(message="Porfavor ingrese el Precio del Producto")
	private Double precio;
	

	

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	
	
	
	
	

}
