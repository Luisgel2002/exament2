package com.LP2_T2_LEON_LUIS.SPRING_EXAMEN_CRUD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LP2_T2_LEON_LUIS.SPRING_EXAMEN_CRUD.dto.ResultadoResponse;
import com.LP2_T2_LEON_LUIS.SPRING_EXAMEN_CRUD.model.OrdenCompra;
import com.LP2_T2_LEON_LUIS.SPRING_EXAMEN_CRUD.repository.OrdenCompraRepository;

@Service
public class OrdenCompraService {
	
	@Autowired
	private OrdenCompraRepository ordenCompraRepository;
	
	public List<OrdenCompra> getAll() {
		return ordenCompraRepository.findAll();
	}
	
	public ResultadoResponse create(OrdenCompra ordenCompra) {
		try {
			OrdenCompra ordencompraRegistrado = ordenCompraRepository.save(ordenCompra);
			
			String mensaje = String.format("OrdenCompra registrado con Id %s", ordencompraRegistrado.getNroOrden());
			return new ResultadoResponse(true, mensaje);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Error en OrdenCompraService: "+ e.getMessage());
		}
	}
	
	public OrdenCompra getOne(Integer id) {
		return ordenCompraRepository.findById(id).orElseThrow();
	}
	
	
	public ResultadoResponse update(OrdenCompra ordenCompra) {
		try {
			OrdenCompra ordenCompraregistrado = ordenCompraRepository.save(ordenCompra);
			
			String mensaje = String.format("orden actualizado con Id %s", ordenCompraregistrado.getNroOrden());
			return new ResultadoResponse(true, mensaje);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Error en ordenService: "+ e.getMessage());
		}
	}
	

}
