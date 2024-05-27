import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String ADMIN_PASSWORD = "123456789";

public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	Scanner numeri = new Scanner(System.in);
    Menu menu = new Menu();
    Tavolo uno = new Tavolo(1, 100.0, 100.0, 100.0, "Legno", 2);
    Tavolo due = new Tavolo(2, 100.0, 100.0, 100.0, "Legno", 2);
    Tavolo tre = new Tavolo(3, 150.0, 100.0, 100.0, "Legno", 4);
    Tavolo quattro = new Tavolo(4, 150.0, 100.0, 100.0 , "Legno", 4);
    Tavolo cinque = new Tavolo(5, 200.0, 100.0, 100.0, "Legno", 6);
    Ristorante ristoranteCjoj= new Ristorante("Cjoj");
    
    ristoranteCjoj.addCameriere("Andrea",24,60,121311);
    ristoranteCjoj.addCameriere("Alessandro",14,50,15684);

    ristoranteCjoj.addRecensione("Renato","cibo ottimo");
    ristoranteCjoj.addRecensione("Silvestro","ottimo servizio");

    ristoranteCjoj.addCuoco("Gino","cibo italiano",60,13412);
    ristoranteCjoj.addCuoco("Luigi","cibo greco",50,16412);

    while (true) {
        System.out.println("===========================================");
        System.out.println("        Benvenuto al ristorante Cjoj! ");
        System.out.println("===========================================");
        System.out.println();
        System.out.print("Sei un amministratore, un cliente o vuoi visualizzare le recensioni? (a/c/r): ");
        String tipoUtente = scanner.nextLine();

        if (tipoUtente.equalsIgnoreCase("a")) {

        	System.out.print("Inserisci la password di amministrazione: ");
            String password = scanner.nextLine();

            if (password.equals(ADMIN_PASSWORD)) {
                System.out.println("Accesso come amministratore riuscito.");


                    while (true) {
                        System.out.println("Scegli un'operazione:");
                        System.out.println("1. Aggiungi cuoco");
                        System.out.println("2. Elimina cuoco");
                        System.out.println("3. Aggiungi cameriere");
                        System.out.println("4. Elimina cameriere");
                        System.out.println("5. Stampa i cuochi");
                        System.out.println("6. Stampa i camerieri");
                        System.out.println("7. Aggiungi piatti al menu");
                        System.out.println("8. Rimuovi piatti dal menu");
                        System.out.println("9. Prenota tavoli");
                        System.out.println("10. Libera tavoli");
                        System.out.println("11. Torna al menu principale");

                        
                        int scelta = scanner.nextInt();
                        scanner.nextLine(); 

                        switch (scelta) {
                            case 1:
                                ristoranteCjoj.aggiungiCuoco();
                                System.out.println("Cuoco aggiunto con successo!");
                                System.out.println( );
                                break;
                            case 2:
                                ristoranteCjoj.eliminaCuoco();
                                System.out.println("Cuoco eliminato con successo!");
                                System.out.println( );
                                break;
                            case 3:
                                 ristoranteCjoj.aggiungiCameriere();
                                 System.out.println("Cameriere aggiunto con successo!");
                                 System.out.println( );
                                break;
                            case 4:
                                ristoranteCjoj.eliminaCameriere();
                                System.out.println("Cameriere eliminato con successo!");
                                System.out.println( );
                               break;     
                            case 5:
                                ristoranteCjoj.stampaCuochi();
                                System.out.println("Cuochi stampati con successo!");
                                System.out.println( );
                               break; 
                            case 6:
                                ristoranteCjoj.stampaCamerieri();
                                System.out.println("Camerieri stampati con successo!");
                                System.out.println( );
                               break; 
                            case 7:	
                            	System.out.println("Inserisci nome e prezzo del piatto: ");
                            	String nome = scanner.nextLine();
                            	double prezzo = scanner.nextDouble();
                            	menu.aggiungiPiatto(nome, prezzo);
                            	break;
                            case 8:
                            	ArrayList<Piatto> piatti = menu.getPiatti();
                            	// menu.caricaMenuDaFile("menu.txt");
                            	System.out.println("Seleziona il piatto da rimuovere: ");
                				int id = scanner.nextInt();
                				if(id > menu.getMenuSize(piatti)) {
                					System.out.println("Input non valido. Tornando al menu dell'admin...");
                					break;
                				}
                				menu.rimuoviPiatto(id);
                				System.out.println("Il piatto e' stato rimosso con successo.");
                				break;
                            case 9:
                            	uno.stampaInformazioni();
                            	System.out.println(" ");
                            	due.stampaInformazioni();
                            	System.out.println(" ");
                            	tre.stampaInformazioni();
                            	System.out.println(" ");
                            	quattro.stampaInformazioni();
                            	System.out.println(" ");
                            	cinque.stampaInformazioni();
                            	System.out.println(" ");
                            	
                            	int numero;
                            	System.out.println("Che tavolo vuoi riservare?");
                            	numero = scanner.nextInt();
                            	if(numero > 5 || numero < 1) {
                            		System.out.println("Il tavolo non esiste.");
                            		break;
                            	}
                            	if(numero == 1) uno.prenota();
                            	if(numero == 2) due.prenota();
                            	if(numero == 3) tre.prenota();
                            	if(numero == 4) quattro.prenota();
                            	if(numero == 5) cinque.prenota();
                            	break;
                            case 10:
                            	uno.stampaInformazioni();
                            	System.out.println(" ");
                            	due.stampaInformazioni();
                            	System.out.println(" ");
                            	tre.stampaInformazioni();
                            	System.out.println(" ");
                            	quattro.stampaInformazioni();
                            	System.out.println(" ");
                            	cinque.stampaInformazioni();
                            	System.out.println(" ");
                            	
                            	int numero2;
                            	System.out.println("Che tavolo vuoi liberare?");
                            	numero2 = scanner.nextInt();
                            	if(numero2 > 5 || numero2 < 1) {
                            		System.out.println("Il tavolo non esiste.");
                            		break;
                            	}
                            	if(numero2 == 1) uno.libera();
                            	if(numero2 == 2) due.libera();
                            	if(numero2 == 3) tre.libera();
                            	if(numero2 == 4) quattro.libera();
                            	if(numero2 == 5) cinque.libera();
                            	break;
                            case 11:
                                System.out.println("Tornando al menu principale...");
                                System.out.println( );
                                break; 
                            default:
                                System.out.println("Scelta non valida. Riprova.");
                                System.out.println( );
                        }

                        if (scelta == 11) {
                            break; // Esci dal ciclo interno per tornare al menu principale
                        }
                    }
                } else {
                    System.out.println("Password errata. Riprova.");
                }
        
        } else if (tipoUtente.equalsIgnoreCase("c")) {
            // Modalit� Cliente
        	System.out.println( );
            System.out.println("Modalita' Cliente: Creazione di un ordine.");
            System.out.println();

            // Stampa del menu
            menu.stampaMenu();

            // Creazione di un cliente
            System.out.print("Nome del cliente: ");
            String nomeCliente = scanner.nextLine();
            Cliente cliente = new Cliente(nomeCliente);

            // Creazione di un ordine
            Ordine ordine = new Ordine(cliente);

            // Aggiunta di piatti all'ordine
            System.out.println("Inserisci i piatti dell'ordine:");
            boolean aggiungiAltroPiattoAllOrdine = true;
            while (aggiungiAltroPiattoAllOrdine) {
                System.out.print("Nome del piatto: ");
                String nomePiattoOrdine = scanner.nextLine();

                // Verifica che il piatto esista nel menu
                Piatto piattoOrdinato = null;
                for (Piatto piatto : menu.getPiatti()) {
                    if (piatto.getNome().equalsIgnoreCase(nomePiattoOrdine)) {
                        piattoOrdinato = piatto;
                        break;
                    }
                }

                if (piattoOrdinato != null) {
                    ordine.aggiungiPiatto(piattoOrdinato);
                    System.out.println("Piatto aggiunto all'ordine.");
                } else {
                    System.out.println("Piatto non trovato nel menu.");
                }

                System.out.print("Vuoi aggiungere un altro piatto all'ordine? (s/n): ");
                String risposta = scanner.nextLine();
                if (!risposta.equalsIgnoreCase("s")) {
                    aggiungiAltroPiattoAllOrdine = false;
                }
            }

            // Stampa dell'ordine
            ordine.stampaOrdine();
	    ordine.salvaOrdineSuFile("ordini.txt");

            // Chiedi all'utente se vuole lasciare una recensione

            System.out.print("Vuoi lasciare una recensione? (s/n): ");
            String lasciaRecensione = scanner.nextLine();
            if (lasciaRecensione.equalsIgnoreCase("s")) {
                Recensione nuovaRecensione = ristoranteCjoj.creaRecensione(); // Crea una nuova recensione
                ristoranteCjoj.aggiungiRecensione(nuovaRecensione); // Aggiunge la recensione alla lista nel ristorante
                System.out.println("Recensione aggiunta con successo!");
            } else if (!lasciaRecensione.equalsIgnoreCase("n")) {
                System.out.println("Scelta non valida. Riprova.");
            }

            // Saluto
            System.out.println( );
            System.out.println("Grazie per aver utilizzato il nostro servizio, arrivederci!");
            System.out.println( );
        } else if (tipoUtente.equalsIgnoreCase("r")) {
            // Visualizzazione delle recensioni
            System.out.println("Recensioni disponibili:");
            ristoranteCjoj.visualizzaRecensioni();
        } else {
            System.out.println("Scelta non valida. Riprova.");
            }
        } 
    }
	
}
