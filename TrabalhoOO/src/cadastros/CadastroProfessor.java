package cadastros;

import java.util.ArrayList;
import java.util.List;

import Exceptions.CampoEmBrancoException;
import app.Professor;

public class CadastroProfessor {
	int numProfessores; 
	private List<Professor> professores;
	private String blankfields;
	
	public CadastroProfessor() {
		numProfessores = 0;
		professores = new ArrayList<Professor>();
		blankfields = "";
	}
	
	public int cadastrarProfessor(Professor p) throws CampoEmBrancoException {
        blankfields = "";
		
        if (p.getNome().isEmpty()) {
            blankfields += "|Nome| ";
        }
        if (p.getCpf().isEmpty()) {
        	blankfields += "|CPF| ";
        }
        if (p.getMatriculaFUB().isEmpty()) {
        	blankfields += "|Matrícula| ";
        }
        if (p.getEmail().isEmpty()) {
        	blankfields += "|Email| ";
        }
        if (p.getCursoMinistrado().isEmpty()) {
        	blankfields += "|Curso Ministrado| ";
        }
        
        if(blankfields != "") {
        	throw new CampoEmBrancoException(blankfields);
        }
        
        
        boolean cadastrou = professores.add(p);
        if (cadastrou) {
            numProfessores = professores.size();
        }
        return numProfessores;
    }
		
	public Professor pesquisarProfessor(String matriculaProfessor) {
		for (Professor p: professores) {
			if (p.getMatriculaFUB().equalsIgnoreCase(matriculaProfessor)) {
				return p;
			}
		}
		return null;
	}
	
	public boolean removerProfessor(Professor p) {
		boolean removeu = false; 
		if (professores.contains(p)) {
			removeu = professores.remove(p);
		}
		return removeu;
	}
	
	public boolean atualizarProfessor(String matricula, Professor p) {
		boolean resposta = false;
		Professor remover = pesquisarProfessor(matricula);
		if (remover != null) {
			professores.remove(remover);
			resposta = professores.add(p);
		}
		return resposta;
	}
}












