
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

    public void sjekkNarkotisk(Lege l, Legemiddler lm)throws UlovligUtskrift{

        if (lm instanceof Narkotisk){
            throw new UlovligUtskrift(l, lm);

        }

    }



    public Hviteresepter skrivHviteresepter (Legemiddler legemiddler, Pasient pasient, int reit)throws UlovligUtskrift {

        Hviteresepter hvitresept = new Hviteresepter(legemiddler, this, pasient, reit);

        sjekkNarkotisk(this, legemiddler);

        utSkrevedeResepter.leggTil(hvitresept);
        pasient.leggTil(hvitresept);

        return hvitresept;

    }
    public MilResept skrivMilresepter (Legemiddler legemiddler, Pasient pasient, int reit)throws UlovligUtskrift{

        MilResept milResept = new MilResept(legemiddler, this, pasient);
        sjekkNarkotisk(this, legemiddler);

        utSkrevedeResepter.leggTil(milResept);
        pasient.leggTil(milResept);

        return milResept;

        }
    
    public P_resepter skrivPresepter (Legemiddler legemiddler, Pasient pasient, int reit)throws UlovligUtskrift {

       P_resepter pResept = new P_resepter(legemiddler, this, pasient, reit);
       sjekkNarkotisk(this, legemiddler);

    
        utSkrevedeResepter.leggTil(pResept);
        pasient.leggTil(pResept);
            
        return pResept;
            
        }

        public Blaresepter skrivBlaaresepter (Legemiddler legemiddler, Pasient pasient, int reit)throws UlovligUtskrift {

            if (legemiddler instanceof Narkotisk && !(this instanceof  Spesialister)){
                throw new UlovligUtskrift(this, legemiddler);

            }  
    
            else{

            Blaresepter blaresepter = new Blaresepter(legemiddler, this, pasient, reit);
        
                utSkrevedeResepter.leggTil(blaresepter);
                pasient.leggTil(blaresepter);
                
                return blaresepter;

            }
    }
  
    
 
}


