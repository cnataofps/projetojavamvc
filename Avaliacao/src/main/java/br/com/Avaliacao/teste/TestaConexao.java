package br.com.Avaliacao.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.Avaliacao.jdbc.ConnectionFactory;


public class TestaConexao {
	
	public static void main(String[] args) throws SQLException {
		Connection conexao = new ConnectionFactory().getConnection();
		System.out.println("Conectado com sucesso!!");
		conexao.close();
		
	}

}
