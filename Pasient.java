public class Pasient{

    protected String navn;
    protected String fodselsnummer;
    protected int PasientId;
    protected static int teller;
    protected IndeksertListe<Resept> reseptListe = new IndeksertListe<>();

    public Pasient(String n, String fn){
        this.navn = n;
        this.fodselsnummer = fn;
        teller ++;
        PasientId = teller;
    }

    public int hentPasientId(){
        return PasientId;
    }

    public void leggTil(Resept resept){
        reseptListe.leggTil(resept);
    }

    public void reseptListe(){
        System.out.println(reseptListe);

    }

    public String toString(){
        return navn;
    }


}

