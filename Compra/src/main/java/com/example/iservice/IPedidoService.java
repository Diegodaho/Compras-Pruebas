package com.example.iservice;

import com.example.dto.FacturaCancelada;
import com.example.dto.Pedido;


public interface IPedidoService extends AbstractFacade<Pedido, String>{
	
	public Pedido modificarPedido(Pedido pedido);
	public Pedido guardarPedido(Pedido clase);
	public FacturaCancelada eliminar(String serial);
	

}
