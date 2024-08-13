package view;

import javax.swing.JOptionPane;

import Exceptions.CampoEmBrancoException;
import app.Professor;
import cadastros.CadastroProfessor;

public class MenuProfessor {

	public static Professor dadosNovoProfessor() {
		String nome = lerNome();
		String cpf = lerCPF();
		String email = lerEmail();
		String formacao = lerFormacao();
		String matricula = lerMatricula(); 
		return new Professor(nome, cpf, email, formacao, matricula);
	}

	private static String lerFormacao() {
		return JOptionPane.showInputDialog("Informe o curso a ser ministrado pelo professor: ");
	}

	private static String lerEmail() {
		return JOptionPane.showInputDialog("Informe o email do professor: ");
	}

	private static String lerCPF() {
		return JOptionPane.showInputDialog("Informe o CPF do professor: ");
	}

	private static String lerNome() {
		return JOptionPane.showInputDialog("Informe o nome do professor: ");
	}

	private static String lerMatricula() {
		return JOptionPane.showInputDialog("Informe a matricula do professor: ");
	}

	public static void menuProfessor(CadastroProfessor cadProfessor) throws CampoEmBrancoException {
		String txt = "Informe a opção desejada \n"
				+ "1 - Cadastrar professor\n"
				+ "2 - Pesquisar professor\n"
				+ "3 - Atualizar professor\n"
				+ "4 - Remover professor\n"
				+ "0 - Voltar para menu anterior";
		
		int opcao=-1;
		do {
			String strOpcao = JOptionPane.showInputDialog(txt);
			opcao = Integer.parseInt(strOpcao);

			switch (opcao) {
			case 1:
				Professor novoProfessor = dadosNovoProfessor();
				try {
					cadProfessor.cadastrarProfessor(novoProfessor);
				}
				catch(CampoEmBrancoException e) {
					e.printStackTrace();
				}
				break;
				
			case 2: 
				String matricula = lerMatricula();
				Professor p = cadProfessor.pesquisarProfessor(matricula);
				if (p != null)
					JOptionPane.showMessageDialog(null, p.toString());
				break;
				
			case 3: 
				matricula = lerMatricula(); 
				Professor novoCadastro = dadosNovoProfessor();
				boolean atualizado = cadProfessor.atualizarProfessor(matricula, novoCadastro);
				if (atualizado) {
					JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
				}
				break;
				
			case 4: 
				matricula = lerMatricula();
				Professor remover = cadProfessor.pesquisarProfessor(matricula);
				boolean removido = cadProfessor.removerProfessor(remover);
				if (removido) {
					JOptionPane.showMessageDialog(null, "Professor removido do cadastro");
					System.gc();
				}

			default:
				break;
			}
		} while (opcao != 0);
		return;
	}


}
