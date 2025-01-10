package it.corso.noleggio;
import java.util.ArrayList;
import java.util.List;


public class Autonoleggio {
    private List<Veicolo> veicoli;
    private List<Cliente> clienti;
    private List<Noleggio> noleggi;

    public Autonoleggio() {
        this.veicoli = new ArrayList<>();
        this.clienti = new ArrayList<>();
        this.noleggi = new ArrayList<>();
    }

    public void aggiungiVeicolo(Veicolo veicolo) {
        veicoli.add(veicolo);
    }

    public void aggiungiCliente(Cliente cliente) {
        clienti.add(cliente);
    }

    public void aggiungiNoleggio(Noleggio noleggio) {
        noleggi.add(noleggio);
    }

    public void visualizzaVeicoli() {
        veicoli.forEach(System.out::println);
    }

    public void visualizzaClienti() {
        clienti.forEach(System.out::println);
    }

    public void visualizzaNoleggi() {
        noleggi.forEach(System.out::println);
    }

	public List<Veicolo> getVeicoli() {
		return veicoli;
	}

	public void setVeicoli(List<Veicolo> veicoli) {
		this.veicoli = veicoli;
	}

	public List<Cliente> getClienti() {
		return clienti;
	}

	public void setClienti(List<Cliente> clienti) {
		this.clienti = clienti;
	}


}
