
package br.com.quiz.model;

import java.util.Arrays;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import br.com.quiz.dao.PerguntaDao;

public class PerguntaTableModel extends AbstractTableModel implements TableModelListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Pergunta> perguntas;
	private List<String> colunas;
	private PerguntaDao dao;
	
	public PerguntaTableModel(PerguntaDao dao){
		this.dao = dao;
		this.perguntas = dao.getLista();
		colunas = Arrays.asList("questão");
	    this.addTableModelListener(this);
	}

	@Override
	public int getColumnCount() {
		return colunas.size();
	}

	@Override
	public int getRowCount() {
		return perguntas.size();
	}
	
	public String getColumnName(int i) {
		return colunas.get(i);
	}

	@Override
	public Object getValueAt(int r, int c) {
		Pergunta pergunta = perguntas.get(r);
		switch (c){
		case 0 :
			return pergunta.getQuestao();
			
		case 1 :
			return pergunta.getAlternativaA();
			
		case 2 :
			return pergunta.getAlternativaB();
			
		case 3 :
			return pergunta.getAlternativaC();
			
		case 4 :
			return pergunta.getAlternativaD();
			
		case 5 :
			return pergunta.getRespostaCerta();
			
		case 6 :
			return pergunta.getNivel();
		}
		
		return null;
	}
	
	public void setValueAt(Object aValue, int r, int c){
		Pergunta pergunta = perguntas.get(r);
	
		switch (c){
		case 0 :
		    pergunta.setQuestao((String)aValue);
			break;
		case 1 :
		    pergunta.setAlternativaA((String)aValue);
			break;
		case 2 :
			pergunta.setAlternativaB((String)aValue);
			break;
			
		case 3 :
			pergunta.setAlternativaC((String)aValue);
			break;
			
		case 4 :
			pergunta.setAlternativaD((String)aValue);
			break;
			
		case 5 :
			pergunta.setRespostaCerta((String)aValue);
			break;
			
		case 6 :
			pergunta.setNivel((int)aValue);
		
		default :
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
       fireTableCellUpdated(r, c); // notifica a atualização da célula
	}

	@Override
	public void tableChanged(TableModelEvent event) {
		int i = event.getFirstRow();
		Pergunta pergunta = perguntas.get(i);
		System.out.println(i);
		dao.update(pergunta);
		
	}
	
	@Override
	public boolean isCellEditable(int r, int c){
		return true;
	}
	
	public void deletaPergunta(){
		int id = perguntas.get(perguntas.size()-1).getIdPergunta();
		Pergunta pergunta = new Pergunta();
		pergunta.setIdPergunta(id);
		perguntas.add(pergunta);
		dao.removePergunta(pergunta);
			
		
	}
	
	public void removeRow(int linha){
	    this.perguntas.remove(linha);
	    this.fireTableRowsDeleted(linha, linha);
	}
	
	    
	   

}
