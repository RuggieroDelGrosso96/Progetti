package it.corso.noleggio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.corso.noleggio.Veicolo.Autovettura;
import it.corso.noleggio.Veicolo.Furgone;

public class Test {
    // Liste per veicoli, clienti e noleggi
    private static List<Veicolo> veicoli = new ArrayList<>();
    private static List<Cliente> clienti = new ArrayList<>();
    private static List<Noleggio> noleggi = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scelta;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Aggiungi un veicolo");
            System.out.println("2. Aggiungi un cliente");
            System.out.println("3. Registra un noleggio");
            System.out.println("4. Visualizza veicoli");
            System.out.println("5. Visualizza clienti");
            System.out.println("6. Visualizza noleggi");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");
            scelta = scanner.nextInt();
            scanner.nextLine(); // Pulisce il buffer dello scanner

            switch (scelta) {
                case 1: // Aggiungi un veicolo
                    aggiungiVeicolo(scanner);
                    break;
                case 2: // Aggiungi un cliente
                    aggiungiCliente(scanner);
                    break;
                case 3: // Registra un noleggio
                    registraNoleggio(scanner);
                    break;
                case 4: // Visualizza veicoli
                    visualizzaVeicoli();
                    break;
                case 5: // Visualizza clienti
                    visualizzaClienti();
                    break;
                case 6: // Visualizza noleggi
                    visualizzaNoleggi();
                    break;
                case 0:
                    System.out.println("Uscita dal programma...");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        } while (scelta != 0);

        scanner.close();
    }

    private static void aggiungiVeicolo(Scanner scanner) {
        System.out.println("Che tipo di veicolo vuoi aggiungere? (1 = Autovettura, 2 = Furgone): ");
        int tipoVeicolo = scanner.nextInt();
        scanner.nextLine(); // Pulisce il buffer dello scanner

        if (tipoVeicolo == 1) {
            System.out.print("Inserisci marca: ");
            String marca = scanner.nextLine();
            System.out.print("Inserisci modello: ");
            String modello = scanner.nextLine();
            System.out.print("Inserisci targa: ");
            String targa = scanner.nextLine();
            System.out.print("Inserisci tariffa giornaliera: ");
            double tariffaGiornaliera = scanner.nextDouble();
            System.out.print("Inserisci numero di porte: ");
            int numeroPorte = scanner.nextInt();
            System.out.print("Inserisci numero di posti: ");
            int numeroPosti = scanner.nextInt();
            scanner.nextLine(); // Pulisce il buffer dello scanner

            Autovettura auto = new Autovettura(marca, modello, targa, tariffaGiornaliera, numeroPorte, numeroPosti);
            veicoli.add(auto);
            System.out.println("Autovettura aggiunta con successo!");
        } else if (tipoVeicolo == 2) {
            System.out.print("Inserisci marca: ");
            String marca = scanner.nextLine();
            System.out.print("Inserisci modello: ");
            String modello = scanner.nextLine();
            System.out.print("Inserisci targa: ");
            String targa = scanner.nextLine();
            System.out.print("Inserisci tariffa giornaliera: ");
            double tariffaGiornaliera = scanner.nextDouble();
            System.out.print("Inserisci portata (kg): ");
            double portataKg = scanner.nextDouble();
            System.out.print("Inserisci lunghezza: ");
            double lunghezza = scanner.nextDouble();
            System.out.print("Inserisci larghezza: ");
            double larghezza = scanner.nextDouble();
            System.out.print("Inserisci altezza: ");
            double altezza = scanner.nextDouble();
            scanner.nextLine(); // Pulisce il buffer dello scanner

            Furgone furgone = new Furgone(marca, modello, targa, tariffaGiornaliera, portataKg, lunghezza, larghezza, altezza);
            veicoli.add(furgone);
            System.out.println("Furgone aggiunto con successo!");
        } else {
            System.out.println("Opzione non valida.");
        }
    }

    private static void aggiungiCliente(Scanner scanner) {
        System.out.print("Inserisci nome: ");
        String nome = scanner.nextLine();
        System.out.print("Inserisci cognome: ");
        String cognome = scanner.nextLine();
        System.out.print("Inserisci numero patente: ");
        String numeroPatente = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cognome, numeroPatente);
        clienti.add(cliente);
        System.out.println("Cliente aggiunto con successo!");
    }

    private static void registraNoleggio(Scanner scanner) {
        if (veicoli.isEmpty() || clienti.isEmpty()) {
            System.out.println("Non ci sono veicoli o clienti registrati.");
            return;
        }

        // Mostra la lista dei veicoli
        System.out.println("Seleziona un veicolo:");
        for (int i = 0; i < veicoli.size(); i++) {
            System.out.println(i + " - " + veicoli.get(i));
        }
        System.out.print("Inserisci il numero del veicolo: ");
        int veicoloIndex = scanner.nextInt();
        scanner.nextLine();

        if (veicoloIndex < 0 || veicoloIndex >= veicoli.size()) {
            System.out.println("Indice del veicolo non valido.");
            return;
        }
        Veicolo veicoloScelto = veicoli.get(veicoloIndex);

        // Mostra la lista dei clienti
        System.out.println("Seleziona un cliente:");
        for (int i = 0; i < clienti.size(); i++) {
            System.out.println(i + " - " + clienti.get(i));
        }
        System.out.print("Inserisci il numero del cliente: ");
        int clienteIndex = scanner.nextInt();
        scanner.nextLine();

        if (clienteIndex < 0 || clienteIndex >= clienti.size()) {
            System.out.println("Indice del cliente non valido.");
            return;
        }
        Cliente clienteScelto = clienti.get(clienteIndex);

        // Inserisci le date
        System.out.print("Inserisci la data di inizio (yyyy-MM-dd): ");
        LocalDate dataInizio = LocalDate.parse(scanner.nextLine());
        System.out.print("Inserisci la data di fine (yyyy-MM-dd): ");
        LocalDate dataFine = LocalDate.parse(scanner.nextLine());

        if (dataFine.isBefore(dataInizio)) {
            System.out.println("La data di fine deve essere successiva alla data di inizio.");
            return;
        }

        // Calcola importo totale
        long giorniNoleggio = java.time.temporal.ChronoUnit.DAYS.between(dataInizio, dataFine);
        double importoTotale = veicoloScelto.getTariffaGiornaliera() * giorniNoleggio;

        // Registra il noleggio
        Noleggio noleggio = new Noleggio(dataInizio, dataFine, veicoloScelto, clienteScelto, importoTotale);
        noleggi.add(noleggio);
        System.out.println("Noleggio registrato con successo!");
    }

    private static void visualizzaVeicoli() {
        if (veicoli.isEmpty()) {
            System.out.println("Nessun veicolo registrato.");
        } else {
            System.out.println("Lista veicoli:");
            veicoli.forEach(System.out::println);
        }
    }

    private static void visualizzaClienti() {
        if (clienti.isEmpty()) {
            System.out.println("Nessun cliente registrato.");
        } else {
            System.out.println("Lista clienti:");
            clienti.forEach(System.out::println);
        }
    }

    private static void visualizzaNoleggi() {
        if (noleggi.isEmpty()) {
            System.out.println("Nessun noleggio registrato.");
        } else {
            System.out.println("Lista noleggi:");
            noleggi.forEach(System.out::println);
        }
    }
}
