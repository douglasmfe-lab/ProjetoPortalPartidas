package br.com.projetoPartidas.dao;

import java.util.List;

public interface DAO<T> {
	
	public void adiciona(T t);
	
	public void deleta(T t);
	
	public List<T> listAll();

}
