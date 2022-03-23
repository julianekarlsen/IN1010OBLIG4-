
class Spesialist extends Lege implements Godkjenningsfritak{

    String kontrollID;

    public Spesialist(String navn, String kID){
        super(navn);
        kontrollID = kID;
    }

    public String hentKontrollID(){
        return kontrollID;
    }

    public String toString(){
        return navn + " " + kontrollID;
    }
}
