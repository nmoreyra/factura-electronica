package io.nm.facturaElectronica.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ComprobanteProductos")
public class ComprobanteProducto {
	private Integer id;
	private Comprobante oComprobante;
	private Integer numero;
	private Producto oProducto;
	private String nombreProducto;
	private Integer cantidad;
	private BigDecimal bonificacion;
	private BigDecimal precio;
	private Float alicuotaIva;

	public ComprobanteProducto(Integer id, Comprobante oComprobante, Integer numero, Producto oProducto,
			String nombreProducto, Integer cantidad, BigDecimal bonificacion, BigDecimal precio, Float alicuotaIva) {
		super();
		this.id = id;
		this.oComprobante = oComprobante;
		this.numero = numero;
		this.oProducto = oProducto;
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
		this.bonificacion = bonificacion;
		this.precio = precio;
		this.alicuotaIva = alicuotaIva;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "Comprobantes.id", nullable = false)
	public Comprobante getoComprobante() {
		return oComprobante;
	}
	public void setoComprobante(Comprobante oComprobante) {
		this.oComprobante = oComprobante;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "producto")
	public Producto getoProducto() {
		return oProducto;
	}
	public void setoProducto(Producto oProducto) {
		this.oProducto = oProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getBonificacion() {
		return bonificacion;
	}
	public void setBonificacion(BigDecimal bonificacion) {
		this.bonificacion = bonificacion;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public Float getAlicuotaIva() {
		return alicuotaIva;
	}
	public void setAlicuotaIva(Float alicuotaIva) {
		this.alicuotaIva = alicuotaIva;
	}
	
	
}
