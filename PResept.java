class PResept extends Hviteresepter{

    public PResept (Legemiddel l, Lege uL, Pasient p, int r){
        super(l, uL, p, r);
    }

    @Override
    public String farge(){
        return "hvit";
    }

    @Override
    public int prisAaBetale(){
        int rabattpris = legemiddel.hentPris() - 108;
        if (rabattpris < 0){
            return 0;
        } else {
            return rabattpris;
        }

    }

    public String toString(){
        return legemiddel + " " + utskrivendeLege + " " + pasient + " " + reit + " " + farge() + " " + prisAaBetale(); 
    }

}   