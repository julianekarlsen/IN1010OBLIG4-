
class Spesialister extends Lege implements Godkjenningsfritak{
    String kontrollId;

    public Spesialister(String navn, String kontrollId){
        super(navn);
        this.kontrollId = kontrollId;
    }

    @Override
    public String hentKontrollId(){
        return kontrollId;
    }

}
