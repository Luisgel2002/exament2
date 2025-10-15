package com.LP2_T2_LEON_LUIS.SPRING_EXAMEN_CRUD.model;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "tbl_rubro")
@DynamicInsert
@Getter @Setter
public class Rubro {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_rubro")
	public Integer idRubro;
	
	
	@Column(name = "denominacion")
	public String denominacion;
	
	public String toString() {
		return denominacion;
	}
}
