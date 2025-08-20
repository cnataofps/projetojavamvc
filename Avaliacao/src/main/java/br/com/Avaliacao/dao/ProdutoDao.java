package br.com.Avaliacao.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.Avaliacao.jdbc.ConnectionFactory;
import br.com.Avaliacao.model.Produto;
import java.sql.SQLTimeoutException;


public class ProdutoDao {
	private Connection connection;
	
	public ProdutoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	// METODO PARA ADICIONAR PRODUTOS
	
	public void adiciona(Produto produto) {
		String sql = "INSERT INTO produtos" + "(nome,descricao,quantidade,valor)" + "VALUES (?,?,?,?)";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getDescricao());
			stmt.setInt(3, produto.getQuantidade());
			stmt.setDouble(4, produto.getValor());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	// METODO PARA LISTAR OS PRODUTOS.
	
	public List<Produto> getLista() {
		try {
			List<Produto> produtos = new ArrayList<>();
			
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM produtos");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Produto produto = montaProdutoComResultSet(rs);
				produtos.add(produto);
			}
			return produtos;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	// METODO PARA PESQUISAR OS PRODUTOS POR ID.S
	
	
	public Produto pesquisa(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = this.connection.prepareStatement("SELECT * FROM produtos WHERE id = ?");
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();  // EXECUTAR A CONSULTA POR ID
			
	// VERIFICAR SE ENCONTROU O PRODUTO
			
			if (rs.next()) {
				return montaProdutoComResultSet(rs);
			}else {
				return null;  // RETORNAR NULL SE NÃO ENCONTRAR O PRODUTO.
			}
			
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao realizar a pesquisa no banco de dados!!",e);
		}finally {
	// FECHAR OS RECURSOS.
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				
			}catch (SQLException e) {
				throw new RuntimeException("Erro ao fechar recursos",e);
			}
		}
		
	}
	// METODO PARA REMOVER PELO ID.
	
	public void remove(long id) {
		
		String sql = "DELETE FROM produtos WHERE ID = ?";
		
		try(PreparedStatement stmt = this.connection.prepareStatement(sql)){
			stmt.setLong(1, id);  // DEFINE O ID DO PRODUTO A SER REMOVIDO
			stmt.executeUpdate(); // EXECUTA A EXCLUSÃO SELECIONADA PELO USUARIO.
		}catch(SQLException e) {
			throw new RuntimeException("Erro ao remover o contato",e);
		}
	}
	
	// METODO PARA ALTERAR O PRODUTO.
	
	public void altera(Produto produto) {
		String sql = "UPDATE produtos SET nome = ?, descricao = ?, quantidade = ?, valor = ? WHERE id = ?";
		try(PreparedStatement stmt = this.connection.prepareStatement(sql)){
			stmt.setString(1,produto.getNome());
			stmt.setString(2,produto.getDescricao());
			stmt.setInt(3,produto.getQuantidade());
			stmt.setDouble(4,produto.getValor());
			
		}catch(SQLException e) {
			throw new RuntimeException("Erro ao alterar o produto",e);
		}
	}
	
	private Produto montaProdutoComResultSet(ResultSet rs) {
		try {
			Produto produto = new Produto();
			
			produto.setId(rs.getLong("id"));
			produto.setNome(rs.getString("nome"));
			produto.setDescricao(rs.getString("descricao"));
			produto.setQuantidade(rs.getInt("quantidade"));
			produto.setValor(rs.getDouble("valor"));
			
			return produto;
			
		}catch (SQLException e) {
			// TENTOU ACESSAR UM CAMPO QUE NÃO EXISTE NA TABELA.
			throw new RuntimeException(e);
		}
	}
	
}

