package br.com.quiz.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import br.com.quiz.dao.PerguntaDao;
import br.com.quiz.model.Pergunta;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JSeparator;

public class CadastroPerguntas extends JFrame {

	private JPanel contentPane;
	private JTextField textQuestao;
	private JTextField textAlternativaA;
	private JTextField textAlternativaB;
	private JTextField textAlternativaC;
	private JTextField textAlternativaD;
	private JTextField textRespCerta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPerguntas frame = new CadastroPerguntas();
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
	public CadastroPerguntas() {
		setTitle("Cadastro de Perguntas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDePerguntas = new JLabel("Cadastro de Perguntas");
		lblCadastroDePerguntas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCadastroDePerguntas.setIcon(new ImageIcon("C:\\Users\\junior\\git\\Quiz-worldcup\\Quiz-copa\\img\\application32.png"));
		lblCadastroDePerguntas.setBounds(149, 22, 259, 51);
		contentPane.add(lblCadastroDePerguntas);
		
		JLabel lblPergunta = new JLabel("Pergunta");
		lblPergunta.setBounds(20, 98, 84, 14);
		contentPane.add(lblPergunta);
		
		textQuestao = new JTextField();
		textQuestao.setBounds(124, 95, 400, 20);
		contentPane.add(textQuestao);
		textQuestao.setColumns(10);
		
		JLabel lblAlternativaA = new JLabel("Alternativa A");
		lblAlternativaA.setBounds(20, 143, 104, 14);
		contentPane.add(lblAlternativaA);
		
		textAlternativaA = new JTextField();
		textAlternativaA.setBounds(124, 140, 334, 20);
		contentPane.add(textAlternativaA);
		textAlternativaA.setColumns(10);
		
		JLabel lblAlternativaB = new JLabel("Alternativa B");
		lblAlternativaB.setBounds(20, 184, 104, 14);
		contentPane.add(lblAlternativaB);
		
		textAlternativaB = new JTextField();
		textAlternativaB.setBounds(124, 181, 334, 20);
		contentPane.add(textAlternativaB);
		textAlternativaB.setColumns(10);
		
		JLabel lblAlternativaC = new JLabel("Alternativa C");
		lblAlternativaC.setBounds(20, 229, 104, 14);
		contentPane.add(lblAlternativaC);
		
		textAlternativaC = new JTextField();
		textAlternativaC.setBounds(123, 226, 334, 20);
		contentPane.add(textAlternativaC);
		textAlternativaC.setColumns(10);
		
		JLabel lblAlternativaD = new JLabel("Alternativa D");
		lblAlternativaD.setBounds(20, 271, 104, 14);
		contentPane.add(lblAlternativaD);
		
		textAlternativaD = new JTextField();
		textAlternativaD.setBounds(124, 268, 334, 20);
		contentPane.add(textAlternativaD);
		textAlternativaD.setColumns(10);
		
		JLabel lblRespostaCerta = new JLabel("Resposta Certa");
		lblRespostaCerta.setBounds(20, 315, 104, 14);
		contentPane.add(lblRespostaCerta);
		
		textRespCerta = new JTextField();
		textRespCerta.setBounds(124, 312, 334, 20);
		contentPane.add(textRespCerta);
		textRespCerta.setColumns(10);
		
		ButtonGroup bg = new ButtonGroup();
		
		final JRadioButton rdbtnFacil = new JRadioButton("F\u00E1cil");
		rdbtnFacil.setBounds(124, 357, 109, 23);
		contentPane.add(rdbtnFacil);
		bg.add(rdbtnFacil);
		
		final JRadioButton rdbtnMedio = new JRadioButton("M\u00E9dio");
		rdbtnMedio.setBounds(257, 357, 109, 23);
		contentPane.add(rdbtnMedio);
		bg.add(rdbtnMedio);
	
		final JRadioButton rdbtnDificil = new JRadioButton("Dif\u00EDcil");
		rdbtnDificil.setBounds(415, 357, 109, 23);
		contentPane.add(rdbtnDificil);
		bg.add(rdbtnDificil);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon("C:\\Users\\junior\\git\\Quiz-worldcup\\Quiz-copa\\img\\back16.png"));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TelaPrincipal().setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setBounds(316, 401, 109, 23);
		contentPane.add(btnVoltar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon("C:\\Users\\junior\\git\\Quiz-worldcup\\Quiz-copa\\img\\add1-16.png"));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Pergunta perg = new Pergunta();
				PerguntaDao dao = new PerguntaDao();
				
				perg.setQuestao(textQuestao.getText());
				perg.setAlternativaA(textAlternativaA.getText());
				perg.setAlternativaB(textAlternativaB.getText());
				perg.setAlternativaC(textAlternativaC.getText());
				perg.setAlternativaD(textAlternativaD.getText());
				perg.setRespostaCerta(textRespCerta.getText());
				
				if((textQuestao.getText().isEmpty())||
				(textAlternativaA.getText().isEmpty())||
				(textAlternativaB.getText().isEmpty())||
				(textAlternativaC.getText().isEmpty())||
				(textAlternativaD.getText().isEmpty())||
				(textRespCerta.getText().isEmpty())){
					
					JOptionPane.showMessageDialog(null, "É obrigatório o preenchimento de todos os campos !");
				}else
				
			    if(rdbtnFacil.isSelected()){
			    	
			    	perg.setNivel(1);
			    	dao.gravarPergunta(perg);
			        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso !");
			        limparCampos();
			    }else if(rdbtnMedio.isSelected()){
			    	
			    	perg.setNivel(2);
			    	dao.gravarPergunta(perg);
			    	JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso !");
			    	limparCampos();
			    }else if(rdbtnDificil.isSelected()){
			    	
			    	perg.setNivel(3);
			    	dao.gravarPergunta(perg);
			    	JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso !");
			    	limparCampos();
			    }
			    
			  }
		});
		btnCadastrar.setBounds(124, 401, 121, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblNvel = new JLabel("N\u00EDvel :");
		lblNvel.setBounds(20, 361, 78, 14);
		contentPane.add(lblNvel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 78, 532, 272);
		contentPane.add(panel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 387, 532, 3);
		contentPane.add(separator);
	}
	
	void limparCampos(){
		
		textQuestao.setText("");
		textAlternativaA.setText("");
		textAlternativaB.setText("");
		textAlternativaC.setText("");
		textAlternativaD.setText("");
		textRespCerta.setText("");
		
	}
}
