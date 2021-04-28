package com.example.dto;


import java.util.List;


public class Pedido {
	
	
	private String serialCompra;
	
	private Cliente clientecompra;
	
	private List<Producto> producList;
	
	private Double domicilio;
	
	private Double iva;
	
	private Double total;
	
	private int hora;
	
	

	public String getSerialCompra() {
		return serialCompra;
	}

	public void setSerialCompra(String serialCompra) {
		this.serialCompra = serialCompra;
	}

	public Cliente getClientecompra() {
		return clientecompra;
	}

	public void setClientecompra(Cliente clientecompra) {
		this.clientecompra = clientecompra;
	}

	public List<Producto> getProducList() {
		return producList;
	}

	public void setProducList(List<Producto> producList) {
		this.producList = producList;
	}

	public Double getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Double domicilio) {
		this.domicilio = domicilio;
	}


	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}
	
	


	


	
	
	
	
	
	

}
