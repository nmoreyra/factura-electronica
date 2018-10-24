package io.nm.facturaElectronica.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "ComprobanteTipos", indexes = { @Index(columnList = "id")})
public class ComprobanteTipo {
	private Integer id;
	private String descripcion;
	
	public ComprobanteTipo(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	
	public ComprobanteTipo(Integer id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
