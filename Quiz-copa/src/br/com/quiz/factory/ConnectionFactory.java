package br.com.quiz.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      return DriverManager.getConnection("jdbc:mysql://localhost/quiz", "root", "host");
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
