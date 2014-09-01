package br.com.quiz.view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import br.com.quiz.dao.JogadorDao;
import br.com.quiz.factory.ConnectionFactory;
import br.com.quiz.model.Jogador;
import br.com.quiz.model.Pergunta;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.JProgressBar;

public class TelaPerguntas extends JFrame {

	JLabel label;
	JButton buttonAltA;
	JButton buttonAltB;
	JButton buttonAltC;
	JButton buttonAltD;
	JTextArea textArea;
	JButton btnSair;
	int timerDelay = 200;
	private java.sql.Connection con;
	Jogador jogador = new Jogador();
	TelaOpcao opc = new TelaOpcao();
	ResultSet rs;
	String nomeJog;
	JLabel labelPontos = new JLabel(Integer.toString(jogador.getPontuacao()));
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String Query = null;
	private JPanel contentPane;
	private JButton btnProximaPergunta;
	private JLabel lblNewLabel;
	private JLabel lblErros;
	private JLabel labelErros;

	class TelaOp extends TelaOpcao {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPerguntas frame = new TelaPerguntas();
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

	public TelaPerguntas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/football_128x128.png"));
		setTitle("Perguntas");
		//setResizable(false);

		this.con = new ConnectionFactory().getConnection();

		/*
		 * opc é a instancia da TelaOpcao, e jogo é a instancia da classe Quiz
		 * criado na classe TelaOpcao.
		 */
		if (opc.jogo.getNivel() == 1) {
			try {

				Statement stmt = (Statement) con.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);

				rs = stmt
						.executeQuery("select * from perguntas where nivel = 1 ORDER BY RAND() LIMIT 11");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (opc.jogo.getNivel() == 2) {

			try {

				Statement stmt = (Statement) con.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);

				rs = stmt
						.executeQuery("select * from perguntas where nivel = 2 ORDER BY RAND() LIMIT 11");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (opc.jogo.getNivel() == 3) {

			try {

				Statement stmt = (Statement) con.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);

				rs = stmt
						.executeQuery("select * from perguntas where nivel = 3 ORDER BY RAND() LIMIT 11");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			try {

				Statement stmt = (Statement) con.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);

				rs = stmt
						.executeQuery("select * from perguntas where nivel = 2 ORDER BY RAND() LIMIT 11");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1390, 702);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final Pergunta pergunta = new Pergunta();
		final JProgressBar progressBar = new JProgressBar();
		progressBar.setBackground(Color.RED);

		progressBar.setBounds(263, 552, 168, 33);
		contentPane.add(progressBar);

		progressBar.setValue(0);
		progressBar.setStringPainted(true);

		new javax.swing.Timer(timerDelay, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (opc.jogo.getIndex() > opc.jogo.getMinIndex()) {
					progressBar.setValue(opc.jogo.getIndex());
					opc.jogo.setIndex(opc.jogo.getIndex() - 1);
					progressBar.setString(Integer.toString(opc.jogo.getIndex()));

				} else if (opc.jogo.getMinIndex() == 10000) {
					// progressBar.setValue(opc.jogo.getMaxIndex());
					((javax.swing.Timer) e.getSource()).stop(); // stop the
																// timer

				} else if (opc.jogo.getIndex() == 0) {
					progressBar.setValue(opc.jogo.getMinIndex());
					((javax.swing.Timer) e.getSource()).stop(); // stop the
					// timer
					// Quando acaba o tempo volta a tela inicial
					JOptionPane.showMessageDialog(null, "Total de Pontos : "
							+ jogador.getPontuacao());
					TelaPrincipal tp = new TelaPrincipal();
					tp.setExtendedState(JFrame.MAXIMIZED_BOTH);
					tp.setVisible(true);
					dispose();
				}
			}
		}).start();

		progressBar.setValue(progressBar.getMinimum());

		try {
			rs.next();

			textArea = new JTextArea(rs.getString("questao"));
			textArea.setEditable(false);
			textArea.setBackground(new Color(154, 205, 50));
			textArea.setForeground(new Color(204, 255, 204));
			textArea.setFont(new Font("Tahoma", Font.BOLD, 25));
			textArea.setBounds(289, 65, 761, 132);
			textArea.setOpaque(false);
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
			contentPane.add(textArea);

			buttonAltA = new JButton(rs.getString("alter_a"));
			buttonAltA.setForeground(new Color(0, 0, 0));
			buttonAltA.setBackground(new Color(154, 205, 50));
			buttonAltA.setFont(new Font("Tahoma", Font.BOLD, 17));
			buttonAltA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent a) {
					a.getActionCommand();

					try {
						pergunta.setAlternativaA(rs.getString("alter_a"));
						pergunta.setRespostaCerta(rs.getString("resp_certa"));

					} catch (SQLException e) {

						e.printStackTrace();
					}
					if (a.getActionCommand()
							.equals(pergunta.getRespostaCerta())) {

						/*
						 * verifica o nivel para multiplicar a pontuação pelo
						 * tempo, o mesmo é feito nos botões b,c e d.
						 */
						if (opc.jogo.getNivel() == 1) {
							jogador.setPontuacao(jogador.getPontuacao()
									+ (opc.jogo.getIndex() * 5));

						} else if (opc.jogo.getNivel() == 2) {
							jogador.setPontuacao(jogador.getPontuacao()
									+ (opc.jogo.getIndex() * 7));
						} else {
							jogador.setPontuacao(jogador.getPontuacao()
									+ (opc.jogo.getIndex() * 9));
						}

						JOptionPane.showMessageDialog(null, "Certo", "",
								JOptionPane.INFORMATION_MESSAGE, new ImageIcon(
										"img/success48.png"));
						// JOptionPane.showMessageDialog(null, "Certo ");
					} else {

						jogador.setErros(jogador.getErros() + 1);
						JOptionPane.showMessageDialog(null, "Errado", "",
								JOptionPane.ERROR_MESSAGE, new ImageIcon(
										"img/close48.png"));
						// JOptionPane.showMessageDialog(null, "Errado");
					}

					proximaPergunta();
				}
			});
			buttonAltA.setBounds(318, 208, 707, 49);
			contentPane.add(buttonAltA);

			buttonAltB = new JButton(rs.getString("alter_b"));
			buttonAltB.setForeground(new Color(0, 0, 0));
			buttonAltB.setBackground(new Color(154, 205, 50));
			buttonAltB.setFont(new Font("Tahoma", Font.BOLD, 17));
			buttonAltB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					e.getActionCommand();
					try {
						pergunta.setAlternativaA(rs.getString("alter_b"));
						pergunta.setRespostaCerta(rs.getString("resp_certa"));

					} catch (SQLException e1) {

						e1.printStackTrace();
					}
					if (e.getActionCommand()
							.equals(pergunta.getRespostaCerta())) {
						if (opc.jogo.getNivel() == 1) {
							jogador.setPontuacao(jogador.getPontuacao()
									+ (opc.jogo.getIndex() * 5));

						} else if (opc.jogo.getNivel() == 2) {
							jogador.setPontuacao(jogador.getPontuacao()
									+ (opc.jogo.getIndex() * 7));
						} else {
							jogador.setPontuacao(jogador.getPontuacao()
									+ (opc.jogo.getIndex() * 9));
						}

						JOptionPane.showMessageDialog(null, "Certo", "",
								JOptionPane.INFORMATION_MESSAGE, new ImageIcon(
										"img/success48.png"));
						// JOptionPane.showMessageDialog(null, "Certo ");
					} else {
						jogador.setErros(jogador.getErros() + 1);
						JOptionPane.showMessageDialog(null, "Errado", "",
								JOptionPane.ERROR_MESSAGE, new ImageIcon(
										"img/close48.png"));
						// JOptionPane.showMessageDialog(null, "Errado");
					}
					proximaPergunta();
				}
			});
			buttonAltB.setBounds(318, 281, 707, 48);
			contentPane.add(buttonAltB);

			buttonAltC = new JButton(rs.getString("alter_c"));
			buttonAltC.setForeground(new Color(0, 0, 0));
			buttonAltC.setBackground(new Color(154, 205, 50));
			buttonAltC.setFont(new Font("Tahoma", Font.BOLD, 17));
			buttonAltC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					e.getActionCommand();
					try {
						pergunta.setAlternativaA(rs.getString("alter_c"));
						pergunta.setRespostaCerta(rs.getString("resp_certa"));

					} catch (SQLException e2) {

						e2.printStackTrace();
					}
					if (e.getActionCommand()
							.equals(pergunta.getRespostaCerta())) {
						if (opc.jogo.getNivel() == 1) {
							jogador.setPontuacao(jogador.getPontuacao()
									+ (opc.jogo.getIndex() * 5));

						} else if (opc.jogo.getNivel() == 2) {
							jogador.setPontuacao(jogador.getPontuacao()
									+ (opc.jogo.getIndex() * 7));
						} else {
							jogador.setPontuacao(jogador.getPontuacao()
									+ (opc.jogo.getIndex() * 9));
						}

						JOptionPane.showMessageDialog(null, "Certo", "",
								JOptionPane.INFORMATION_MESSAGE, new ImageIcon(
										"img/success48.png"));
						// JOptionPane.showMessageDialog(null, "Certo ");
					} else {
						jogador.setErros(jogador.getErros() + 1);
						JOptionPane.showMessageDialog(null, "Errado", "",
								JOptionPane.ERROR_MESSAGE, new ImageIcon(
										"img/close48.png"));
						// JOptionPane.showMessageDialog(null, "Errado");
					}
					proximaPergunta();
				}
			});
			buttonAltC.setBounds(318, 353, 707, 48);
			contentPane.add(buttonAltC);

			buttonAltD = new JButton(rs.getString("alter_d"));
			buttonAltD.setForeground(new Color(0, 0, 0));
			buttonAltD.setBackground(new Color(154, 205, 50));
			buttonAltD.setFont(new Font("Tahoma", Font.BOLD, 17));
			buttonAltD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					e.getActionCommand();
					try {
						pergunta.setAlternativaA(rs.getString("alter_d"));
						pergunta.setRespostaCerta(rs.getString("resp_certa"));

					} catch (SQLException e3) {

						e3.printStackTrace();
					}
					if (e.getActionCommand()
							.equals(pergunta.getRespostaCerta())) {

						if (opc.jogo.getNivel() == 1) {
							jogador.setPontuacao(jogador.getPontuacao()
									+ (opc.jogo.getIndex() * 5));

						} else if (opc.jogo.getNivel() == 2) {
							jogador.setPontuacao(jogador.getPontuacao()
									+ (opc.jogo.getIndex() * 7));
						} else {
							jogador.setPontuacao(jogador.getPontuacao()
									+ (opc.jogo.getIndex() * 9));
						}
						JOptionPane.showMessageDialog(null, "Certo", "",
								JOptionPane.INFORMATION_MESSAGE, new ImageIcon(
										"img/success48.png"));
						// JOptionPane.showMessageDialog(null, "Certo ");
					} else {
						jogador.setErros(jogador.getErros() + 1);
						JOptionPane.showMessageDialog(null, "Errado", "",
								JOptionPane.ERROR_MESSAGE, new ImageIcon(
										"img/close48.png"));
						// JOptionPane.showMessageDialog(null, "Errado");
					}
					proximaPergunta();
				}
			});
			buttonAltD.setBounds(318, 426, 707, 44);
			contentPane.add(buttonAltD);

			btnProximaPergunta = new JButton("Pular pergunta");
			btnProximaPergunta.setIcon(new ImageIcon("img/up24.png"));
			btnProximaPergunta.setBackground(new Color(154, 205, 50));
			btnProximaPergunta.setFont(new Font("Tahoma", Font.BOLD, 17));
			btnProximaPergunta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent a) {
					try {

						if (jogador.getPulos() > 0) {

							rs.next();
							textArea.setText(rs.getString("questao"));
							buttonAltA.setText(rs.getString("alter_a"));
							buttonAltB.setText(rs.getString("alter_b"));
							buttonAltC.setText(rs.getString("alter_c"));
							buttonAltD.setText(rs.getString("alter_d"));

							jogador.reduzirPulos(1);
							btnProximaPergunta.setText("Total de pulos "
									+ Integer.toString(jogador.getPulos()));
							opc.jogo.reiniciaBar();

						} else {

							JOptionPane.showMessageDialog(null,
									"Você não pode mais pular as perguntas !");
							btnProximaPergunta.setVisible(false);
						}

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			btnProximaPergunta.setBounds(835, 542, 215, 49);
			contentPane.add(btnProximaPergunta);

			lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon("img/simple_greenHD.jpg"));
			lblNewLabel.setBackground(new Color(153, 204, 51));
			lblNewLabel.setBounds(0, 0, 1370, 517);
			contentPane.add(lblNewLabel);

			JLabel lblPontos = new JLabel("Pontos");
			lblPontos.setFont(new Font("Source Sans Pro", Font.BOLD, 17));
			lblPontos.setBounds(550, 552, 79, 14);
			contentPane.add(lblPontos);
			labelPontos.setFont(new Font("Source Sans Pro", Font.BOLD, 17));

			// Setando o labelPontos Instanciado la no inicio com a variaveis
			labelPontos.setBounds(550, 577, 79, 14);
			contentPane.add(labelPontos);
			
			lblErros = new JLabel("Erros");
			lblErros.setFont(new Font("Source Sans Pro", Font.BOLD, 17));
			lblErros.setBounds(679, 552, 52, 14);
			contentPane.add(lblErros);
			
			labelErros = new JLabel(Integer.toString(jogador.getErros()));
			labelErros.setFont(new Font("Source Sans Pro", Font.BOLD, 17));
			labelErros.setBounds(679, 579, 95, 14);
			contentPane.add(labelErros);
			
			

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void proximaPergunta() {
		opc.jogo.reiniciaBar();// seta o valores do progressbar para reiniciar a
								// contagem.
		try {

			rs.next();
			textArea.setText(rs.getString("questao"));
			buttonAltA.setText(rs.getString("alter_a"));
			buttonAltB.setText(rs.getString("alter_b"));
			buttonAltC.setText(rs.getString("alter_c"));
			buttonAltD.setText(rs.getString("alter_d"));
			labelPontos.setText(Integer.toString(jogador.getPontuacao()));
			labelErros.setText(Integer.toString(jogador.getErros()));
			JogadorDao jd = new JogadorDao();
			TelaPrincipal telaP = new TelaPrincipal();
			if (rs.isLast()) {
				opc.jogo.setMinIndex(10000);
				JOptionPane.showMessageDialog(null, "total de Pontos : "
						+ jogador.getPontuacao());

				// Pega o nome digitado e armazena na variavel nomeJog.
				nomeJog = JOptionPane.showInputDialog("<< Digite um nome para salvar no Ranking >>");

				jogador.setNome(nomeJog);
				if (nomeJog != null || nomeJog == "") {
					jd.gravarJogador(jogador);
					telaP.setExtendedState(JFrame.MAXIMIZED_BOTH);
					telaP.setVisible(true);
					setVisible(false);
				} else {
					telaP.setExtendedState(JFrame.MAXIMIZED_BOTH);
					telaP.setVisible(true);
					setVisible(false);
				}

			}
			if (jogador.getErros() == 4) {
				labelErros.setText("3");
				opc.jogo.setMinIndex(10000);
				JOptionPane.showMessageDialog(null, "GAME OVER !"
						+ " Total de Pontos : " + jogador.getPontuacao());

				// Pega o nome digitado e armazena na variavel nomeJog.
				nomeJog = JOptionPane.showInputDialog(null,"<< Digite um nome para salvar no Ranking >>");

				jogador.setNome(nomeJog);
				if (nomeJog != null || nomeJog == "") {
					jd.gravarJogador(jogador);
					telaP.setExtendedState(JFrame.MAXIMIZED_BOTH);
					telaP.setVisible(true);
					setVisible(false);
				} else {
					telaP.setExtendedState(JFrame.MAXIMIZED_BOTH);
					telaP.setVisible(true);
					setVisible(false);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
