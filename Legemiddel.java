public abstract class Legemiddel{

    protected String navn;
    protected int ID;
    protected static int counter;
    protected int pris;
    protected double mgVirkestoff;


    //Konstuktør
    public Legemiddel(String n, int p, double mgV) {
        navn = n;
        pris = p;
        mgVirkestoff = mgV;
        counter = counter +1;
        ID = counter;
    }

    //Metode
    public int hentID(){
        return ID;

    }

    public String hentNavn(){
        return navn;
    }

    public int hentPris(){
        return pris;
    }

    public double hentVirkestoff(){
        return mgVirkestoff;
    }

    public void settNyPris(int nyPris){
        pris = nyPris;
        
    }

    public String toString(){
        return ID + " " + navn + " " + pris + " " + mgVirkestoff + " "; 
    }
}
