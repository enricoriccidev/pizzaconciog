public class Cameriere {
    private String nome ;
    private int eta;
    private int CF;
    private int esperienza;
    
    public Cameriere(String nome, int eta,int CF,int esperienza) {
        this.nome=nome;
    	this.eta=eta;  
    	this.CF=CF;
    	this.esperienza=esperienza;
    }

	public String getNome() {
        return nome;
    }

    public int getEsperienza() {
        return esperienza;
    }
    public int getCF() {
        return CF;
    }
    

    public int getEta() {
        return eta;
    }
    
    public String getInfoCameriere() {
        return "Nome: " + nome + ", Età: " + eta+" Esperienza: "+ esperienza+ ", CF: " + CF ;
    }
 

 
}