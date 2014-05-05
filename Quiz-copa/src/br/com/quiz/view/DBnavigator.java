package br.com.quiz.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import br.com.quiz.factory.ConnectionFactory;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class DBnavigator extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private java.sql.Connection con;
	ResultSet rs;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBnavigator frame = new DBnavigator();
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
	public DBnavigator() {
		this.con = new ConnectionFactory().getConnection();
		
		try {
			Statement stmt = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rs= stmt.executeQuery("select * from pergunta");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblLa = new JLabel("la");
		lblLa.setBounds(103, 11, 222, 48);
		contentPane.add(lblLa);
		
		textField = new JTextField();
		textField.setBounds(103, 140, 222, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(103, 171, 222, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("alternativa");
		btnNewButton.setBounds(103, 79, 222, 23);
		contentPane.add(btnNewButton);
		
		JButton btnProximo = new JButton("proximo");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					rs.next();
					lblLa.setText(rs.getString("questao"));
					btnNewButton.setText(rs.getString("alternativaA"));
					//textField.setText(rs.getString("questao"));
					//textField_1.setText(rs.getString("alternativaA"));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnProximo.setBounds(184, 202, 89, 23);
		contentPane.add(btnProximo);
		
		
		
	}
}
