package br.com.quiz.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//new CreateTables().createTablePerguntas();
		//new CreateTables().createTableJogador();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
	public TelaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/football_128x128.png"));
		setTitle("Quiz Copa do Mundo");
		//setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 807, 492);
		setBounds(100, 100, 1390, 702);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("img/Arena.png"));
		lblNewLabel.setBounds(299, 11, 744, 496);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(299, 526, 781, 73);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnIniciar = new JButton("Iniciar Quiz");
		btnIniciar.setBounds(307, 11, 174, 51);
		panel.add(btnIniciar);
		btnIniciar.setBackground(new Color(204, 204, 204));
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//new TelaPerguntas().setVisible(true);
				//setVisible(false);
				
				TelaPerguntas frame = new TelaPerguntas();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnIniciar.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JButton btnOpo = new JButton("Opcões");
		btnOpo.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnOpo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaOpcao op = new TelaOpcao();
				op.setLocationRelativeTo(null);
				op.setVisible(true);
			}
		});
		btnOpo.setBackground(Color.LIGHT_GRAY);
		btnOpo.setBounds(87, 15, 119, 36);
		panel.add(btnOpo);
		
		JButton btnRanking = new JButton("Ranking");
		btnRanking.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRanking tr = new TelaRanking();
				tr.setLocationRelativeTo(null);
				tr.setVisible(true);
			}
		});
		btnRanking.setBackground(Color.LIGHT_GRAY);
		btnRanking.setBounds(559, 15, 119, 36);
		panel.add(btnRanking);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComoJogar jogar = new ComoJogar();
				jogar.setLocationRelativeTo(null);
				jogar.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon("img/info.png"));
		btnNewButton.setBackground(SystemColor.controlHighlight);
		btnNewButton.setBounds(17, 11, 33, 36);
		contentPane.add(btnNewButton);
	}
}
