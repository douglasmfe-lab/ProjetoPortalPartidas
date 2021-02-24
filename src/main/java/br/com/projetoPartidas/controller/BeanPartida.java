package br.com.projetoPartidas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.projetoPartidas.dao.PartidaDao;
import br.com.projetoPartidas.model.Partida;

@Named("beanPartida")
@SessionScoped
public class BeanPartida implements Serializable {
	private static final long serialVersionUID = 1L;
	
	Partida partida = new Partida();
	private Integer partidaId;
	
	private List<Partida> partidaList = new ArrayList<Partida>();

	@Inject
	PartidaDao partidaDao;
	
	@Inject
	FacesContext context;
	
	public Partida getPartida() {
		return partida;
	}
	
	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public Integer getPartidaId() {
		return partidaId;
	}

	public void setPartidaId(Integer partidaId) {
		this.partidaId = partidaId;
	}
	
	public List<Partida> getPartidaLista() {
		return partidaList;
	}
		
	@Transactional
	public void remover(Partida partida) {
		System.out.println("Removendo partida: " + partida.getNomeEvento());
		partidaDao.deleta(partida);
	}
	
	public List<Partida> getPartidaList() {
		partidaList = partidaDao.listAll();
		return partidaList;
	}
	
	public String add() {
		partidaDao.adiciona(partida);
		cleanList();
		return null;
	}
	
	public void cleanList() {
		partida = new Partida();
	}
}
