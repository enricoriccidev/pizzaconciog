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
}
