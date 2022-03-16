
public abstract class Legemiddler{
    protected String navn; 
    protected int id;
    static int teller;
    protected int pris; 
    protected double virkestoff;

    public Legemiddler(String navn, int pris, Double virkestoff){
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;

        teller +=1;
        id = teller;
    }

    String hentNavn(){
        return navn;
    }

    int hentId(){
        return id;
    }

    int hentPris(){
        return pris;
    }

    double hentVirkestoff(){
        return virkestoff;
    }

    void settNyPris(int nyPris){
        pris = nyPris;
    }

    public String toString() {
        return "Navn: " + navn + " ID: " + id + " Pris: " + pris + " Virkestoff: " + virkestoff;

    }




}