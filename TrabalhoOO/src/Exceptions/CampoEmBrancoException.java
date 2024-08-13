package Exceptions;

public class CampoEmBrancoException extends Exception {

	private static final long serialVersionUID = 1L;

	private String camposBrancos;
	
	public CampoEmBrancoException(String camposBrancos) {
		super();
		this.camposBrancos = camposBrancos;
	}

	@Override
	public String toString() {
		return "CampoEmBrancoException [Campo[s] em branco = " + camposBrancos + "]";
	}
	
		
}
