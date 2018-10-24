package io.nm.facturaElectronica.persistence;


import java.util.List;

import io.nm.facturaElectronica.model.Cliente;
import io.nm.facturaElectronica.util.TextValue;

public interface IClienteDAO {
	public Cliente getClienteById(int aObtener);
	
	public int addCliente(Cliente aAgregar);
	
	public boolean editCliente(Cliente aEditar);
	
	public List<TextValue> searchCliente(String aBuscar);
}
