package Exceptions;

public class ProfessorNaoAtribuidoException extends Exception {


	private static final long serialVersionUID = 1L;

	private String mensagem;
	
	public ProfessorNaoAtribuidoException() {
		super();
		mensagem = "Não foi possível cadastrar a turma porque um PROFESSOR não foi associado e/ou não existe no cadastro de professores!";
	}
	
	@Override
	public String toString() {
		return "ProfessorNaoAtribuidoException [mensagem=" + mensagem + "]";
	}
}
