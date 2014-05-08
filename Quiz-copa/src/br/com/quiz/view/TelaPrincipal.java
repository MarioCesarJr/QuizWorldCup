package br.com.quiz.view;

import java.awt.BorderLayout;
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
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
		setTitle("Quiz Copa do Mundo");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\junior\\git\\Quiz-worldcup\\Quiz-copa\\img\\Arena.png"));
		lblNewLabel.setBounds(0, 0, 744, 401);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 405, 781, 48);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnIniciar = new JButton("Iniciar Quiz");
		btnIniciar.setBounds(314, 11, 144, 27);
		panel.add(btnIniciar);
		btnIniciar.setBackground(new Color(204, 204, 204));
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CadastroJogador().setVisible(true);
				setVisible(false);
			}
		});
		btnIniciar.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnOpo = new JButton("Op\u00E7\u00E3o");
		btnOpo.setBackground(Color.LIGHT_GRAY);
		btnOpo.setBounds(117, 15, 89, 23);
		panel.add(btnOpo);
		
		JButton btnRanking = new JButton("Ranking");
		btnRanking.setBackground(Color.LIGHT_GRAY);
		btnRanking.setBounds(559, 15, 89, 23);
		panel.add(btnRanking);
	}
}
