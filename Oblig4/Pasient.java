public class Pasient{

    protected String navn;
    protected String fodselsNr;
    protected int pasientId;
    protected int teller;

    protected IndeksertListe<Resepter> reseptListe = new IndeksertListe<>();


    public Pasient(String navn, String fodselsNr){
        this.navn = navn;
        this.fodselsNr = fodselsNr;

        teller +=1;
        pasientId = teller;
    }


    public void leggTil(Resepter resepter){

        reseptListe.leggTil(resepter);

        
    }



    
}
