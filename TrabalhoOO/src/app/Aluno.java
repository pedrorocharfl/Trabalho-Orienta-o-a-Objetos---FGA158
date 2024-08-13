package app;

public class Aluno extends PessoaFisica{

	String matricula, 
	       curso,
	       codturma;
	
	public Aluno(String nome, String cpf, String email, String matricula, String curso, String codturma) {
		super(nome, cpf, email);
		this.matricula = matricula;
		this.curso = curso;
		this.codturma = codturma;
	}

	public final String getMatricula() {
		return matricula;
		
	}

	public final String getCurso() {
		return curso;
	}
	
	public final String getCodturma() {
		return codturma;
	}
	
	
	protected void finalize() throws Throwable {
		System.out.println("Destruindo objeto: " + this);
	}
	
	public String toString() {
		String resposta = super.toString();
		resposta += "MATRICULA: " + matricula + '\n';
		resposta += "CURSO: " + curso + '\n';
		return resposta;
	}

}
