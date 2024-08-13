package view;

import javax.swing.JOptionPane;

import Exceptions.CampoEmBrancoException;
import Exceptions.DisciplinaNaoAtribuidaException;
import Exceptions.ProfessorNaoAtribuidoException;
import app.Turma;
import cadastros.CadastroDisciplina;
import cadastros.CadastroTurma;
import cadastros.CadastroAluno;
import cadastros.CadastroProfessor;
import app.Disciplina;
import app.Professor;

public class MenuTurma {

	public static Turma dadosNovaTurma(CadastroDisciplina cadDisciplina, CadastroProfessor cadProfessor) {
		String codigo = lerCodigo();
		Disciplina disciplina = lerDisciplina(cadDisciplina);
		Professor professor = lerProfessor(cadProfessor);
		return new Turma(codigo, disciplina, professor);
	}

	private static String lerCodigo() {
		return JOptionPane.showInputDialog("Informe o código da turma: ");
	}
	
	private static Disciplina lerDisciplina(CadastroDisciplina cadDisciplina) {
		String stringDisciplina = "";
		stringDisciplina = JOptionPane.showInputDialog("Informe o código da disciplina: ");
		
		//chamar o método que pesquisa se a disciplina existe no banco de cadastros.		
		return cadDisciplina.pesquisarDisciplina(stringDisciplina);
		
	}
	
	private static Professor lerProfessor(CadastroProfessor cadProfessor) {
		String stringMatricula = "";
		stringMatricula = JOptionPane.showInputDialog("Informe a matrícula do professor: ");
		
		//chamar o método que pesquisa se o professor existe no banco de cadastros.
		return cadProfessor.pesquisarProfessor(stringMatricula);
		
	}


	public static void menuTurma(CadastroTurma cadTurma, CadastroDisciplina cadDisciplina, CadastroProfessor cadProfessor, CadastroAluno cadAluno) {
		String txt = "Informe a opção desejada \n"
				+ "1 - Cadastrar turma\n"
				+ "2 - Pesquisar turma\n"
				+ "3 - Atualizar turma\n"
				+ "4 - Remover turma\n"
				+ "5 - Lista de presença\n"
				+ "0 - Voltar para menu anterior";
		
		int opcao=-1;
		do {
			String strOpcao = JOptionPane.showInputDialog(txt);
			opcao = Integer.parseInt(strOpcao);

			switch (opcao) {
			case 1:
				Turma novaTurma = dadosNovaTurma(cadDisciplina, cadProfessor);
				try {
					cadTurma.cadastrarTurma(novaTurma, cadDisciplina, cadProfessor); 
				}
				catch(CampoEmBrancoException e) {
					e.printStackTrace();
				}
				catch(DisciplinaNaoAtribuidaException d) {
					d.printStackTrace();
				}
				catch(ProfessorNaoAtribuidoException p) {					
					p.printStackTrace();
				}
				
				break;
				
			case 2: 
				String codigo = lerCodigo();
				Turma t = cadTurma.pesquisarTurma(codigo);
				if (t != null)
					JOptionPane.showMessageDialog(null, t.toString());
				break;
				
			case 3: 
				codigo = lerCodigo(); 
				Turma novoCadastro = dadosNovaTurma(cadDisciplina, cadProfessor);
				boolean atualizado = cadTurma.atualizarTurma(codigo, novoCadastro);
				if (atualizado) {
					JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
				}
				break;
				
			case 4: 
				codigo = lerCodigo();
				Turma remover = cadTurma.pesquisarTurma(codigo);
				boolean removido = cadTurma.removerTurma(remover);
				if (removido) {
					JOptionPane.showMessageDialog(null, "Disciplina removida do cadastro");
					System.gc();
				}
				break;
				
			case 5:
				codigo = lerCodigo();
				t = cadTurma.pesquisarTurma(codigo);
				if(t != null) {
					JOptionPane.showMessageDialog(null, "DISCIPLINA " + t.getDisciplina().getNome().toUpperCase() + "\n" 
							+ cadAluno.getAlunosTurma(codigo));
				}
				break;
				
			default:
				break;
			}
		} while (opcao != 0);
		return;
	}
}
