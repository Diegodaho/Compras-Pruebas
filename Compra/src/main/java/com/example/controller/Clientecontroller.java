package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Cliente;
import com.example.dto.Pedido;
import com.example.iservice.IClienteService;



@RestController
@RequestMapping("/clientes")
public class Clientecontroller {
	
	@Autowired
	private IClienteService service;
	
	@PostMapping("/guardar")
	public ResponseEntity<Object> guardar(@Valid @RequestBody Cliente obj) {
		service.gusardarFacade(obj);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@GetMapping("/listar")
	public  ResponseEntity<List<Cliente>> rentorPageable() {		
		List<Cliente> listarAutor = service.listarPaginadoFacade();
		return new ResponseEntity<List<Cliente>>(listarAutor, HttpStatus.OK);
	}
	
	
	
	
}
