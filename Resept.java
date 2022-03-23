public abstract class Resept {

    protected Legemiddel legemiddel;
    protected Lege utskrivendeLege;
    protected Pasient pasient;
    protected int reit;
    protected int ID;
    protected static int counter;

    public Resept(Legemiddel l, Lege uL, Pasient p, int r) {
        legemiddel = l;
        utskrivendeLege = uL;
        pasient = p;
        reit = r;
        counter = counter +1;
        ID = counter;
    }

    public int hentId(){
        return ID;
    }

    public Legemiddel hentLegemiddel (){
        return legemiddel;
    }

    public Lege hentLege(){
        return utskrivendeLege;
    }

    public Pasient hentPasientId(){
        return pasient;
    }

    public int hentReit(){
        return reit;
    }

    public boolean bruk(){
        if (reit > 0){
            reit -= 1;
            return true;
        } else {
            return false;
        }
    }

    abstract public String farge();

    abstract public int prisAaBetale();

    public String toString(){
        return ID + " " + " " + legemiddel + " " + utskrivendeLege + " " + pasient + " " + reit + " " + farge() + " " + prisAaBetale(); 
    }


}
