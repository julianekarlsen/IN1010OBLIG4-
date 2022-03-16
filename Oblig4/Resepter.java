
public abstract class Resepter {
    protected int reseptId;
    protected Legemiddler legemiddel;
    protected Lege utskrivendeLege;
    protected Pasient pasient;
    protected int reit;
    protected boolean reseptGyldig;
    static int teller;



    public Resepter(Legemiddler legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
        this.legemiddel = legemiddel;
        this.utskrivendeLege =  utskrivendeLege;
        this.pasient = pasient;
        this.reit = reit;
        

        reseptId = teller;
        teller +=1;


    }

    int hentId(){
        return reseptId;

    }
    Legemiddler hentLegemiddel (){
        return legemiddel;

    }
    Lege hentLege (){
        return utskrivendeLege;

    }

    Pasient hentPasientId(){
        return pasient;

    }
    int hentReit(){
        return reit;

    }

    public boolean bruk(){
        
        if (reit == 0){
            reseptGyldig = false;
            System.out.println("Resepten ikke er gyldig!");

        }else{
            reseptGyldig = true;
            System.out.println("Resepten er gyldig!");
        }

        return reseptGyldig;

    }
    abstract public String farge();
    
    abstract public int prisAaBetale();

    public String toString() {
        return "Resept ID: " + reseptId + " \n  Legemiddel: " + legemiddel + " \n  Utskrevet av: " + utskrivendeLege + "H\n  PasientId: " + pasient + ". Reit: " + reit ;
    }

}