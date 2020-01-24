package br.com.agenda.marco.bd;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionFactory {

public Connection getConnection() {
		
		try {
			System.out.println("Conectando ao banco");
			Class.forName("com.mysql.jdbc.Driver");
			return (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "");
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}

