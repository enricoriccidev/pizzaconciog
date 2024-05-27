import java.util.LinkedList;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Ristorante {
    private String nome;
    private Menu menu;
    private List<Cuoco> listacuochi;
    private List<Cameriere> listacamerieri;
    private List<Recensione> listarecensioni;

    public Ristorante(String nome) {
        this.nome = nome;
        this.menu = new Menu();
        this.listacuochi = new LinkedList<>();
        this.listacamerieri = new LinkedList<>();
        this.listarecensioni = new LinkedList<>();
    }
    Scanner scanner = new Scanner(System.in);

    // Metodi per gestire il menu
    public Menu getMenu() {
        return menu;
    }

 
    public List<Cuoco> getCuochi() {
        return listacuochi;
    }

    public List<Cameriere> getCamerieri() {
        return listacamerieri;
    }
    


    public List<Recensione> getRecensioni() {
        return listarecensioni;
    }
    /////////////////////////////ADMIN////////////////////
public void addCuoco(String nome,String specializzazione,int eta,int CF) {
		
		listacuochi.add(new Cuoco(nome,eta,CF, specializzazione));
	}
public void addCameriere(String nome,int esperienza,int eta,int CF) {
	
	listacamerieri.add(new Cameriere(nome,eta,CF, esperienza));
}

    /////////////////////////////////////////////////////////////

 
    public void rimuoviRecensione(String recensione) {
    	listarecensioni.remove(recensione);
    }

    public void visualizzaRecensioni() {
        if (listarecensioni.isEmpty()) {
            System.out.println("Nessuna recensione disponibile.");
        }else {
            System.out.println("Recensioni disponibili:");
            for (Recensione recensione : listarecensioni) {
                System.out.println();
                System.out.println(recensione);
                System.out.println();
            }
        }
    }
    public void eliminaRecensione(Recensione recensione) {
        boolean rimossa = listarecensioni.remove(recensione);
        if (rimossa) {
            System.out.println("Recensione eliminata con successo!");
        } else {
            System.out.println("Recensione non trovata.");
        }
    }
  

    public Recensione creaRecensione() {
        System.out.print("Inserisci l'autore della recensione: ");
        String autore = scanner.nextLine();
        System.out.print("Inserisci il testo della recensione: ");
        String testo = scanner.nextLine();
        return new Recensione(autore, testo);
    }

    public void aggiungiRecensione(Recensione recensione) {
        listarecensioni.add(recensione);
        salvaRecensioneSuFile(recensione, "recensioni.txt");
    }
public void addRecensione(String autore, String testo) {
		
		listarecensioni.add(new Recensione(autore,testo));
	}

private void salvaRecensioneSuFile(Recensione recensione, String filename) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/" + filename, true))) {
        writer.write(recensione.toString());
        writer.newLine();
        writer.newLine();
    } catch (IOException e) {
        System.err.println("Errore durante il salvataggio della recensione: " + e.getMessage());
    }
}


///////////////////////////////////////////////////////////////

    public void rimuoviCuoco(Cuoco cuoco) {
        listacuochi.remove(cuoco);
    }

    public void aggiungiCuoco(Cuoco cuoco) {
        listacuochi.add(cuoco);
    }

    public Cuoco creaCuoco() {
        System.out.print("Inserisci il nome del cuoco: ");
        String nome = scanner.nextLine();
        System.out.print("Inserisci l'et� del cuoco: ");
        int eta = scanner.nextInt();
        System.out.print("Inserisci il CF del cuoco: ");
        int CF = scanner.nextInt();
        scanner.nextLine(); // Consuma il newline dopo il nextInt()
        System.out.print("Inserisci la specializzazione del cuoco: ");
        String specializzazione = scanner.nextLine();

        return new Cuoco(nome, eta,CF, specializzazione);
    }

    public void aggiungiCuoco() {
        Cuoco cuoco = creaCuoco();
        aggiungiCuoco(cuoco);
        salvaCuochiSuFile("cuochi.txt");
    }

    public void eliminaCuoco() {
        System.out.print("Inserisci il nome del cuoco da eliminare: ");
        String nome = scanner.nextLine();
        System.out.print("Inserisci il CF del cuoco da eliminare: ");
        int CF = scanner.nextInt();
        Cuoco cuocoDaRimuovere = null;
        for (Cuoco cuoco : listacuochi) {
            if (cuoco.getNome().equalsIgnoreCase(nome) && cuoco.getCF()==CF ) {
                cuocoDaRimuovere = cuoco;
                break;
            }
        }
        if (cuocoDaRimuovere != null) {
            rimuoviCuoco(cuocoDaRimuovere);
            System.out.println("Cuoco eliminato con successo!");
        } else {
            System.out.println("Cuoco non trovato.");
        }
    }
    
	public void stampaCuochi()
	{
		caricaCuochiDaFile("cuochi.txt");
		System.out.println("====================================");
		System.out.println("Lista cuochi" );
		System.out.println("====================================");
		for (int i = 0; i < listacuochi.size(); i++)
		{
		
				System.out.println( "cuoco " + (i+1) + ": " + listacuochi.get(i).getInfoCuoco());
				System.out.println( );

			
		}
	}
	
	 public void salvaCuochiSuFile(String filename) {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/" + filename))) {
	            for (Cuoco cuoco : listacuochi) {
	                writer.write(cuoco.getNome() + ";" + cuoco.getEta() + ";" + cuoco.getCF() + ";" + cuoco.getSpecializzazione());
	                writer.newLine();
	            }
	            System.out.println("Dati dei cuochi salvati correttamente su file.");
	        } catch (IOException e) {
	            System.err.println("Errore durante il salvataggio dei dati dei cuochi: " + e.getMessage());
	        }
	    }
	 
	    public void caricaCuochiDaFile(String filename) {
	        listacuochi.clear();  // Pulisce la lista prima di caricare i nuovi cuochi
	        try (BufferedReader reader = new BufferedReader(new FileReader("src/" + filename))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(";");
	                if (parts.length == 4) {
	                    String nome = parts[0].trim();
	                    int eta = Integer.parseInt(parts[1].trim());
	                    int CF = Integer.parseInt(parts[2].trim());
	                    String specializzazione = parts[3].trim();
	                    Cuoco cuoco = new Cuoco(nome, eta, CF, specializzazione);
	                    listacuochi.add(cuoco);
	                }
	            }
	        } catch (IOException | NumberFormatException e) {
	            System.err.println("Errore durante il caricamento dei cuochi da file: " + e.getMessage());
	        }
	    }
   //////////////////////////////////////////////////////////
    public Cameriere creaCameriere() {
        System.out.print("Inserisci il nome del cameriere: ");
        String nome = scanner.nextLine();
        System.out.print("Inserisci l'et� del cameriere: ");
        int eta = scanner.nextInt();
        System.out.print("Inserisci il CF del cameriere: ");
        int CF = scanner.nextInt();
        scanner.nextLine(); // Consuma il newline dopo il nextInt()
        System.out.print("Inserisci l'esperienza del cameriere: ");
        int esperienza = scanner.nextInt();

        return new Cameriere(nome, eta,CF,esperienza);
    }
    public void rimuoviCameriere(Cameriere cameriere) {
        listacamerieri.remove(cameriere);
    }
    public void aggiungiCameriere(Cameriere cameriere) {
        listacamerieri.add(cameriere);
    }
    public void aggiungiCameriere() {
        Cameriere cameriere = creaCameriere();
        aggiungiCameriere(cameriere);
        salvaCamerieriSuFile("camerieri.txt");
    }

    public void eliminaCameriere() {
        System.out.print("Inserisci il nome del cameriere da eliminare: ");
        String nome = scanner.nextLine();
        System.out.print("Inserisci il CF del cuoco da eliminare: ");
        int CF = scanner.nextInt();
        Cameriere cameriereDaRimuovere = null;
        for (Cameriere cameriere : listacamerieri) {
            if (cameriere.getNome().equalsIgnoreCase(nome) && cameriere.getCF()==CF) {
                cameriereDaRimuovere = cameriere;
                break;
            }
        }
        if (cameriereDaRimuovere != null) {
            rimuoviCameriere(cameriereDaRimuovere);
            System.out.println("Cameriere eliminato con successo!");
        } else {
            System.out.println("Cameriere non trovato.");
        }
    }
	public void stampaCamerieri()
	{
		caricaCamerieriDaFile("camerieri.txt");
		System.out.println("====================================");
		System.out.println("Lista camerieri" );
		System.out.println("====================================");
		for (int i = 0; i < listacamerieri.size(); i++)
		{
		
				System.out.println( "Cameriere " + (i+1) + ": " + listacamerieri.get(i).getInfoCameriere());
				System.out.println( );
			
		}
	}
	
	 public void salvaCamerieriSuFile(String filename) {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/" + filename))) {
	            for (Cameriere cameriere : listacamerieri) {
	                writer.write(cameriere.getNome() + ";" + cameriere.getEta() + ";" + cameriere.getCF() + ";" + cameriere.getEsperienza());
	                writer.newLine();
	            }
	            System.out.println("Dati dei camerieri salvati correttamente su file.");
	        } catch (IOException e) {
	            System.err.println("Errore durante il salvataggio dei dati dei camerieri: " + e.getMessage());
	        }
	    }
	 
	  public void caricaCamerieriDaFile(String filename) {
	        listacamerieri.clear();  // Pulisce la lista prima di caricare i nuovi camerieri
	        try (BufferedReader reader = new BufferedReader(new FileReader("src/" + filename))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(";");
	                if (parts.length == 4) {
	                    String nome = parts[0].trim();
	                    int eta = Integer.parseInt(parts[1].trim());
	                    int CF = Integer.parseInt(parts[2].trim());
	                    int esperienza = Integer.parseInt(parts[3].trim());
	                    Cameriere cameriere = new Cameriere(nome, eta, CF, esperienza);
	                    listacamerieri.add(cameriere);
	                }
	            }
	        } catch (IOException | NumberFormatException e) {
	            System.err.println("Errore durante il caricamento dei camerieri da file: " + e.getMessage());
	        }
	    }
/////////////////////////////////////////////////////////////////////////
}
