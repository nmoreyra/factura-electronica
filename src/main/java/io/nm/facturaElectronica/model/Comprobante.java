package io.nm.facturaElectronica.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Comprobantes", indexes = { @Index(columnList = "id"), @Index(columnList = "activo"), @Index(columnList = "idComprobanteTipo"), @Index(columnList = "fecha") })
public class Comprobante {
	private Integer id;
	private ComprobanteTipo oTipo;
	private String prefijo;
	private String numero;
	private String letra;
	private Date fecha;
	private Date fechaAlta;
	private Usuario oUsuario;
	private CondicionVenta oCondicionVenta;
	private Cliente oCliente;
	private Set<ComprobanteProducto> productos = new HashSet<>();
	private String observaciones;
	private BigDecimal netoGravado;
	private BigDecimal netoNoGravado;
	private BigDecimal iva;
	private BigDecimal retencionIIBB;
	private BigDecimal retencionIIGG;
	private BigDecimal retencionIva;
	private BigDecimal cargasSociales;
	private BigDecimal total;
	private String cae;
	private Date fechaVencimientoCae;
	private String sucursal;
	private Boolean activo;
	
	public Comprobante(Integer id, ComprobanteTipo oTipo, String prefijo, String numero, String letra, Date fecha,
			Date fechaAlta, Usuario oUsuario, CondicionVenta oCondicionVenta, Cliente oCliente,
			Set<ComprobanteProducto> productos, String observaciones, BigDecimal netoGravado, BigDecimal netoNoGravado,
			BigDecimal iva, BigDecimal retencionIIBB, BigDecimal retencionIIGG, BigDecimal retencionIva,
			BigDecimal cargasSociales, BigDecimal total, String cae, Date fechaVencimientoCae, String sucursal, Boolean activo) {
		super();
		this.id = id;
		this.oTipo = oTipo;
		this.prefijo = prefijo;
		this.numero = numero;
		this.letra = letra;
		this.fecha = fecha;
		this.fechaAlta = fechaAlta;
		this.oUsuario = oUsuario;
		this.oCondicionVenta = oCondicionVenta;
		this.oCliente = oCliente;
		this.productos = productos;
		this.observaciones = observaciones;
		this.netoGravado = netoGravado;
		this.netoNoGravado = netoNoGravado;
		this.iva = iva;
		this.retencionIIBB = retencionIIBB;
		this.retencionIIGG = retencionIIGG;
		this.retencionIva = retencionIva;
		this.cargasSociales = cargasSociales;
		this.total = total;
		this.cae = cae;
		this.fechaVencimientoCae = fechaVencimientoCae;
		this.sucursal = sucursal;
		this.activo = activo;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idComprobanteTipo")
	public ComprobanteTipo getoTipo() {
		return oTipo;
	}
	public void setoTipo(ComprobanteTipo oTipo) {
		this.oTipo = oTipo;
	}
	public String getPrefijo() {
		return prefijo;
	}
	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idUsuario")
	public Usuario getoUsuario() {
		return oUsuario;
	}
	public void setoUsuario(Usuario oUsuario) {
		this.oUsuario = oUsuario;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCondicionVenta")
	public CondicionVenta getoCondicionVenta() {
		return oCondicionVenta;
	}
	public void setoCondicionVenta(CondicionVenta oCondicionVenta) {
		this.oCondicionVenta = oCondicionVenta;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCliente")
	public Cliente getoCliente() {
		return oCliente;
	}
	public void setoCliente(Cliente oCliente) {
		this.oCliente = oCliente;
	}
	
	@OneToMany(mappedBy = "oComprobante")
	public Set<ComprobanteProducto> getProductos() {
		return productos;
	}
	public void setProductos(Set<ComprobanteProducto> productos) {
		this.productos = productos;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public BigDecimal getNetoGravado() {
		return netoGravado;
	}
	public void setNetoGravado(BigDecimal netoGravado) {
		this.netoGravado = netoGravado;
	}
	public BigDecimal getNetoNoGravado() {
		return netoNoGravado;
	}
	public void setNetoNoGravado(BigDecimal netoNoGravado) {
		this.netoNoGravado = netoNoGravado;
	}
	public BigDecimal getIva() {
		return iva;
	}
	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}
	public BigDecimal getRetencionIIBB() {
		return retencionIIBB;
	}
	public void setRetencionIIBB(BigDecimal retencionIIBB) {
		this.retencionIIBB = retencionIIBB;
	}
	public BigDecimal getRetencionIIGG() {
		return retencionIIGG;
	}
	public void setRetencionIIGG(BigDecimal retencionIIGG) {
		this.retencionIIGG = retencionIIGG;
	}
	public BigDecimal getRetencionIva() {
		return retencionIva;
	}
	public void setRetencionIva(BigDecimal retencionIva) {
		this.retencionIva = retencionIva;
	}
	public BigDecimal getCargasSociales() {
		return cargasSociales;
	}
	public void setCargasSociales(BigDecimal cargasSociales) {
		this.cargasSociales = cargasSociales;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public String getCae() {
		return cae;
	}
	public void setCae(String cae) {
		this.cae = cae;
	}
	public Date getFechaVencimientoCae() {
		return fechaVencimientoCae;
	}
	public void setFechaVencimientoCae(Date fechaVencimientoCae) {
		this.fechaVencimientoCae = fechaVencimientoCae;
	}
	public String getSucursal() {
		return sucursal;
	}
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
}
