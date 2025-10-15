package com.LP2_T2_LEON_LUIS.SPRING_EXAMEN_CRUD.model;

import java.sql.Date;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "tbl_proveedor")
@DynamicInsert
@Getter @Setter
public class Proveedor {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "id_proveedor")
	public Integer idProveedor;
	
	@Column(name = "ruc")
	public String ruc;
	
	
	@Column(name = "razon_social")
	public String razonSocial;
	
	@Column(name = "fecha_registro")
	public Date fechaRegistro;
	
	@Column(name = "direccion")
	public String direccion;
	
	
	@Column( name = "pagina_web")
	public String paginaWeb;
	
	@ManyToOne
	@JoinColumn(name = "id_rubro")
	private Rubro rubro;
	

}
