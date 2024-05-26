public class Tavolo {
    // Attributi
    private int id;
    private double lunghezza;
    private double larghezza;
    private double altezza;
    private String materiale;
    private int posti;
    private boolean occupato;

    // Costruttore
    public Tavolo(int id, double lunghezza, double larghezza, double altezza, String materiale, int posti) {
        this.id = id;
        this.lunghezza = lunghezza;
        this.larghezza = larghezza;
        this.altezza = altezza;
        this.materiale = materiale;
        this.posti = posti;
        this.occupato = false;
    }
    
    public Tavolo(int id, int posti) {
    	this.id = id;
    	this.posti = posti;
    }

    // Metodi getter
    public int getId() {
        return id;
    }

    public double getLunghezza() {
        return lunghezza;
    }

    public double getLarghezza() {
        return larghezza;
    }

    public double getAltezza() {
        return altezza;
    }

    public String getMateriale() {
        return materiale;
    }

    public int getPosti() {
        return posti;
    }

    public boolean isOccupato() {
        return occupato;
    }

    // Metodi setter
    public void setLunghezza(double lunghezza) {
        this.lunghezza = lunghezza;
    }

    public void setLarghezza(double larghezza) {
        this.larghezza = larghezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    public void setMateriale(String materiale) {
        this.materiale = materiale;
    }

    public void setPosti(int posti) {
        this.posti = posti;
    }

    public void setOccupato(boolean occupato) {
        this.occupato = occupato;
    }

    // Metodo per calcolare l'area del piano del tavolo
    public double calcolaArea() {
        return lunghezza * larghezza;
    }

    // Metodo per stampare le informazioni del tavolo
    public void stampaInformazioni() {
        System.out.println("Tavolo ID: " + id);
        System.out.println("Materiale: " + materiale);
        System.out.println("Dimensioni: " + lunghezza + " x " + larghezza + " x " + altezza);
        System.out.println("Area del piano: " + calcolaArea());
        System.out.println("Posti a sedere: " + posti);
        System.out.println("Occupato: " + (occupato ? "Sì" : "No"));
    }

    // Metodo per prenotare il tavolo
    public boolean prenota() {
        if (!occupato) {
            occupato = true;
            System.out.println("Il tavolo " + id + " è stato prenotato.");
            return true;
        } else {
            System.out.println("Il tavolo " + id + " è già occupato.");
            return false;
        }
    }

    // Metodo per liberare il tavolo
    public void libera() {
        if (occupato) {
            occupato = false;
            System.out.println("Il tavolo " + id + " è stato liberato.");
        } else {
            System.out.println("Il tavolo " + id + " è già libero.");
        }
    }
}