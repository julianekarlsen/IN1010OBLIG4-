
public class Lege implements Comparable<Lege>  {
    protected String navn;
    protected IndeksertListe<Resepter> utSkrevedeResepter = new IndeksertListe<>();


    public Lege(String navn){
        this.navn = navn;
    }

    public String hentNavn(){
        return navn;
    }

    public String toString(){
        return "Doktor " + navn;
    }

    @Override
    public int compareTo(Lege lege){
        return navn.compareTo(lege.hentNavn());
    }

    public IndeksertListe<Resepter> hentUtUtskrevendeListe(){
        return utSkrevedeResepter;
    } 



    public Hviteresepter skrivHviteresepter (Legemiddler legemiddler, Pasient pasient, int reit) {

        Hviteresepter hvitresept = new Hviteresepter(legemiddler, this, pasient, reit);

        utSkrevedeResepter.leggTil(hvitresept);
        pasient.leggTil(hvitresept);

        return hvitresept;

    }
    public MilResept skrivMilresepter (Legemiddler legemiddler, Pasient pasient, int reit){

        MilResept milResept = new MilResept(legemiddler, this, pasient);

        utSkrevedeResepter.leggTil(milResept);
        pasient.leggTil(milResept);

        return milResept;

        }



        
    public void Gyldutskift(Lege l, Legemiddler lm){

        if (l instanceof Spesialister && lm instanceof Narkotisk){



    }


    }
    public P_resepter skrivPresepter (Legemiddler legemiddler, Pasient pasient, int reit) {

        P_resepter pResept = new P_resepter(legemiddler, this, pasient, reit);

        utSkrevedeResepter.leggTil(pResept);
        pasient.leggTil(pResept);
        
        return pResept;
        
    }

    public Blaresepter skrivBlaaresepter (Legemiddler legemiddler, Pasient pasient, int reit) {

        // if (Lege instanceof Spesialister && legemiddler instanceof Narkotisk){


        Blaresepter blaresepter = new Blaresepter(legemiddler, this, pasient, reit);

        utSkrevedeResepter.leggTil(blaresepter);
        pasient.leggTil(blaresepter);
        
        return blaresepter;

        }
        
        
    }
    

    


    


}


