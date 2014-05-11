package br.com.quiz.model;

import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.quiz.dao.JogadorDao;

public class JogadorTableModel extends AbstractTableModel {

	private List<Jogador> jogadores;
	private List<String> colunas;
	private JogadorDao dao;

	public JogadorTableModel(JogadorDao dao) {
		this.dao = dao;
		this.jogadores = dao.getLista();
		this.colunas = Arrays.asList("Nome ", "Pontuação");
	}
	
	@Override
	public int getRowCount() {

		return jogadores.size();
	}


	@Override
	public int getColumnCount() {

		return colunas.size();
	}

	
	public String getColumnName(int i) {
		return colunas.get(i);
	}

	@Override
	public Object getValueAt(int r, int c) {
		Jogador jogador = jogadores.get(r);
		switch (c) {
		case 0:
			return jogador.getNome();
		case 1:
			return jogador.getPontuacao();
		}
		return null;
	}

}
