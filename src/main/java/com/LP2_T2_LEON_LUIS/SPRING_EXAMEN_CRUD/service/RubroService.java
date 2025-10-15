package com.LP2_T2_LEON_LUIS.SPRING_EXAMEN_CRUD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LP2_T2_LEON_LUIS.SPRING_EXAMEN_CRUD.model.Proveedor;
import com.LP2_T2_LEON_LUIS.SPRING_EXAMEN_CRUD.model.Rubro;
import com.LP2_T2_LEON_LUIS.SPRING_EXAMEN_CRUD.repository.RubroRepository;

@Service
public class RubroService {
	
	@Autowired
	private RubroRepository rubroRepository;
	
	public List<Rubro>getAll(){
		return rubroRepository.findAll();
	}

}
