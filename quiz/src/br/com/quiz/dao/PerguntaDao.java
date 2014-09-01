package br.com.quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.quiz.factory.ConnectionFactory;
import br.com.quiz.model.Pergunta;

public class PerguntaDao  {

	private Connection connection;
	
	public PerguntaDao(){
		this.connection = new ConnectionFactory().getConnection();
		
	}
	
	public void gravarPergunta(Pergunta pergunta) {
		String sql = "insert into perguntas " + "(questao,alter_a,alter_b,alter_c,alter_d,resp_certa,nivel)" + " values (?,?,?,?,?,?,?)";
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			// seta os valores
			stmt.setString(1, pergunta.getQuestao());
			stmt.setString(2, pergunta.getAlternativaA());
			stmt.setString(3, pergunta.getAlternativaB());
			stmt.setString(4, pergunta.getAlternativaC());
			stmt.setString(5, pergunta.getAlternativaD());
			stmt.setString(6, pergunta.getRespostaCerta());
			stmt.setInt(7, pergunta.getNivel());

			// executa
			stmt.execute();

			stmt.close();			
			
			connection.close(); // fecha conexao
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
		public List<Pergunta> getLista() {
			try {
				List<Pergunta> perguntas = new ArrayList<Pergunta>();
				PreparedStatement stmt = this.connection.prepareStatement("select * from perguntas");
				ResultSet rs = stmt.executeQuery(); // recebe o PreparedStatement 

				while(rs.next()){
					// criando o objeto Pergunta
					Pergunta pergunta = new Pergunta();
					pergunta.setIdPergunta(rs.getInt("idPerguntas"));
					pergunta.setQuestao(rs.getString("questao"));
					pergunta.setAlternativaA(rs.getString("alter_a"));
					pergunta.setAlternativaB(rs.getString("alter_b"));
					pergunta.setAlternativaC(rs.getString("alter_c"));
					pergunta.setAlternativaD(rs.getString("alter_d"));
					pergunta.setRespostaCerta(rs.getString("resp_certa"));
					pergunta.setNivel(rs.getInt("nivel"));
					
					// adicionando o objeto à lista

				     perguntas.add(pergunta);
				}
				rs.close();
				stmt.close();
				return perguntas;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		public void update(Pergunta pergunta) {
			String sql = "update perguntas set questao=?, alter_a=?, alter_b=?, alter_c=?, alter_d=?, resp_certa=?, nivel=? where idPerguntas=?";

			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, pergunta.getQuestao());
				stmt.setString(2, pergunta.getAlternativaA());
				stmt.setString(3, pergunta.getAlternativaB());
				stmt.setString(4, pergunta.getAlternativaC());
				stmt.setString(5, pergunta.getAlternativaD());
				stmt.setString(6, pergunta.getRespostaCerta());
				stmt.setInt(7, pergunta.getNivel());
				stmt.setLong(8, pergunta.getIdPergunta());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		public void removePergunta(Pergunta pergunta) {
			try {
				PreparedStatement stmt = connection.prepareStatement("delete from perguntas where idPerguntas=?");
				stmt.setLong(1, pergunta.getIdPergunta());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		
		}
		

	


