package com.example.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dto.Cliente;
import com.example.dto.FacturaCancelada;
import com.example.dto.Pedido;
import com.example.dto.Producto;
import com.example.exeption.ArgumentRequiredException;
import com.example.exeption.BusinessLogicException;
import com.example.exeption.ModelNotFoundException;
import com.example.iservice.IPedidoService;

@Service
public class PedidoServices implements IPedidoService{
	
	@Autowired
	private ClienteService cleinteService;
	
	@Autowired
	private ProductoService productoService;
	
	List<Pedido> pedidos = new ArrayList<>();
	List<FacturaCancelada> facturaCancelada = new ArrayList<>();
	
	
	

	@Override
	public Pedido guardarPedido(Pedido clase) {
		
		
		int intentosc=0;
		int intentosProdu =0;
		boolean shek=false;
		double precios = 0;
		String nombresm ="";
		String serial ="";
		boolean opcionc;
		double totalPedido=0;
		
		for(Pedido ps : pedidos) {
			
			if(clase.getSerialCompra().equals(ps.getSerialCompra())) {
				
				throw new BusinessLogicException("Ya existe el serial porfavor escoger otro serial");
				
				
				
			}
			
		}
		
		List<Producto> productos = new ArrayList<>();
		if(clase.getClientecompra()!=null && clase.getClientecompra().getCedula()!=null) {
			
			if(cleinteService.clientes.size()>0) {
				
				for(Cliente c: cleinteService.clientes ) {
					
					if(opcionc=c.getCedula().equals(clase.getClientecompra().getCedula())) {
							
						if(productoService.listapro.size()>0) {
							
							
							if(clase.getProducList().size()>0) {
								for(Producto pr:clase.getProducList()) {
									shek=false;
									
									for(Producto rp: productoService.listapro) {
										
									
										if(pr.getSerial().equals(rp.getSerial())) {
											
											shek=true;
											serial=pr.getSerial();
											nombresm=rp.getNombre();
											precios=rp.getPrecio();
											
											intentosProdu =intentosProdu+1;
												
											
										}
									
										
									}
									
									if(shek) {
										
										Producto prot = new Producto();
										
										prot.setSerial(serial);
										prot.setNombre(nombresm);
										prot.setPrecio(precios);
										productos.add(prot);
										
										totalPedido = totalPedido + precios;
										
										
									}	
							}
								
							if(intentosProdu==clase.getProducList().size()) {
								
								Pedido pe =new Pedido();
								pe.setSerialCompra(clase.getSerialCompra());
								
								Cliente clie = new Cliente();
								clie.setCedula(clase.getClientecompra().getCedula());
								clie.setDireccion(c.getDireccion());
								clase.setClientecompra(clie);
								clase.setProducList(productos);
								pe.setIva(clase.getIva());
								clase.setIva(totalPedido*0.19);
								
								
								
								if(totalPedido >70000.0 && totalPedido<=100000.0) {
									
									clase.setDomicilio(3800.0);

								}
								
								if(totalPedido >100000.0) {
									
									clase.setDomicilio(0.0);
									
								}
								if(totalPedido<=70000.0) {
									
									throw new ArgumentRequiredException("El total del los productos tiene"
											+ "que ser mayor a 70000");
									
								}
								
								
					            clase.setTotal(totalPedido+clase.getIva()+clase.getDomicilio());
								
								Calendar calendario = Calendar.getInstance();
								clase.setHora(calendario.get(Calendar.HOUR_OF_DAY));
					
			
									
									
								pedidos.add(clase);
								
							
							
							}
							else {
								
								throw new ModelNotFoundException("Un producto o varios productos no existen,"
										+ "forvafor verificar");
								
							}
								
								
							}
							else {
								
								throw new ModelNotFoundException("Profavor ingresar los Productos");
								
							}
							
						}
						else {
							throw new ModelNotFoundException("No hay productos");
							
						}
						
					}
					
					if(opcionc == false) {
						
						intentosc = intentosc+ 1;
						
					}
					if(intentosc== cleinteService.clientes.size()) {
						
						throw new ModelNotFoundException("El cliente no existe");
						
				    }
				}
			}
			else {
				
				throw new ModelNotFoundException("No hay clientes");
			}
		}
		else {
			
			throw new ArgumentRequiredException("Porfavor insertar el cliente ");
			
		}
				

			
			
		return clase;
		
	}

	@Override
	public List<Pedido> listarPaginadoFacade() {
		
		return pedidos;
	}

	@Override
	public Pedido modificarPedido(Pedido pedido) {
		
		int intentos = 0;
		boolean opcion;
		boolean opcionp =false;
		double totalPedido= 0;
		double precios = 0;
		String nombresm ="";
		String serial ="";
		int intentosProdu =0;
		List<Producto> productos = new ArrayList<>();
		Pedido pedid = new Pedido();
		
		
		if(pedido.getSerialCompra()==null) {
			
			throw new ArgumentRequiredException("Es Requerido el serial del pedido");
			
		}
		
		if(pedidos.size()>0) {
			
			for(Pedido ped : pedidos) {
				
				
				
				if(opcion=ped.getSerialCompra().equals(pedido.getSerialCompra()) 
						&&ped.getClientecompra().getCedula().equals(pedido.getClientecompra().getCedula()) 
						) {
					
				int index=pedidos.indexOf(ped);
					
					if(pedido.getProducList().size()>0) {
						for(Producto pr: pedido.getProducList()) {
							opcionp=false;
							
							for(Producto rp: productoService.listapro) {
								
								if(pr.getSerial().equals(rp.getSerial())) {
									
									opcionp=true;
									serial=pr.getSerial();
									nombresm=rp.getNombre();
									precios=rp.getPrecio();
									
									intentosProdu =intentosProdu+1;
										
									
								}
								
	
							}
							
							if(opcionp) {
								
								Producto prot = new Producto();
								
								prot.setSerial(serial);
								prot.setNombre(nombresm);
								prot.setPrecio(precios);
								productos.add(prot);
								
								totalPedido = totalPedido + precios;
								
								
							}	
						}
						
						if(intentosProdu==pedido.getProducList().size()) {
							
							
							
							ped.setProducList(productos);
							ped.setIva(totalPedido*0.19);
							
							
							
							if(totalPedido >70000.0 && totalPedido<=100000.0) {
								
								ped.setDomicilio(3800.0);

							}
							
							if(totalPedido >100000.0) {
								
								ped.setDomicilio(0.0);
								
							}
							if(totalPedido<=70000.0) {
								
								throw new ArgumentRequiredException("El total del los productos tiene"
										+ "que ser mayor a 70000");
								
							}
							
							
				            ped.setTotal(totalPedido+ped.getIva()+ped.getDomicilio());
				            
				        	Calendar calendario = Calendar.getInstance();
				        	
				            int hora = calendario.get(Calendar.HOUR_OF_DAY)-ped.getHora();
							calendario.set(Calendar.HOUR_OF_DAY, hora);
							int total =calendario.get(Calendar.HOUR_OF_DAY);
							
							if(total<=5) {
								
								pedidos.set(index, ped);
								
								pedid.setSerialCompra(ped.getSerialCompra());
								pedid.setClientecompra(ped.getClientecompra());
								pedid.setProducList(ped.getProducList());
								pedid.setIva(ped.getIva());
								pedid.setDomicilio(ped.getDomicilio());
								pedid.setTotal(ped.getTotal());
								pedid.setHora(ped.getHora());
								
								
								
								
								
							}else {
								
								throw new BusinessLogicException("El tiempo para editr de su pedido a caducado");
								
							}
			

					}else {
						throw new ArgumentRequiredException("Profavor Ingresar los Productos");
					}
				  }else {
						
						throw new ModelNotFoundException("Profavor ingresar los Productos");
						
					}
			
			    }if(opcion == false) {
					
					intentos = intentos+ 1;
					
				}
				if(intentos== cleinteService.clientes.size()) {
					
					throw new ModelNotFoundException("El cliente no existe");
					
			    }
				
		
		     }
			
			
			
	     }
		
		else {
	    	 
	    	 throw new ModelNotFoundException("No hay Pedidos");
	     }
		
		
		
		return pedid;
		
		

	}

	@Override
	public void gusardarFacade(Pedido clase) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FacturaCancelada eliminar(String serial) {
		
		int index=0;
		double diezCacelacion=0;
		boolean opcion;
		int intentos =0;
		Calendar calendario = Calendar.getInstance();
		
		FacturaCancelada cancelarpedi = new FacturaCancelada();
		
		if(pedidos.size()>0) {
			
			for(Pedido pedido:pedidos) {
				
				if(opcion=serial.equals(pedido.getSerialCompra())) {
					
					
					int hora = calendario.get(Calendar.HOUR_OF_DAY)-pedido.getHora();
					calendario.set(Calendar.HOUR_OF_DAY, hora);
					int total =calendario.get(Calendar.HOUR_OF_DAY);
					if(total <=12) {
						
						index= pedidos.indexOf(pedido);
						

					}
					else {
						
						
						Cliente cliente = new Cliente();
						cliente.setCedula(pedido.getClientecompra().getCedula());
						cliente.setDireccion(pedido.getClientecompra().getDireccion());
						diezCacelacion=pedido.getTotal()*0.10;
						
						cancelarpedi.setCliente(cliente);
						cancelarpedi.setValorExtraido(diezCacelacion);
						
						facturaCancelada.add(cancelarpedi);
						
						index= pedidos.indexOf(pedido);
			
						
					}
					
				}if(opcion == false) {
					
					intentos = intentos+ 1;
					
				}
				if(intentos== pedidos.size()) {
					
					throw new ModelNotFoundException("El cliente no existe");
					
			    }
				
			}
		}
		else {
			
			throw new ModelNotFoundException("La lista pedido esta vacia");
			
		}
		

		
		pedidos.remove(index);
		
		
		return cancelarpedi;
	}

					

}
