
 public class Blaresepter extends Resepter {
 
    public Blaresepter(Legemiddler legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
        super(legemiddel, utskrivendeLege, pasient, reit);
        
    }
    @Override
    public String farge(){
        return "Blaa resept!";
         

    }    
    @Override
    public int prisAaBetale(){
        int prisen = legemiddel.hentPris();
        prisen = (int) (prisen - (prisen * 0.75));

        return prisen;
      
    }


 }
