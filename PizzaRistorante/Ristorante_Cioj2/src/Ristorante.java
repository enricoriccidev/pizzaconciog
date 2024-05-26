import java.util.LinkedList;
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
        } else {
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
    }
public void addRecensione(String autore, String testo) {
		
		listarecensioni.add(new Recensione(autore,testo));
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
        System.out.print("Inserisci l'età del cuoco: ");
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
		System.out.println("====================================");
		System.out.println("Lista cuochi" );
		System.out.println("====================================");
		for (int i = 0; i < listacuochi.size(); i++)
		{
		
				System.out.println( "cuoco " + (i+1) + ": " + listacuochi.get(i).getInfoCuoco());
				System.out.println( );

			
		}
	}
   //////////////////////////////////////////////////////////
    public Cameriere creaCameriere() {
        System.out.print("Inserisci il nome del cameriere: ");
        String nome = scanner.nextLine();
        System.out.print("Inserisci l'età del cameriere: ");
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
		System.out.println("====================================");
		System.out.println("Lista camerieri" );
		System.out.println("====================================");
		for (int i = 0; i < listacamerieri.size(); i++)
		{
		
				System.out.println( "Cameriere " + (i+1) + ": " + listacamerieri.get(i).getInfoCameriere());
				System.out.println( );
			
		}
	}
/////////////////////////////////////////////////////////////////////////
}
