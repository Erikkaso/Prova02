package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import negocio.Planetas;
import negocio.Plano;
import negocio.Python;


public class JPrincipal  extends JFrame{

	public PainelPlano painelPlano;
	public Plano plano;
	
	public JPrincipal() {
		Plano plano = new Plano();
		painelPlano = new PainelPlano(plano);
		
	    PainelBotoes painelBotoes = new PainelBotoes(this, painelPlano); 	
		
		this.setSize(600, 300);
		this.setBackground(Color.LIGHT_GRAY);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	//	this.add(painelBotoes, BorderLayout.EAST);

		painelPlano.setVisible(true);

		
		
		JPanel painelGenerico = new JPanel();
		
		painelGenerico.add(painelPlano);
		painelGenerico.add(painelBotoes);

		this.add(painelGenerico, BorderLayout.CENTER);
		this.setVisible(true);
	}
	

}
