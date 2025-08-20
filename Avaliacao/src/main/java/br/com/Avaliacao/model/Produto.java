package br.com.Avaliacao.model;

public class Produto {
	
	private Long id;
	private String nome;
	private String descricao;
	private int quantidade;
	private double valor;
	
	// CONSTRUTOR VAZIO.
	public Produto() {     
		
	}

	// CONSTRUTOR CHEIO.
	public Produto(Long id, String nome, String descricao, int quantidade, double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	

	@Override
	public String toString() {
		return "Produto [ID = " + id + ", Nome = " + nome + ", Descricao = " + descricao + ", Quantidade= "+ quantidade +", Valor= " + valor + "]";
	}
	
	
	// METODOS DE GETTERS E SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
	
	
	
	
	

}
