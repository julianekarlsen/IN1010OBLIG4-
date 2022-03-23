class Hviteresepter extends Resept{


    public Hviteresepter(Legemiddel l, Lege uL, Pasient p, int r){
        super(l, uL, p, r);

    }
    
    public String farge(){
        return "hvit";
    }

    public int prisAaBetale(){
        return legemiddel.hentPris();
    }

    public String toString(){
        return legemiddel + " " + utskrivendeLege + " " + pasient + " " + reit + " " + farge() + " " + prisAaBetale(); 
    }


}
