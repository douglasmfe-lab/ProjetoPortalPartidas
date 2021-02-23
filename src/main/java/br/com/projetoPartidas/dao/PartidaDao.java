package br.com.projetoPartidas.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.projetoPartidas.model.Partida;

public class PartidaDao implements DAO<Partida>, Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void adiciona(Partida t) {
		EntityManager manager = JpaUtil.getEntityManager();
		try {
			manager.getTransaction().begin();
			manager.persist(t);
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.getStackTrace();
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	@Override
	public void deleta(Partida t) {
		EntityManager manager = JpaUtil.getEntityManager();
			try {
				manager.getTransaction().begin();
				manager.remove(t);
				manager.getTransaction().commit();
			}
			catch (Exception e) {
				e.getStackTrace();
				manager.getTransaction().rollback();
			}
			finally {
				manager.close();
			}
			
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Partida> listAll() {
		EntityManager manager = JpaUtil.getEntityManager();
		return manager.createQuery("select p from Partida p").getResultList();
	}

}
