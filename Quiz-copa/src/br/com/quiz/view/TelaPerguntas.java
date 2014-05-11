package br.com.quiz.view;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import br.com.quiz.dao.JogadorDao;
import br.com.quiz.factory.ConnectionFactory;
import br.com.quiz.model.Jogador;
import br.com.quiz.model.Pergunta;

import javax.swing.JButton;

import com.mysql.jdbc.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.ImageIcon;

import java.awt.Font;


public class TelaPerguntas extends JFrame {

	JLabel label;
	JButton buttonAltA;
	JButton buttonAltB;
	JButton buttonAltC;
	JButton buttonAltD;
	private java.sql.Connection con;
	ResultSet rs;
	int pontos;
	int nivel;
	String nomeJog;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String Query = null;
	private JPanel contentPane;
	private JButton btnProximaPergunta;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPerguntas frame = new TelaPerguntas();
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
			setTitle("Perguntas");
			setResizable(false);
			
	    
       this.con = new ConnectionFactory().getConnection();
      		
      
       try {
      
			Statement stmt = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);	
	    
			rs= stmt.executeQuery("select * from perguntas where nivel = 1 ORDER BY RAND() LIMIT 11");
	     
	      } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final Pergunta pergunta = new Pergunta(); 
		             final Jogador jog = new Jogador();
		
   		
		    try {
		    	rs.next();
			label = new JLabel(rs.getString("questao"));
			label.setForeground(new Color(204, 255, 204));
			label.setFont(new Font("Tahoma", Font.BOLD, 15));
			label.setBounds(33, 34, 761, 51);
			contentPane.add(label);

		    buttonAltA = new JButton(rs.getString("alter_a"));
		    buttonAltA.setForeground(new Color(0, 0, 0));
		    buttonAltA.setBackground(new Color(154, 205, 50));
			buttonAltA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent a) {
					a.getActionCommand();
					try {
						pergunta.setAlternativaA(rs.getString("alter_a"));
						pergunta.setRespostaCerta(rs.getString("resp_certa"));
			
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				if(a.getActionCommand().equals(pergunta.getRespostaCerta())){
						 pontos = pontos+10;
					JOptionPane.showMessageDialog(null, "Certo ");
							}else{
								JOptionPane.showMessageDialog(null, "Errado");
							}
				proximaPergunta();
				}
			});
			buttonAltA.setBounds(46, 96, 707, 49);
			contentPane.add(buttonAltA);

		    buttonAltB = new JButton(rs.getString("alter_b"));
		    buttonAltB.setForeground(new Color(0, 0, 0));
		    buttonAltB.setBackground(new Color(154, 205, 50));
			buttonAltB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					e.getActionCommand();
					try {
						pergunta.setAlternativaA(rs.getString("alter_b"));
						pergunta.setRespostaCerta(rs.getString("resp_certa"));
		
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				if(e.getActionCommand().equals(pergunta.getRespostaCerta())){
					 pontos = pontos+10;
					JOptionPane.showMessageDialog(null, "Certo");
									}else{
								JOptionPane.showMessageDialog(null, "Errado");
							}
				proximaPergunta();     
				}
			});
			buttonAltB.setBounds(46, 167, 707, 48);
			contentPane.add(buttonAltB);

		    buttonAltC = new JButton(rs.getString("alter_c"));
		    buttonAltC.setForeground(new Color(0, 0, 0));
		    buttonAltC.setBackground(new Color(154, 205, 50));
			buttonAltC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					e.getActionCommand();
					try {
						pergunta.setAlternativaA(rs.getString("alter_c"));
						pergunta.setRespostaCerta(rs.getString("resp_certa"));
		
					} catch (SQLException e2) {
						
						e2.printStackTrace();
					}
				if(e.getActionCommand().equals(pergunta.getRespostaCerta())){
					 pontos = pontos+10;
					JOptionPane.showMessageDialog(null, "Certo");
			}else{
								JOptionPane.showMessageDialog(null, "Errado");
							}
				proximaPergunta();	
				}
			});
		    buttonAltC.setBounds(46, 235, 707, 48);
			contentPane.add(buttonAltC);

		    buttonAltD = new JButton(rs.getString("alter_d"));
		    buttonAltD.setForeground(new Color(0, 0, 0));
		    buttonAltD.setBackground(new Color(154, 205, 50));
			buttonAltD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					e.getActionCommand();
					try {
						pergunta.setAlternativaA(rs.getString("alter_d"));
						pergunta.setRespostaCerta(rs.getString("resp_certa"));
			
					} catch (SQLException e3) {
						
						e3.printStackTrace();
					}
				if(e.getActionCommand().equals(pergunta.getRespostaCerta())){
					 pontos = pontos+10;
								JOptionPane.showMessageDialog(null, "Certo");
							}else{
								JOptionPane.showMessageDialog(null, "Errado");
							}
				proximaPergunta();	
				}
			});
			buttonAltD.setBounds(47, 305, 707, 44);
			contentPane.add(buttonAltD);
			
			btnProximaPergunta = new JButton("Pular pergunta");
			btnProximaPergunta.setIcon(new ImageIcon("C:\\Users\\junior\\git\\Quiz-worldcup\\Quiz-copa\\img\\up24.png"));
			btnProximaPergunta.setBackground(new Color(154, 205, 50));
			btnProximaPergunta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent a) {
					try {
						
						if(jog.getPulos()>0){
						
					    rs.next();
						label.setText(rs.getString("questao"));
					    buttonAltA.setText(rs.getString("alter_a"));
						buttonAltB.setText(rs.getString("alter_b"));
						buttonAltC.setText(rs.getString("alter_c"));
						buttonAltD.setText(rs.getString("alter_d"));
						
						jog.reduzirPulos(1);;
						
						btnProximaPergunta.setText("Total de pulos "+Integer.toString(jog.getPulos()));
						
						}else{
							
							JOptionPane.showMessageDialog(null, "Você não pode mais pular as perguntas !");
							btnProximaPergunta.setVisible(false);
						}
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			btnProximaPergunta.setBounds(575, 393, 178, 38);
			contentPane.add(btnProximaPergunta);
			
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\junior\\workspace\\Quiz\\img\\simple_greenHD.jpg"));
			lblNewLabel.setBackground(new Color(153, 204, 51));
			lblNewLabel.setBounds(0, 0, 813, 369);
			contentPane.add(lblNewLabel);
			
							
		    } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
		      
			}
	
	public void proximaPergunta(){
		try {
			rs.next();
			label.setText(rs.getString("questao"));
		    buttonAltA.setText(rs.getString("alter_a"));
			buttonAltB.setText(rs.getString("alter_b"));
			buttonAltC.setText(rs.getString("alter_c"));
			buttonAltD.setText(rs.getString("alter_d"));
	 
			if(rs.isLast()){
				JogadorDao jd = new JogadorDao();
				Jogador jog = new Jogador();
				
				JOptionPane.showMessageDialog(null, "total de Pontos : "+pontos);
			    nomeJog = JOptionPane.showInputDialog("<< Digite um nome para salvar no Ranking >>");
				
				jog.setNome(nomeJog);
				jog.setPontuacao(pontos);
				if(nomeJog!=null){
					jd.gravarJogador(jog);
					new TelaPrincipal().setVisible(true);
					setVisible(false);
				}else{
				new TelaPrincipal().setVisible(true);
				setVisible(false);
				}}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	}
	
	

