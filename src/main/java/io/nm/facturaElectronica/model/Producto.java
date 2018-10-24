package io.nm.facturaElectronica.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Productos", indexes = { @Index(columnList = "codigo")})
public class Producto {
	private String codigo;
	private String nombre;
	private BigDecimal precio;
	private CondicionIva oCondicionIva;
	
	@Id
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idCondicionIva")
	public CondicionIva getoCondicionIva() {
		return oCondicionIva;
	}
	public void setoCondicionIva(CondicionIva oCondicionIva) {
		this.oCondicionIva = oCondicionIva;
	}

	

}
