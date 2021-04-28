package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.Producto;
import com.example.exeption.BusinessLogicException;
import com.example.iservice.IProductoService;

@Service
public class ProductoService implements IProductoService {
	
	public List<Producto> listapro = new ArrayList<>(); 

	@Override
	public void gusardarFacade(Producto clase) {
		
		for(Producto pro: listapro) {
			
			if(clase.getSerial().equals(pro.getSerial())) {
				
				throw new BusinessLogicException("Ya esxiste el serial del Producto");
			}
		}
		
	listapro.add(clase);

	}

	@Override
	public List<Producto> listarPaginadoFacade() {
		
		return listapro;
		
		
	}

}
