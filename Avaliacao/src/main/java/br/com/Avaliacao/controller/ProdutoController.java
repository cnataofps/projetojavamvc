package br.com.Avaliacao.controller;

import java.util.List;
import br.com.Avaliacao.dao.ProdutoDao;
import br.com.Avaliacao.model.Produto;

public class ProdutoController {
	
	private ProdutoDao dao;
	
	public ProdutoController(ProdutoDao dao) {
		this.dao = dao;
	}
	
	
	
	public void adicionarProduto(String nome, String descricao, int quantidade, double valor) {
		Produto p = new Produto(null, nome, descricao, quantidade, valor);
		dao.adiciona(p);
	}
	
	
	
	public List<Produto> listarProdutos() {
		return dao.getLista();
	}
	
	
	
	public boolean removerProduto(long id) {
		Produto p = dao.pesquisa((int) id);
		if (p != null) {
			dao.remove(id);
			return true;
		}
		return false;
	}
	
	
	public Produto pesquisarProduto(int id) {
		return dao.pesquisa(id);
	}
	
	
	public boolean alterarProduto(long id, String nome, String descricao, int quantidade, double valor) {
		Produto p = dao.pesquisa((int) id);
		if( p != null) {
			p.setNome(nome);
			p.setDescricao(descricao);
			p.setQuantidade(quantidade);
			p.setValor(valor);
			dao.altera(p);
			return true;
			
		}
		return false;
	}
	
	
	
	
	
	
	
}
