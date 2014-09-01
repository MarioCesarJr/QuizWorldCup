package br.com.quiz.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.com.quiz.dao.PerguntaDao;
import br.com.quiz.model.PerguntaTableModel;
import java.awt.Font;

public class TabelaPerguntas extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabelaPerguntas frame = new TabelaPerguntas();
				    frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TabelaPerguntas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/football_128x128.png"));
		setTitle("Lista de Perguntas");
		setResizable(false);

		PerguntaDao dao  = new PerguntaDao();
	    final PerguntaTableModel pm = new PerguntaTableModel(dao);
		
		
		final JTable table = new JTable(pm);
		table.setFont(new Font("Tahoma", Font.BOLD, 15));
		table.setRowHeight(32);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table);
		getContentPane().add(scroll);
		setSize(800, 400);

		JPanel pan = new JPanel();
		JButton buttonExcluir = new JButton("Excluir");
		buttonExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				pm.deletaPergunta();
				
			   int linhaSelecionada = table.getSelectedRow();

			    pm.removeRow(linhaSelecionada);
			 	
			     
			}
		});
		
		pan.add(buttonExcluir,BorderLayout.EAST);
	    getContentPane().add(pan,BorderLayout.SOUTH);
	}


}
