package it.corso.noleggio;

	public abstract class Veicolo {
	    private String marca;
	    private String modello;
	    private String targa;
	    private double tariffaGiornaliera;

	    public Veicolo(String marca, String modello, String targa, double tariffaGiornaliera) {
	        this.marca = marca;
	        this.modello = modello;
	        this.targa = targa;
	        this.tariffaGiornaliera = tariffaGiornaliera;
	    }

	    // Getters e toString()
	    public String getTarga() {
	        return targa;
	    }

	    public double getTariffaGiornaliera() {
	        return tariffaGiornaliera;
	    }

	    @Override
	    public String toString() {
	        return "Marca: " + marca + ", Modello: " + modello + ", Targa: " + targa +
	               ", Tariffa giornaliera: " + tariffaGiornaliera + "€";
	    }
	    
	   
	    
	    //-----------------------------------------------------
	    
	    public static class Autovettura extends Veicolo {
	        private int numeroPorte;
	        private int numeroPosti;

	        public Autovettura(String marca, String modello, String targa, double tariffaGiornaliera, int numeroPorte, int numeroPosti) {
	            super(marca, modello, targa, tariffaGiornaliera);
	            this.numeroPorte = numeroPorte;
	            this.numeroPosti = numeroPosti;
	        }

	        @Override
	        public String toString() {
	            return super.toString() + ", Porte: " + numeroPorte + ", Posti: " + numeroPosti;
	        }
	    }
	    
	    //-----------------------------------------------------
	    public static class Furgone extends Veicolo {
	        private double portataKg;
	        private double lunghezza;
	        private double larghezza;
	        private double altezza;

	        public Furgone(String marca, String modello, String targa, double tariffaGiornaliera, double portataKg, double lunghezza, double larghezza, double altezza) {
	            super(marca, modello, targa, tariffaGiornaliera);
	            this.portataKg = portataKg;
	            this.lunghezza = lunghezza;
	            this.larghezza = larghezza;
	            this.altezza = altezza;
	        }

	        @Override
	        public String toString() {
	            return super.toString() + ", Portata: " + portataKg + "kg, Dimensioni: " + lunghezza + "x" + larghezza + "x" + altezza;
	        }
	    }

	    //-----------------------------------------------------------

	}


