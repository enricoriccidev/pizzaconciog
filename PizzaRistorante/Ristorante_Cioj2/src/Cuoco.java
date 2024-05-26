public class Cuoco  {
    private String specializzazione;
    private int eta;
    private int CF;
    private String nome;
    public Cuoco(String nome, int eta,int CF, String specializzazione) {
        this.nome = nome;
        this.eta = eta;
        this.CF=CF;
        this.specializzazione = specializzazione;
    }

    public String getSpecializzazione() {
        return specializzazione;
    }

    public void setSpecializzazione(String specializzazione) {
        this.specializzazione = specializzazione;
    }

    // Metodi set e get per nome ed eta
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }
    public void setCF(int CF) {
        this.CF= CF;
    }
    public int getCF() {
        return CF;
    }
    public String getInfoCuoco() {
        return "Nome: " + nome + ", Età: " + eta + ", Specializzazione: " + specializzazione+ ", CF: " + CF;
    }
}