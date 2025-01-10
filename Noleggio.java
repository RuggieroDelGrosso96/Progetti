package it.corso.noleggio;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Noleggio {

	private LocalDate dataInizio, dataFine;
	private Veicolo veicolo;
	private Cliente cliente;
	private Double importoTotale;
	
	public Noleggio(LocalDate dataInizio, LocalDate dataFine, Veicolo veicolo, Cliente cliente, double importoTotale2) {
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.veicolo = veicolo;
        this.cliente = cliente;
        this.importoTotale = veicolo.getTariffaGiornaliera() * (ChronoUnit.DAYS.between(dataInizio, dataFine) +1);
    }

	@Override
	public String toString() {
		return "Noleggio [dataInizio=" + dataInizio + ", dataFine=" + dataFine + ", veicolo=" + veicolo + ", cliente="
				+ cliente + ", importoTotale=" + importoTotale + "]";
	}
	
}
