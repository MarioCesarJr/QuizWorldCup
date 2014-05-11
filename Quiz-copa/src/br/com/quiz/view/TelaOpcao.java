package br.com.quiz.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.ldap.Rdn;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

import br.com.quiz.model.Jogador;
import br.com.quiz.model.Pergunta;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaOpcao extends JFrame {

	private JPanel contentPane;
	JRadioButton rdbtnFcil;
	JRadioButton rdbtnMedio;
	JRadioButton rdbtnDifcil;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaOpcao frame = new TelaOpcao();
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
	public TelaOpcao() {
		setTitle("Op\u00E7\u00F5es");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDficuldade = new JLabel("Dificuldade");
		lblDficuldade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDficuldade.setBounds(10, 26, 96, 14);
		contentPane.add(lblDficuldade);
		
		ButtonGroup bg = new ButtonGroup();
		
	    rdbtnFcil = new JRadioButton("F\u00E1cil");
		rdbtnFcil.setBounds(120, 23, 109, 23);
		contentPane.add(rdbtnFcil);
		bg.add(rdbtnFcil);
		
	    rdbtnMedio = new JRadioButton("Medio");
		rdbtnMedio.setBounds(120, 67, 109, 23);
		contentPane.add(rdbtnMedio);
		bg.add(rdbtnMedio);
		
		rdbtnDifcil = new JRadioButton("Dif\u00EDcil");
		rdbtnDifcil.setBounds(120, 112, 109, 23);
		contentPane.add(rdbtnDifcil);
		bg.add(rdbtnDifcil);
		
		JButton btnCadastrarPerguntas = new JButton("Cadastrar Perguntas");
		btnCadastrarPerguntas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CadastroPerguntas().setVisible(true);
				setVisible(false);
			}
		});
		btnCadastrarPerguntas.setBounds(10, 164, 168, 23);
		contentPane.add(btnCadastrarPerguntas);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {	
			   
		        new TelaPrincipal().setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setIcon(new ImageIcon("C:\\Users\\junior\\git\\Quiz-worldcup\\Quiz-copa\\img\\back16.png"));
		btnVoltar.setBounds(10, 210, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\junior\\git\\Quiz-worldcup\\Quiz-copa\\img\\foot_butSmall.png"));
		lblNewLabel.setBounds(197, 11, 227, 240);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 151, 168, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 198, 168, 2);
		contentPane.add(separator_1);
	}
	
	
}
