package io.nm.facturaElectronica.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.nm.facturaElectronica.model.Cliente;
import io.nm.facturaElectronica.persistence.IClienteDAO;
import io.nm.facturaElectronica.util.TextValue;

@Transactional
@Repository
public class ClienteDAO implements IClienteDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Cliente getClienteById(int aObtener) {
		Cliente toReturn = null;
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Cliente> q = cb.createQuery(Cliente.class);
		Root<Cliente> c = q.from(Cliente.class);
		ParameterExpression<Integer> p = cb.parameter(Integer.class);
		TypedQuery<Cliente> query = entityManager.createQuery(q.select(c).where(cb.equal(c.get("id"), p)));
		query.setParameter(p, aObtener);
		List<Cliente> lRes = query.getResultList();
		if (lRes.size() > 0)
			toReturn = lRes.get(0);
		return toReturn;
	}

	@Override
	public int addCliente(Cliente aAgregar) {
		aAgregar.getoDomicilio().setoCliente(aAgregar);
		entityManager.persist(aAgregar);
		entityManager.flush();
		return aAgregar.getId();
	}

	@Override
	public boolean editCliente(Cliente aEditar) {
		try {
			Cliente result = entityManager.merge(aEditar);
			result.getoDomicilio().setoCliente(result);
			entityManager.flush();

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<TextValue> searchCliente(String aBuscar) {
		List<TextValue> toReturn = new ArrayList<TextValue>();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Cliente> q = cb.createQuery(Cliente.class);
		Root<Cliente> c = q.from(Cliente.class);
		ParameterExpression<String> p = cb.parameter(String.class);
		TypedQuery<Cliente> query = entityManager.createQuery(q.select(c).where(cb.like(c.get("razonSocial"), p)));
		query.setParameter(p, "%" + aBuscar + "%");
		List<Cliente> lRes = query.getResultList();

		for (Cliente oCli : lRes) {
			toReturn.add(new TextValue(oCli.getRazonSocial(), oCli.getId()));
		}

		return toReturn;
	}

}
