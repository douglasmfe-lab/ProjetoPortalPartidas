package br.com.projetoPartidas.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.projetoPartidas.model.Pessoa;

public class UsuarioDao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	EntityManager manager = JpaUtil.getEntityManager();
	
	public boolean existe(Pessoa pessoa) {
		
		TypedQuery<Pessoa> query = manager.createQuery(""
				+ "select u from Usuario u "
				+ "where u.email = :pEmail and u.senha = :pSenha", Pessoa.class);
		
		query.setParameter("pEmail", pessoa.getEmail());
		query.setParameter("pSenha", pessoa.getSenha());
		
		try {
			@SuppressWarnings("unused")
			Pessoa resultado = query.getSingleResult();
		} catch (NoResultException ex) {
			return false;
		}
		
		return true;
	}
}
