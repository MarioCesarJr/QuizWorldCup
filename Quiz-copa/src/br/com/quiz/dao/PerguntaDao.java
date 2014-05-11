package br.com.quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import javax.swing.JLabel;

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

				rs.next();
					// criando o objeto Pergunta
					Pergunta pergunta = new Pergunta();
					pergunta.setIdPergunta(rs.getInt("idPergunta"));
					pergunta.setQuestao(rs.getString("questao"));
					pergunta.setAlternativaA(rs.getString("alternativaA"));
					pergunta.setAlternativaB(rs.getString("alternativaB"));
					pergunta.setAlternativaC(rs.getString("alternativaC"));
					pergunta.setAlternativaD(rs.getString("alternativaD"));
					pergunta.setRespostaCerta(rs.getString("respostaCerta"));
					
					// adicionando o objeto à lista

				     perguntas.add(pergunta);
				
				rs.close();
				stmt.close();
				return perguntas;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		public void update(Pergunta pergunta) {
			String sql = "update pergunta set questao=?, alternativaA=?, alternativaB=?, alternativaC=?, alternativaD=?, where idPergunta=?";

			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, pergunta.getQuestao());
				stmt.setString(2, pergunta.getAlternativaA());
				stmt.setString(3, pergunta.getAlternativaB());
				stmt.setString(4, pergunta.getAlternativaC());
				stmt.setString(5, pergunta.getAlternativaD());
				stmt.setLong(6, pergunta.getIdPergunta());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		
		public List<Pergunta> proximaLinha(){
			try {
				List<Pergunta> perguntas = new ArrayList<Pergunta>();
				PreparedStatement stmt = this.connection.prepareStatement("select questao, alternativaA, alternativaB, alternativaC, alternativaD, respostaCerta, idPergunta from pergunta where idPergunta = 1");
				ResultSet rs = stmt.executeQuery(); // recebe o PreparedStatement 

				while (rs.next()) {
					// criando o objeto Pergunta
					Pergunta pergunta = new Pergunta();
					pergunta.setIdPergunta(rs.getInt("idPergunta"));
				    pergunta.setQuestao(rs.getString("questao"));
					pergunta.setAlternativaA(rs.getString("alternativaA"));
					pergunta.setAlternativaB(rs.getString("alternativaB"));
					pergunta.setAlternativaC(rs.getString("alternativaC"));
					pergunta.setAlternativaD(rs.getString("alternativaD"));
					pergunta.setRespostaCerta(rs.getString("respostaCerta"));
					
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
		
		public Pergunta proximaPergunta(){
			List<Pergunta> perguntas = new ArrayList<Pergunta>();
		    Pergunta pergunta = perguntas.get(0); // pega a primeira pergunta da lista
		    perguntas.remove(0); // remove a pergunta 0, para que ela não se repita
		    return pergunta;
		  }

			
		}
		

	


