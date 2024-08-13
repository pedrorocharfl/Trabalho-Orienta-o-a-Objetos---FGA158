package app;


public class Turma {
    private String codigo;
    private Disciplina disciplina;
    private Professor professor;
    
    private Disciplina blankDiscipline = new Disciplina("NULL", "NULL");
    private Professor blankProfessor = new Professor("NULL", "NULL", "NULL", "NULL", "NULL");

    //Construtor
    public Turma(String codigo, Disciplina disciplina, Professor professor) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
    }
    
    //Getters
    public String getCodigo() {
        return codigo;
    }

    public Disciplina getDisciplina() {
        if(disciplina == null) {
        	return blankDiscipline;
        }
    	return disciplina;
    }

    public Professor getProfessor() {   	
        if(professor == null) {
        	return blankProfessor;
        }
    	return professor;
    }
    
    protected void finalize() throws Throwable {
		System.out.println("Destruindo objeto: " + this);
	}
	
	public String toString() {
		String resposta = super.toString();
		resposta += "\nCódigo: " + codigo + '\n';
		resposta += "Disciplina: " + disciplina.getNome() + '\n';
		resposta += "Professor: " + professor.getNome() + '\n'; 
		return resposta;
	}
	
}
