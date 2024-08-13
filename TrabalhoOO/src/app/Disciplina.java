package app;

public class Disciplina {
    private String nome;
    private String codigo;

    // Construtor
    public Disciplina(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getCodigo() {
    	if(codigo == "NULL") {
    		return null;
    	}
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    protected void finalize() throws Throwable {
		System.out.println("Destruindo objeto: " + this);
	}
	
	public String toString() {
		String resposta = super.toString();
		resposta += "\nCódigo: " + codigo + '\n';
		resposta += "Disciplina: " + nome + '\n';
		return resposta;
	}  

}

