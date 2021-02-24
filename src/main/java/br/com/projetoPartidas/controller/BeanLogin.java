package br.com.projetoPartidas.controller;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.projetoPartidas.model.Pessoa;

@Named("beanLogin")
public class BeanLogin implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pessoa pessoa;
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public String efetuarLogin() {
		System.out.println("Fazendo login user " + this.pessoa.getNome());
		return "partida?faces-redirect=true";
	}
}
