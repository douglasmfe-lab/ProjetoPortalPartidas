package br.com.projetoPartidas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.projetoPartidas.dao.PessoaDao;
import br.com.projetoPartidas.model.Pessoa;

@Named("beanPessoa")
@SessionScoped
public class BeanPessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	PessoaDao dao;

	Pessoa pessoa = new Pessoa();
	
	private List<Pessoa> pessoaList = new ArrayList<>();
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public List<Pessoa> getPessoaList() {
		pessoaList = dao.listAll();
		return pessoaList;
	}

	public String add() {
		dao.adiciona(pessoa);
		cleanList();
		return "usuario.xhtml?faces-redirect=true";
	}
	
	public void deletaPessoa() {
		dao.deleta(pessoa);
	}
	
	public void cleanList() {
		pessoa = new Pessoa();
	}
}
