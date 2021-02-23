package br.com.projetoPartidas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.projetoPartidas.dao.PartidaDao;
import br.com.projetoPartidas.dao.PessoaDao;
import br.com.projetoPartidas.model.Partida;

@Named("beanPartida")
@SessionScoped
public class BeanPartida implements Serializable {
	private static final long serialVersionUID = 1L;
	
	Partida partida = new Partida();
	private Integer partidaId;
	private Integer PessoaId;
	
	private List<Partida> partidaList = new ArrayList<Partida>();

	@Inject
	PartidaDao partidaDao;
	
	@Inject
	private PessoaDao pessoaDao;
	
	@Inject
	FacesContext context;
	
	
	public List<Partida> getPartidaLista() {
		return partidaList;
	}
	
	
	public void carregarPartidaPeloId() {
//		this.partida = partidaDao.buscaPorId(partidaId);
	}
	
	
	public void gravar() {
		System.out.println("Gravando partida " + this.partida.getNomeEvento());
		
		if (partida.getNomeEvento().isEmpty()) {
			context.addMessage("Nome do evento", new FacesMessage("A partida deve ter um nome"));
		}
		
		if (this.partida.getId() == null) {
			partidaDao.adiciona(this.partida);
//			this.partida = (Partida) partidaDao.listaTodos();
		} else {
//			partidaDao.atualiza(this.partida);
		}
		
		this.partida = new Partida();
	}
	
	@Transactional
	public void remover(Partida partida) {
		System.out.println("Removendo partida: " + partida.getNomeEvento());
//		partidaDao.remove(partida);
	}
	
	public void carregar(Partida partida) {
		System.out.println("Carregando Partida");
//		this.partida = this.partidaDao.buscaPorId(partida.getId());
	}
	
	public String formPessoa() {
		System.out.println("chamando o formulário do usuario");
		return "pessoa?faces-redirect=true";
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

	
	public Partida getPartida() {
		return partida;
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
