package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.Cliente;
import com.example.exeption.BusinessLogicException;
import com.example.iservice.IClienteService;

@Service
public class ClienteService implements IClienteService{
	
   public List<Cliente> clientes = new ArrayList<>();

	@Override
	public void gusardarFacade(Cliente clase) {
		
		
		
		for(Cliente cli: clientes) {
			
			if(cli.getCedula().equals(clase.getCedula())) {
				
				throw new BusinessLogicException("La cedula ya existe");
				
			}
			
		}
		
		clientes.add(clase);
		
	}

	@Override
	public List<Cliente> listarPaginadoFacade() {
		
		return clientes;
	}


		

		
		
	

}
