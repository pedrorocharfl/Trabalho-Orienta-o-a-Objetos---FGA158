package cadastros;

import java.util.ArrayList;
import java.util.List;

import Exceptions.CampoEmBrancoException;
import Exceptions.DisciplinaNaoAtribuidaException;
import Exceptions.ProfessorNaoAtribuidoException;
import app.Turma;


public class CadastroTurma {
    private List<Turma> turmas;

    public CadastroTurma() {
        this.turmas = new ArrayList<>();
    }

    
    public void cadastrarTurma(Turma turma, CadastroDisciplina cadDisciplina, CadastroProfessor cadProfessor) throws CampoEmBrancoException, DisciplinaNaoAtribuidaException, ProfessorNaoAtribuidoException {
        
    	if(turma.getCodigo().isEmpty()) {
        	throw new CampoEmBrancoException("|Código da disciplina|");
        }
        
        if(cadDisciplina.pesquisarDisciplina(turma.getDisciplina().getCodigo()) == null) {
        	throw new DisciplinaNaoAtribuidaException();
        }
    	
        if(cadProfessor.pesquisarProfessor(turma.getProfessor().getMatriculaFUB()) == null) {
        	throw new ProfessorNaoAtribuidoException();
        }
                
    	turmas.add(turma);
    }

    public Turma pesquisarTurma(String codigo) {
        for (Turma turma : turmas) {
            if (turma.getCodigo().equals(codigo)) {
                return turma;
            }
        }
        return null;
    }

    public boolean removerTurma(Turma turma) {
		boolean removeu = false; 
		if (turmas.contains(turma)) {
			removeu = turmas.remove(turma);
		}
		return removeu;
	}

    public boolean atualizarTurma(String codigo, Turma turma) {
		boolean resposta = false;
		Turma remover = pesquisarTurma(codigo);
		if (remover != null) {
			turmas.remove(remover);
			resposta = turmas.add(turma);
		}
		return resposta;
	}
}
