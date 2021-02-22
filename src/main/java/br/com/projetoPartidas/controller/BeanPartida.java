package br.com.projetoPartidas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.projetoPartidas.model.Partida;

@Named("beanPartida")
@SessionScoped
public class BeanPartida implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	Partida partida = new Partida();
	
	List<Partida> partidaList = new ArrayList<>();

	public Partida getPartida() {
		return partida;
	}

	public List<Partida> getPartidaList() {
		return partidaList;
	}
	
	public String add() {
		partidaList.add(partida);
		cleanList();
		return null;
	}
	
	public void cleanList() {
		partida = new Partida();
	}
}
