package br.com.projetoPartidas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.projetoPartidas.model.Pessoa;

@Named("beanPessoa")
@SessionScoped
public class BeanPessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	Pessoa pessoa = new Pessoa();
	
	private List<Pessoa> pessoaList = new ArrayList<>();
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public List<Pessoa> getPessoaList() {
		return pessoaList;
	}

	public String add() {
		pessoaList.add(pessoa);
		cleanList();
		return null;
	}
	
	public void cleanList() {
		pessoa = new Pessoa();
	}
}
