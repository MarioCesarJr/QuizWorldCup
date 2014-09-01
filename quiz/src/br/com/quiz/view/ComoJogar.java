package br.com.quiz.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Font;

public class ComoJogar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComoJogar frame = new ComoJogar();
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
	public ComoJogar() {
		setTitle("Instru\u00E7\u00F5es");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/bola_small.png"));
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblComoJogar = new JLabel("Como jogar");
		lblComoJogar.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblComoJogar.setBounds(20, 32, 155, 25);
		contentPane.add(lblComoJogar);
		
		JLabel lblCadaPartidaConsiste = new JLabel("Cada partida consiste em 10 perguntas.");
		lblCadaPartidaConsiste.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadaPartidaConsiste.setBounds(20, 69, 331, 25);
		contentPane.add(lblCadaPartidaConsiste);
		
		JLabel lblQuantoMaisRpido = new JLabel("Quanto mais r\u00E1pido responder, maior \u00E9 a sua pontua\u00E7\u00E3o.");
		lblQuantoMaisRpido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantoMaisRpido.setBounds(20, 119, 429, 25);
		contentPane.add(lblQuantoMaisRpido);
		
		JLabel lblVocPoderSe = new JLabel("Voc\u00EA poder\u00E1 se registrar e salvar sua pontua\u00E7\u00E3o quando finalizar a partida.");
		lblVocPoderSe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVocPoderSe.setBounds(20, 145, 523, 26);
		contentPane.add(lblVocPoderSe);
		
		JLabel lblJogarAgora = new JLabel("JOGAR AGORA !");
		lblJogarAgora.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblJogarAgora.setBounds(22, 182, 126, 14);
		contentPane.add(lblJogarAgora);
		
		JLabel lblVocPodeErrar = new JLabel("Voc\u00EA pode errar 3 vezes.");
		lblVocPodeErrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVocPodeErrar.setBounds(20, 94, 246, 25);
		contentPane.add(lblVocPodeErrar);
	}
}
