package cadastros;

import java.util.ArrayList;
import java.util.List;

import Exceptions.CampoEmBrancoException;
import app.Aluno;

public class CadastroAluno {
	int numAlunos; 
	private List<Aluno> alunos;
	private String blankfields;
	private String alunosTurma; 
	
	public CadastroAluno() {
		numAlunos = 0;
		alunos = new ArrayList<Aluno>();
		blankfields = "";
		alunosTurma = "";
	}
	
	public int cadastrarAluno(Aluno a) throws CampoEmBrancoException {
        blankfields = "";
		
        if (a.getNome().isEmpty()) {
            blankfields += "|Nome| ";
        }
        if (a.getCpf().isEmpty()) {
        	blankfields += "|CPF| ";
        }
        if (a.getMatricula().isEmpty()) {
        	blankfields += "|Matrícula| ";
        }
        if (a.getEmail().isEmpty()) {
        	blankfields += "|Email| ";
        }
        if (a.getCurso().isEmpty()) {
        	blankfields += "|Curso| ";
        }
        
        if(blankfields != "") {
        	throw new CampoEmBrancoException(blankfields);
        }
        
        
        boolean cadastrou = alunos.add(a);
        if (cadastrou) {
            numAlunos = alunos.size();
        }
        return numAlunos;
    }
		
	
	public Aluno pesquisarAluno(String matriculaAluno) {
		for (Aluno a: alunos) {
			if (a.getMatricula().equalsIgnoreCase(matriculaAluno)) {
				return a;
			}
		}
		return null;
	}
	
	//Método que retorna uma String contendo todos os alunos da turma selecionada
	public String getAlunosTurma(String codigoTurma) {
		alunosTurma = "";
		
		//percorre e filtra todo o vetor de alunos, adicionando na string alunosTurma todos aqueles de determinada turma.
		for(Aluno a: alunos) { 
			if(a.getCodturma().equalsIgnoreCase(codigoTurma)) {
				alunosTurma += "Aluno " + a.getNome() + "\n";
			}
		}	
		if (!alunosTurma.isEmpty()) {
		    return alunosTurma;
		} 
		else {
		    return "";
		}
	}
	
	public boolean removerAluno(Aluno a) {
		boolean removeu = false; 
		if (alunos.contains(a)) {
			removeu = alunos.remove(a);
		}
		return removeu;
	}
	
	public boolean atualizarAluno(String matricula, Aluno a) {
		boolean resposta = false;
		Aluno remover = pesquisarAluno(matricula);
		if (remover != null) {
			alunos.remove(remover);
			resposta = alunos.add(a);
		}
		return resposta;
	}
}












