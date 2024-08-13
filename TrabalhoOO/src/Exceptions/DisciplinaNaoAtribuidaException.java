package Exceptions;

public class DisciplinaNaoAtribuidaException extends Exception {

	private static final long serialVersionUID = 1L;

	private String mensagem;
	
	public DisciplinaNaoAtribuidaException() {
		super();
		mensagem = "Não foi possível cadastrar a turma porque uma DISCIPLINA não foi associada e/ou não existe no cadastro de disciplinas!";
	}

	@Override
	public String toString() {
		return "DisciplinaNaoAtribuidaException [mensagem=" + mensagem + "]";
	}
	
}
