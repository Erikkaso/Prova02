package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import negocio.Bug;
import negocio.Desenvolvedor;
import negocio.Plano;
import persistencia.LerDados;

public class PainelBotoes extends JPanel implements ActionListener {

	private int aux = 0;
	private JPrincipal janela;
	private Botao proxInstante;
	private Botao lerArquivoDeEntrada;
	private Botao gravarRelatorio;
	private Botao lerDadosParticipantes;
	private Botao gravarArquivo;
	private PainelPlano painelPlano;
	private LerDados dados;

	public PainelBotoes(JPrincipal janela, PainelPlano p) {
		this.painelPlano = p;
		this.janela = janela;
		criarBotoes();
		this.setBackground(Color.ORANGE);
	}

	private void criarBotoes() {
		proxInstante = new Botao("Processar Proximo Instante", Color.gray);
		proxInstante.addActionListener(this);

		lerArquivoDeEntrada = new Botao("Ler Novo Arquivo de Entrada", Color.gray);
		lerArquivoDeEntrada.addActionListener(this);
//		
		gravarRelatorio = new Botao("Gravar Relatorio", Color.gray);
//		gravarRelatorio.addActionListener(new MostrarRelatorio(janela));
//		
		lerDadosParticipantes = new Botao("Ler Dados de Outros Participantes", Color.gray);
//		lerDadosParticipantes.addActionListener(new MostrarClientes(janela));

		gravarArquivo = new Botao("Gravar Arquivo de Saida", Color.gray);

		this.setLayout(new GridLayout(5, 1));
		this.add(proxInstante);
		this.add(lerArquivoDeEntrada);
		this.add(gravarRelatorio);
		this.add(lerDadosParticipantes);
		this.add(gravarArquivo);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == proxInstante) {

			try {
				for (int i = 0; i < dados.lista.get(aux).valores[7]; i++) {
					painelPlano.p.listaBug.add(new Bug(painelPlano.p));
				}
				for (int i = 0; i < dados.lista.get(aux).valores[8]; i++) {
					painelPlano.p.listaDesenvolvedor.add(new Desenvolvedor(painelPlano.p));
				}
				// if (aux < dados.lista.size()) {
				for (int i = 0; i < 7; i++) {
					painelPlano.p.listaPlanetas.get(i + 1).valor += dados.lista.get(aux).valores[i];
					painelPlano.p.listaPlanetas.get(i + 1).avancar();
				}

				// }
				aux++;
				painelPlano.criarPlano();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Nao ha arquivos para ser lidos.", "Aviso",
						JOptionPane.WARNING_MESSAGE);
			}

		}

		if (e.getSource() == lerArquivoDeEntrada) {
			Object[] opcoes = { "10", "50", "100", "500", "1000", "1500", "2000" };
			int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Escolha qual arquivo deseja ler:", null,
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
			dados = new LerDados(opcaoSelecionada);
			aux = 0;
		}

		else if (e.getSource() == gravarRelatorio) {

		} else if (e.getSource() == lerDadosParticipantes) {

		} else if (e.getSource() == gravarArquivo) {

		}

	}
}
