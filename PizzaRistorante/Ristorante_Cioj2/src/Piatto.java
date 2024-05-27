import java.util.Scanner;

public class Piatto {
    private String nome;
    private double prezzo;

    public Piatto(String nome, double prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }
    

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public String toString() {
        return nome + ": €" + prezzo;
    }
}
