package br.com.projetoPartidas.controller;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.projetoPartidas.dao.PessoaDao;
import br.com.projetoPartidas.model.Pessoa;

public class BeanLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	private Pessoa pessoa = new Pessoa();

	@Inject
	PessoaDao dao;

	@Inject
	FacesContext context;

	public String efetuarLogin() {
//		boolean existe = dao.existe(this.pessoa);// continuar implantar amanhã
		if (true) {
			context.getExternalContext().getSessionMap().put("PessoaLogado", this.pessoa);

			return "usuario?faces-redirect=true";
		}

	//	context.getExternalContext().getFlash().setKeepMessages(true);
//		context.addMessage(null, new FacesMessage("Usuário não encontrado")); continuar implantar amanhã

		return "login?faces-redirect=true";
	}

	public String deslogar() {
		context.getExternalContext().getSessionMap().remove("PessoaLogado");

		return "login?faces-redirect=true";
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
}
