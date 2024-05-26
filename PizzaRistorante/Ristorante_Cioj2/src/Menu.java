import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Menu {
    private ArrayList<Piatto> piatti;

    public Menu() {
        this.piatti = new ArrayList<>();
        caricaMenuDaFile("menu.txt");
    }

   
    private void caricaMenuPredefinito() {
    	piatti.add(new Piatto("Spaghetti alla Carbonara", 12.00));
        piatti.add(new Piatto("Lasagna", 15.00));
        piatti.add(new Piatto("Pizza Margherita", 8.00));
        piatti.add(new Piatto("Insalata Mista", 6.00));
        piatti.add(new Piatto("Tiramisu'", 7.00));
    }

    public void aggiungiPiatto(String nome, double prezzo) {
    	Piatto piatto = new Piatto(nome, prezzo);
    	piatti.add(piatto);
    	salvaMenuSuFile("menu.txt");
    }

    public ArrayList<Piatto> getPiatti() {
        return piatti;
    }
    	

    public void stampaMenu() {
        System.out.println("===========================================");

        System.out.println("Menu del Ristorante:");
        System.out.println();

        for (Piatto piatto : piatti) {
            System.out.println(piatto);
        }
        System.out.println("===========================================");

    }

	public void rimuoviPiatto(int id) {
		piatti.remove(id);
		salvaMenuSuFile("menu.txt");
	}
	
	public int getMenuSize(ArrayList<Piatto> piatti) {
		
		return piatti.size();
	}
	
	public String nuovoNome(String nome) {
		Scanner nuovoNome = new Scanner(System.in);
		
		nome = nuovoNome.nextLine();
		
		nuovoNome.close();
		return nome;
	}
	
	public double nuovoPrezzo(double prezzo) {
		Scanner nuovoPrezzo = new Scanner(System.in);
		
		prezzo = nuovoPrezzo.nextDouble();
		
		nuovoPrezzo.close();
		return prezzo;
	}
	
	public void caricaMenuDaFile(String filename) {
		try (BufferedReader reader = new BufferedReader(new FileReader("src/" + filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String nome = parts[0].trim();
                    double prezzo = Double.parseDouble(parts[1].trim());
                    piatti.add(new Piatto(nome, prezzo));
                }
            }
        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file: " + e.getMessage());
            caricaMenuPredefinito(); // Carica un menu predefinito se il file non viene trovato o c'è un errore
        }
	}
	
	private void salvaMenuSuFile(String fileName) {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/" + fileName))) {
	        for (Piatto piatto : piatti) {
	            writer.write(piatto.getNome() + "," + piatto.getPrezzo());
	            writer.newLine();
	        }
	    } catch (IOException e) {
	        System.err.println("Errore durante la scrittura del file: " + e.getMessage());
	    }
	}
	
}
