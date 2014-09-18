package gp;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.*;
import java.util.ArrayList;

import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JGamingFrame extends JFrame {

	private JPanel contentPane;
	private final Action cadastro = new SwingAction();
	private final Action exit = new SwingAction1();
	private String nomejogo;
	private int peao;
	private int qtdcasa;
	private boolean casasEspeciais;


	//construtor principal para construção da tela
	public JGamingFrame() {

		//barra de menu
		JMenuBar barramenu = new JMenuBar();
		JMenu menu = new JMenu("File");

		JMenuItem sair = new JMenuItem("Sair");
		sair.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				System.exit(0);
			}
		});
		JMenuItem sobre = new JMenuItem ("Sobre");
		sobre.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				JOptionPane.showMessageDialog(null,"Game developed by 4FuN®","Informações",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		menu.add(sair);
		menu.add(new JSeparator());
		menu.add(sobre);
		barramenu.add(menu);
		setJMenuBar(barramenu);

		//construção da tela	
		setTitle("Taboo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(300, 200, 850, 620);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		//botões
		JButton OptionButton = new JButton("Gerenciar");

		OptionButton.setAction(cadastro);
		OptionButton.setFont(new Font("Tahoma",Font.BOLD,14));
		OptionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		OptionButton.setBounds(328, 266, 116, 31);
		contentPane.add(OptionButton);

		JButton OptionButton1 = new JButton("Iniciar Jogo");
		OptionButton1.setFont(new Font("Tahoma",Font.BOLD,14));
		OptionButton1.setBounds(328, 324, 116, 31);
		contentPane.add(OptionButton1);

		JButton OptionButton2 = new JButton("Jogar");
		OptionButton2.setFont(new Font("Tahoma",Font.BOLD,14));
		OptionButton2.setBounds(328, 379, 116, 31);
		contentPane.add(OptionButton2);

		JButton OptionButton3 = new JButton("Sair");
		OptionButton3.setFont(new Font("Tahoma",Font.BOLD,14));
		OptionButton3.setAction(exit);
		OptionButton3.setBounds(328, 433, 116, 31);
		contentPane.add(OptionButton3);

		JLabel imageBackg = new JLabel("");
		Image bg = new ImageIcon(this.getClass().getResource("/back1.jpg")).getImage();
		imageBackg.setIcon(new ImageIcon(bg));
		imageBackg.setBounds(0, 0, 834, 561);
		contentPane.add(imageBackg);
	}
	//construtor secundário de variáveis principais
	public JGamingFrame(String nomejogo, int peao, int qtdcasa, boolean casasEspeciais){
		setNomejogo(nomejogo);
		setPeao(peao);
		setQtdcasa(qtdcasa);
		setCasasEspeciais(casasEspeciais);
		/*
		this.nomejogo = nomejogo;
		this.peao = peao;
		this.qtdcasa = qtdcasa;
		this.casasEspeciais = casasEspeciais;*/

	}
	ArrayList<JGamingFrame> List = new ArrayList<>();
	//setters and getters
	public String getNomejogo() {
		return nomejogo;
	}

	public void setNomejogo(String nomejogo) {
		nomejogo= JOptionPane.showInputDialog(this,"Nome do Jogo:","Gerenciar Jogo", JOptionPane.PLAIN_MESSAGE);
		if(nomejogo.equals("") || nomejogo.equals(null)){
			nomejogo = "DefaultGame";
		}
		this.nomejogo = nomejogo;

	}

	public int getPeao() {
		return peao;
	}


	public void setPeao(int peao) {
		ImageIcon peIcon = new ImageIcon("res/peoes.jpg");  
		Object[] op ={"2 peões","3 peões","4 peões","5 peões"};
		switch(JOptionPane.showOptionDialog(this,"Quantidade de peões:","Gerenciar Jogo",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,peIcon,op,op[0])){
		case 0:
			peao =2;
			break;
		case 1:
			peao =3;
			break;
		case 2:
			peao =4;
			break;
		case 3:
			peao =5 ;
			break;
		default:
			peao =2;
		}
		this.peao = peao;
	}

	public int getQtdcasa() {
		return qtdcasa;
	}

	public void setQtdcasa(int qtdcasa) {
		ImageIcon peIcon = new ImageIcon("res/peoes.jpg");  
		Object[] op ={"37 casas","32 casas","21 casas"};
		switch(JOptionPane.showOptionDialog(this,"Quantidade de casas:","Gerenciar Jogo",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,peIcon,op,op[0])){
		case 0:
			qtdcasa = 37;
			break;
		case 1:
			qtdcasa = 32;
			break;
		case 2:
			qtdcasa = 21;
			break;
		default:
			qtdcasa = 37;

		}
		this.qtdcasa = qtdcasa;
	}

	public boolean getCasasEspeciais(){

		return casasEspeciais;
	}


	public void setCasasEspeciais(boolean casasEspeciais){
		ImageIcon peIcon = new ImageIcon("res/peoes.jpg"); 
		Object[] op ={"Aleatória","Inserir posição"};
		switch(JOptionPane.showOptionDialog(this,"Definir casas especiais: ","Gerenciar Jogo",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,peIcon,op,op[0])){
		case 0:
			casasEspeciais = false;
			break;
		case 1:
			casasEspeciais = true;
			break;

		default:
			casasEspeciais = false;

		}
		this.casasEspeciais = casasEspeciais;
	}

	//methods
	public void Cadastrar(){
		List.add(new JGamingFrame(nomejogo, qtdcasa, peao, casasEspeciais));
		/*setNomejogo(nomejogo);
		setQtdcasa(qtdcasa);
		setPeao(peao);
		setCasasEspeciais(casasEspeciais);*/
	}

	public void Alterar(){
		String nome = JOptionPane.showInputDialog("Digite o Nome do jogo que deseja Alterar");  
		String novoNome = JOptionPane.showInputDialog("Novo Nome: ");
		setQtdcasa(qtdcasa);
		setPeao(peao);
		setCasasEspeciais(casasEspeciais);
		for (int i = 0; i < List.size(); i++) {  
			if (List.get(i).getNomejogo().equals(nome)) {  
				List.get(i).setNomejogo(novoNome);  
				List.get(i).setQtdcasa(qtdcasa);
				List.get(i).setPeao(peao);
				List.get(i).setCasasEspeciais(casasEspeciais);
			}

		}  
	}


	public void Buscar(){  
		String nome = JOptionPane.showInputDialog(null,"Nome do Jogo:","Buscar", JOptionPane.PLAIN_MESSAGE);
		int i = List.indexOf(nome);
		if(i == -1){
			JOptionPane.showMessageDialog(null, "Jogo não encontrado");

		}else {
			JOptionPane.showMessageDialog(null, List.get(i));
		}

	}

	public void Excluir(){

		boolean found = false;
		String remover = JOptionPane.showInputDialog("Digite o Nome do jogo que deseja Excluir: ");  
		for (int i = 0; i < List.size(); i++) {  
			if (List.get(i).nomejogo.equals(remover)) {
				List.remove(i);
				/*if(List.get(i).nomejogo.equals(remover)){
					found = true;
				}
				else
					found = false;*/
			}
		}
		

	}

	//ActionListeners dos botões
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Gerenciar");
			putValue(SHORT_DESCRIPTION, "Cadastrar/Alterar/Buscar/Excluir Jogo");

		}
		public void actionPerformed(ActionEvent e) {
			ImageIcon peIcon = new ImageIcon("res/peoes.jpg");  
			Object[] op ={"Cadastrar","Alterar","Buscar","Excluir"};
			switch(JOptionPane.showOptionDialog(null,"Escolha uma opção: ","Gerenciar Jogo",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,peIcon,op,op[0])){
			case 0:
				Cadastrar();
				break;
			case 1:
				Alterar();
				break;
			case 2:
				Buscar();
				break;
			case 3:
				Excluir();
				break;
			}


		}
	}
	private class SwingAction1 extends AbstractAction {
		public SwingAction1() {
			putValue(NAME, "Sair");
			putValue(SHORT_DESCRIPTION, "Fechar jogo");
		}
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}

	}
}
