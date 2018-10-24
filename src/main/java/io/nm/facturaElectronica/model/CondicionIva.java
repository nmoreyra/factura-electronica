package io.nm.facturaElectronica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "CondicionesIva", indexes = { @Index(columnList = "id")})
public class CondicionIva {
	private Integer id;
	private String descripcion;
	private Float alicuota;
	
	public CondicionIva(Integer id, String descripcion, Float alicuota) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.alicuota = alicuota;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@Column(name = "alicuota", precision = 24, scale = 0)
	public Float getAlicuota() {
		return alicuota;
	}
	public void setAlicuota(Float alicuota) {
		this.alicuota = alicuota;
	}
	
	
}
