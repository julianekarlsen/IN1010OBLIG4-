public class Lege implements Comparable<Lege>{

    protected String navn;
    protected IndeksertListe<Resept> utskrevneResepter = new IndeksertListe<>();

    public Lege(String n) {
        this.navn = n;
    }

    public String henteUtNavn(){
        return navn;
    }

    public String toString(){
        return navn;
    }

    @Override
    public int compareTo(Lege lege){
        return navn.compareTo(lege.henteUtNavn());
    }

    public IndeksertListe<Resept> hentUtListe(){
        return utskrevneResepter;
    }

    public void sjekkNarkotisk(Lege l, Legemiddel lm) throws UlovligUtskrift{
        if(lm instanceof Narkotisk){
            throw new UlovligUtskrift(l, lm);
        }
    }

    Hviteresepter skrivHviteresepter (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
        
        Hviteresepter hvitresept = new Hviteresepter(legemiddel, this, pasient, reit);
        sjekkNarkotisk(this, legemiddel);
        utskrevneResepter.leggTil(hvitresept);
        pasient.leggTil(hvitresept);
        return hvitresept;

    }
    MilResept skrivMilResept(Legemiddel legemiddel, Pasient pasient)throws UlovligUtskrift{
        MilResept milresept = new MilResept(legemiddel, this, pasient);
        sjekkNarkotisk(this, legemiddel);
        utskrevneResepter.leggTil(milresept);
        pasient.leggTil(milresept);
        return milresept;

    }
    PResept skrivPResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
        PResept presept = new PResept(legemiddel, this, pasient, reit);
        sjekkNarkotisk(this, legemiddel);
        utskrevneResepter.leggTil(presept);
        pasient.leggTil(presept);
        return presept;

    }
    Blaaresepter skrivBlaaresepter(Legemiddel legemiddel, Pasient pasient, int reit)throws UlovligUtskrift{
        if(legemiddel instanceof Narkotisk && !(this instanceof Spesialist)){
            throw new UlovligUtskrift(this, legemiddel);
        } else{
            Blaaresepter blaaresepter = new Blaaresepter(legemiddel, this, pasient, reit);
            utskrevneResepter.leggTil(blaaresepter);
            pasient.leggTil(blaaresepter);
            return blaaresepter;
        }
    }
}
