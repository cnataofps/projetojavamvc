package br.com.Avaliacao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/bdProduto";
			return DriverManager.getConnection(url,"root","230497Lm@");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
			
		}
		
	}

}
