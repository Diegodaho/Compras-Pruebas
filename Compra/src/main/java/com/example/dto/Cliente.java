package com.example.dto;

import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

public class Cliente {
	
	@NotNull(message="Porfavor ingrese la Cedula")
	private String cedula;
	
	@NotNull(message="Porfavor ingrese la Direccion de vivienda")
	private String direccion;
	


	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	
	
	
	

	
	
	

}
