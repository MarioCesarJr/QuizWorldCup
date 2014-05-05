package br.com.quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.quiz.factory.ConnectionFactory;
import br.com.quiz.model.Jogador;

public class JogadorDao {

	private Connection connection;

	public JogadorDao() {
		this.connection = new ConnectionFactory().getConnection();

	}

	public void gravarJogador(Jogador jogador) {
		String sql = "insert into jogador " + "(nome,pontuacao)" + " values (?,?)";
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			// seta os valores
			stmt.setString(1, jogador.getNome());
			stmt.setInt(2, jogador.getPontuacao());

			// executa
			stmt.execute();

			stmt.close();
			connection.close(); // fecha conexao
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Jogador> getLista() {
		try {
			List<Jogador> jogadores = new ArrayList<Jogador>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from jogador");
			ResultSet rs = stmt.executeQuery(); // recebe o PreparedStatement 

			while (rs.next()) {
				// criando o objeto Jogador
				Jogador jogador = new Jogador();
				jogador.setId(rs.getInt("id"));
				jogador.setNome(rs.getString("nome"));
				jogador.setPontuacao(rs.getInt("pontuacao"));
		
				// adicionando o objeto à lista

				jogadores.add(jogador);
			}
			rs.close();
			stmt.close();
			return jogadores;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(Jogador jogador) {
		String sql = "update jogador set nome=?, pontuacao=?, where id=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, jogador.getNome());
			stmt.setInt(2, jogador.getPontuacao());
			stmt.setLong(3, jogador.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
