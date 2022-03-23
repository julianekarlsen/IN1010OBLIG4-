class Narkotisk extends Legemiddel {

    protected int narkotiskStyrke;

    //Konstruktør
    public Narkotisk(String n, int p, double mgV, int ns){
        super(n, p, mgV);
        narkotiskStyrke = ns;

    }

    public int hentNarkotiskStyrke(){
        return narkotiskStyrke;
    }

    public String toString(){
        return ID + " " + navn + " " + pris + " " + mgVirkestoff + " " + narkotiskStyrke; 
    }


}

