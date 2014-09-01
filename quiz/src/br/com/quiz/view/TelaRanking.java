package br.com.quiz.view;


import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.com.quiz.dao.JogadorDao;
import br.com.quiz.model.JogadorTableModel;
import java.awt.Font;

public class TelaRanking extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRanking frame = new TelaRanking();
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
	public TelaRanking() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/football_128x128.png"));
		setTitle("Ranking");
		setResizable(false);

		JogadorDao dao  = new JogadorDao();
		JogadorTableModel jm = new JogadorTableModel(dao);
		
			
		JTable table = new JTable(jm);
		table.setFont(new Font("Tahoma", Font.BOLD, 17));
        table.setRowHeight(32);
        //table.getColumnModel().getColumn(1).setPreferredWidth(-15);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table);
		getContentPane().add(scroll);
		setSize(600, 280);
		
		
	
	}
}
