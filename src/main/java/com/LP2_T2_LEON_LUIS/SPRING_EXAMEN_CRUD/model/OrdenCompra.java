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
@Table(name = "tbl_orden_compra")
@DynamicInsert
@Getter @Setter
public class OrdenCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "nro_orden")
	public Integer nroOrden;
	
	@Column(name="monto")
	public Double monto;
	
	@Column(name="direccion_entrega")
	public String direccionEntrega;
	
	@Column(name="fecha_entrega")
	public Date fechaEntrega;

	@Column(name="estado")
	public String estado;
	
	@ManyToOne
	@JoinColumn(name = "id_proveedor", nullable= false)
	private Proveedor proveedor;
	
	
}
