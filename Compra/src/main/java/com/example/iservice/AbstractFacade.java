package com.example.iservice;

import java.util.List;


public abstract interface AbstractFacade <T, V> {
	
	public void gusardarFacade(T clase);
	public List<T> listarPaginadoFacade();

}
