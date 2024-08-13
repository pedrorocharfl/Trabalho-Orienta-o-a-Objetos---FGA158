package cadastros;

import java.util.ArrayList;
import java.util.List;

import Exceptions.CampoEmBrancoException;
import app.Disciplina;

public class CadastroDisciplina {
    private List<Disciplina> disciplinas;
    private String blankfields;

    public CadastroDisciplina() {
        disciplinas = new ArrayList<Disciplina>();
        blankfields = "";
    }

    public void cadastrarDisciplina(Disciplina disciplina) throws CampoEmBrancoException{
        blankfields = "";
        
        if(disciplina.getNome().isEmpty()) {
        	blankfields += "|Nome da disciplina| ";
        }
        if(disciplina.getCodigo().isEmpty()) {
        	blankfields += "|Código da disciplina| ";
        }
        
        if(blankfields != "") {
        	throw new CampoEmBrancoException(blankfields);
        }
        
    	disciplinas.add(disciplina);
    }

    public Disciplina pesquisarDisciplina(String codigo) {
    	for (Disciplina disciplina : disciplinas) {
            if (disciplina.getCodigo().equals(codigo)) {
            	return disciplina;
            }
        }   	
        return null;
    }


    public boolean removerDisciplina(Disciplina d) {
		boolean removeu = false; 
		if (disciplinas.contains(d)) {
			removeu = disciplinas.remove(d);
		}
		return removeu;
	}
    
    public boolean atualizarDisciplina(String codigo, Disciplina disciplinaAtualizada) {
		boolean resposta = false;
		Disciplina remover = pesquisarDisciplina(codigo);
		if (remover != null) {
			disciplinas.remove(remover);
			resposta = disciplinas.add(disciplinaAtualizada);
		}
		return resposta;
	}
}
