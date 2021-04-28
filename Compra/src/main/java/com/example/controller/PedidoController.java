package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Cliente;
import com.example.dto.FacturaCancelada;
import com.example.dto.Pedido;
import com.example.iservice.IPedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private IPedidoService service;
	
	@PostMapping("/guardar")
	public ResponseEntity<Pedido> guardar(@Valid @RequestBody Pedido obj) {
		Pedido ped =service.guardarPedido(obj);
		return new ResponseEntity<Pedido>(ped,HttpStatus.OK);
	}
	
	@GetMapping("/listar")
	public  ResponseEntity<List<Pedido>> rentorPageable() {		
		List<Pedido> listarAutor = service.listarPaginadoFacade();
		return new ResponseEntity<List<Pedido>>(listarAutor, HttpStatus.OK);
	}
	
	@PutMapping("/modificar")
	public ResponseEntity<Pedido> modificar(@Valid @RequestBody Pedido obj) {
		Pedido pedU =service.modificarPedido(obj);
		return new ResponseEntity<Pedido>(pedU,HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{serial}")
	public ResponseEntity<FacturaCancelada> eliminar(@PathVariable String serial)  {
		FacturaCancelada mostrar=service.eliminar(serial);
			return new ResponseEntity<FacturaCancelada>(mostrar,HttpStatus.OK);					
	}
	
	

	

}
