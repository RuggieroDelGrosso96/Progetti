package it.corso.noleggio;
public class Cliente {

	private String nome, cognome, numeroPatente;
	
	//costruttore
	public Cliente (String nome, String cognome, String numeroPatente) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.numeroPatente = numeroPatente;		
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cognome=" + cognome + ", numeroPatente=" + numeroPatente + "]";
	}
	
	
}
