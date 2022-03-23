class Blaaresepter extends Resept{

    public Blaaresepter(Legemiddel l, Lege uL, Pasient p, int r){
        super(l, uL, p, r);

    }
    
    public String farge(){
        return "blaa";
    }

    public int prisAaBetale(){
        return Math.round(legemiddel.hentPris() * 0.25f);
    }

    public String toString(){
        return legemiddel + " " + utskrivendeLege + " " + pasient + " " + reit + " " + farge() + " " + prisAaBetale(); 
    }
}