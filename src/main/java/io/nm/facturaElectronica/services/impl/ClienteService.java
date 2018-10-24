package io.nm.facturaElectronica.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.nm.facturaElectronica.model.Cliente;
import io.nm.facturaElectronica.persistence.IClienteDAO;
import io.nm.facturaElectronica.services.IClienteService;
import io.nm.facturaElectronica.util.TextValue;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	private IClienteDAO clienteDAO;

	@Override
	public Cliente getClienteById(int aObtener) {
		try {
			return clienteDAO.getClienteById(aObtener);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int addCliente(Cliente aAgregar) {
		int result = -1;
		try {
			result = clienteDAO.addCliente(aAgregar);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean editCliente(Cliente aEditar) {
		boolean result = false;
		try {
			result = clienteDAO.editCliente(aEditar);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<TextValue> searchCliente(String aBuscar) {
		try {
			return clienteDAO.searchCliente(aBuscar);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
