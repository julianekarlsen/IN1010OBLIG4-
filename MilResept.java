class MilResept extends Hviteresepter{

    public MilResept(Legemiddel l, Lege uL, Pasient p){
        super(l, uL, p, 3);
    }

    @Override
    public String farge() {
        return "hvit";
    }

    public int prisAaBetale(){
        return 0;
    }
    
    public String toString(){
        return legemiddel + " " + utskrivendeLege + " " + pasient + " " + 3 + " " + farge() + " " + prisAaBetale(); 
    }

}