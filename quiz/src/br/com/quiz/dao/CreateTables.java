package br.com.quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.quiz.factory.ConnectionFactory;



public class CreateTables {

	private Connection connection;

	public CreateTables() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void createTablePerguntas() {
		String sql = "CREATE TABLE if not exists perguntas(idPerguntas IDENTITY PRIMARY KEY,"
				+ "questao varchar(500), "
				+ "alter_a varchar(300), "
				+ "alter_b varchar(300), "
				+ "alter_c varchar(300),"
				+ "alter_d varchar(300),"
				+ "resp_certa varchar(300),"
				+ "nivel INTEGER)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createTableJogador() {
		String sql = "CREATE TABLE if not exists jogadores(idJogadores IDENTITY PRIMARY KEY,"
				+ "nome varchar(20), "
				+ "pontuacao INTEGER)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}