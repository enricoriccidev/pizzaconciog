import java.util.ArrayList;

public class Ordine {
    private Cliente cliente;
    private ArrayList<Piatto> piattiOrdinati;

    public Ordine(Cliente cliente) {
        this.cliente = cliente;
        this.piattiOrdinati = new ArrayList<>();
    }

    public void aggiungiPiatto(Piatto piatto) {
        piattiOrdinati.add(piatto);
    }

    public double calcolaTotale() {
        double totale = 0;
        for (Piatto piatto : piattiOrdinati) {
            totale += piatto.getPrezzo();
        }
        return totale;
    }

    public void stampaOrdine() {
        System.out.println("Ordine di " + cliente.getNome() + ":");
        for (Piatto piatto : piattiOrdinati) {
            System.out.println(piatto);
        }
        System.out.println("Totale: €" + calcolaTotale());
    }

     public void salvaOrdineSuFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/" + filename, true))) {
            writer.write("Ordine di " + cliente.getNome() + ":");
            writer.newLine();
            for (Piatto piatto : piattiOrdinati) {
                writer.write(piatto.toString());
                writer.newLine();
            }
            writer.write("Totale: €" + calcolaTotale());
            writer.newLine();
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio dell'ordine: " + e.getMessage());
        }
    }
}
