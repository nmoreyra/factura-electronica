package io.nm.facturaElectronica.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;

@Entity
@Table(name = "Clientes", indexes = { @Index(columnList = "id")})
public class Cliente {
	private Integer id;
	private String dniCuit;
	private String razonSocial;
	private Domicilio oDomicilio;
	private String telefono;
	private String email;
	
	public Cliente() {}
	
	public Cliente(Integer id, String dniCuit, String razonSocial, Domicilio oDomicilio, String telefono,
			String email) {
		super();
		this.id = id;
		this.dniCuit = dniCuit;
		this.razonSocial = razonSocial;
		this.oDomicilio = oDomicilio;
		this.telefono = telefono;
		this.email = email;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDniCuit() {
		return dniCuit;
	}
	public void setDniCuit(String dniCuit) {
		this.dniCuit = dniCuit;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
	@JsonManagedReference
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "oCliente", cascade = CascadeType.ALL)
	public Domicilio getoDomicilio() {
		return oDomicilio;
	}
	public void setoDomicilio(Domicilio oDomicilio) {
		this.oDomicilio = oDomicilio;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
