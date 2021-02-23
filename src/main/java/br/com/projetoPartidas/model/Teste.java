package br.com.projetoPartidas.model;

import br.com.projetoPartidas.dao.PessoaDao;

public class Teste {
	
	public static void main(String[] args) {

		PessoaDao pessoaDao = new PessoaDao();
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Joao");
		pessoa.setApelido("John");
		pessoa.setEmail("joao@gmail.com");
		pessoa.setSenha(123);		
		
		pessoaDao.adiciona(pessoa);
	}
}
