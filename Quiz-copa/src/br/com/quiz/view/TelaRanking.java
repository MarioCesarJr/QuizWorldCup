package br.com.quiz.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import br.com.quiz.dao.JogadorDao;
import br.com.quiz.model.JogadorTableModel;

public class TelaRanking extends JFrame {

	private JPanel contentPane;


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
		setTitle("Ranking");
		setResizable(false);

		JogadorDao dao  = new JogadorDao();
		JogadorTableModel jm = new JogadorTableModel(dao);
		
			
		JTable table = new JTable(jm);

		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table);
		getContentPane().add(scroll);
		setSize(500, 280);
		
		
	
	}
}
