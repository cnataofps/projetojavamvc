package br.com.Avaliacao.view;

import java.util.Scanner;
import br.com.Avaliacao.controller.ProdutoController;
import br.com.Avaliacao.model.Produto;

public class ProdutoView {
	private ProdutoController controller;
	private Scanner scanner = new Scanner(System.in);
	
	public ProdutoView(ProdutoController controller) {
		this.controller = controller;
		
	}
	
	public void exibirMenu() {
		int opcao;
		do {
			System.out.println("\n MENU PRODUTO ");
			System.out.println("[1] - Adicionar Produtos");
			System.out.println("[2] - Listar Produtos");
			System.out.println("[3] - Remover Produtos");
			System.out.println("[4] - Pesquisar Produtos por ID");
			System.out.println("[5] - Alterar Produtos");
			System.out.println("Escolha a opção: ");
			opcao = scanner.nextInt();
			scanner.nextLine();
			
			switch(opcao) {
			
			case 1:
				adicionar();
				break;
			case 2:
				listar();
				break;
			case 3:
				remover();
				break;
			case 4:
				pesquisar();
				break;
			case 5:
				alterar();
				break;
			case 0:
				System.out.println("Saindo........");
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
				
				
			}
		}while (opcao != 0);
	}
	
	
	private void adicionar() {
		
		System.out.println("Nome do Produto: ");
		String nome = scanner.nextLine();
		System.out.println("Descrição do Produto: ");
		String descricao = scanner.nextLine();
		System.out.println("Quantidade do Produto: ");
		int quantidade = scanner.nextInt();
		System.out.println("Valor do Produto: ");
		double valor = scanner.nextDouble();
		
		controller.adicionarProduto(nome, descricao, quantidade, valor);
		System.out.println("Produto adicionado com sucesso!");
	}
	
	private void listar() {
		
		System.out.println("\n Lista de Produtos:");
		for (Produto p: controller.listarProdutos()) {
			System.out.println(p);
		}
		
	}
	
	private void remover() {
		
		System.out.println("ID do produto a remover: ");
		long id = scanner.nextLong();
		scanner.nextLine();
		if(controller.removerProduto(id)) {
			System.out.println("Produto Removido!");
		}else {
			System.out.println("Produto não encontrado");
		}
	}
	
	private void pesquisar() {
		
		System.out.println("ID do produto: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		Produto p = controller.pesquisarProduto(id);
		if(p != null) {
			System.out.println(p);
		}else {
			System.out.println("Produto não encontrado");
		}
	}
	
	private void alterar() {
		System.out.println("ID do produto para alterar: ");
		long id = scanner.nextLong();
		scanner.nextLine();
		
		System.out.println("Novo nome do produto: ");
		String nome = scanner.nextLine();
		System.out.println("Nova descrição do produto: ");
		String descricao = scanner.nextLine();
		System.out.println("Nova quantidade do produto: ");
		int quantidade = scanner.nextInt();
		System.out.println("Novo valor do produto: ");
		double valor = scanner.nextDouble();
		
		if(controller.alterarProduto(id, nome, descricao, quantidade, valor)) {
			System.out.println("Produto alterado com sucesso!");
		}else {
			System.out.println("Produto não encontrado.");
		}
		
		
		
	}

}
