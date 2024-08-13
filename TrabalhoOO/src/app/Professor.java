package app;

public class Professor extends PessoaFisica{
	
	String cursoMinistrado, 
	       matriculaFUB; 
	
	public Professor(String nome, String cpf, String email, String cursoMinistrado, String matriculaFUB) {
		super(nome, cpf, email);
		this.cursoMinistrado = cursoMinistrado;
		this.matriculaFUB = matriculaFUB;
	}

	public final String getCursoMinistrado() {
		return cursoMinistrado;
	}

	public final String getMatriculaFUB() {
		return matriculaFUB;
	}
	
	protected void finalize() throws Throwable {
		System.out.println("Destruindo objeto: " + this);
	}
	
	public String toString() {
		String resposta = super.toString();
		resposta += "Matrícula FUB: " + matriculaFUB + '\n';
		resposta += "Ministra: " + cursoMinistrado + '\n';
		return resposta;
	}
}
