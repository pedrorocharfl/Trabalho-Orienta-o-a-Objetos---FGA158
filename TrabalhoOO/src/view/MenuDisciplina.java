package view;

import javax.swing.JOptionPane;

import Exceptions.CampoEmBrancoException;
import app.Disciplina;
import cadastros.CadastroDisciplina;

public class MenuDisciplina {


	public static Disciplina dadosNovaDisciplina() {
		String nome = lerNome();
		String codigo = lerCodigo();
		return new Disciplina(nome, codigo);
	}

	private static String lerNome() {
		return JOptionPane.showInputDialog("Informe o nome da disciplina: ");
	}

	private static String lerCodigo() {
		return JOptionPane.showInputDialog("Informe o código da disciplina: ");
	}

	public static void menuDisciplina(CadastroDisciplina cadDisciplina) throws CampoEmBrancoException {
		String txt = "Informe a opção desejada \n"
				+ "1 - Cadastrar disciplina\n"
				+ "2 - Pesquisar disciplina\n"
				+ "3 - Atualizar disciplina\n"
				+ "4 - Remover disciplina\n"
				+ "0 - Voltar para menu anterior";
		
		int opcao=-1;
		do {
			String strOpcao = JOptionPane.showInputDialog(txt);
			opcao = Integer.parseInt(strOpcao);

			switch (opcao) {
			case 1:
				Disciplina novaDisciplina = dadosNovaDisciplina();
				try {
					cadDisciplina.cadastrarDisciplina(novaDisciplina);
				}
				catch(CampoEmBrancoException e) {
					e.printStackTrace();
				}
				break;
				
			case 2: 
				String codigo = lerCodigo();
				Disciplina d = cadDisciplina.pesquisarDisciplina(codigo);
				if (d != null)
					JOptionPane.showMessageDialog(null, d.toString());
				break;
				
			case 3: 
				codigo = lerCodigo(); 
				Disciplina novoCadastro = dadosNovaDisciplina();
				boolean atualizado = cadDisciplina.atualizarDisciplina(codigo, novoCadastro);
				if (atualizado) {
					JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
				}
				break;
				
			case 4: 
				codigo = lerCodigo();
				Disciplina remover = cadDisciplina.pesquisarDisciplina(codigo);
				boolean removido = cadDisciplina.removerDisciplina(remover);
				if (removido) {
					JOptionPane.showMessageDialog(null, "Disciplina removida do cadastro");
					System.gc();
				}

			default:
				break;
			}
		} while (opcao != 0);
		return;
	}


}
