public class Recensione {
    private String autore;
    private String testo;

    public Recensione(String autore, String testo) {
        this.autore = autore;
        this.testo = testo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    @Override
    public String toString() {
        return "Recensione di " + autore + ": " + testo;
    }
}
