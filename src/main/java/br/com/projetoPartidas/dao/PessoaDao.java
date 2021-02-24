package br.com.projetoPartidas.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.projetoPartidas.model.Pessoa;

public class PessoaDao implements Serializable, DAO<Pessoa> {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> listAll() {
		EntityManager manager = JpaUtil.getEntityManager();
		return manager.createQuery("select p from Pessoa p").getResultList();
	}

	@Override
	public void adiciona(Pessoa t) {
		EntityManager manager = JpaUtil.getEntityManager();

		try {
			manager.getTransaction().begin();
			if (t.getId() == null) {
				manager.persist(t);
			} else {
				manager.merge(t);
			}
			manager.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}
	
	@Override
	public void deleta(Pessoa id) {
		EntityManager manager = JpaUtil.getEntityManager();
		try {
			manager.getTransaction().begin();
			Pessoa p = manager.find(Pessoa.class, id.getId());
			manager.remove(p.getId());
			manager.getTransaction().commit();

		} catch (Exception e) {
			e.getStackTrace();
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}
	
}
