
 public class Hviteresepter extends Resepter {
    
    public Hviteresepter(Legemiddler legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
        super( legemiddel, utskrivendeLege, pasient, reit);

    }
    @Override
    public String farge(){
        return "Hvit resept!";
        

    }   
    @Override 
    public int prisAaBetale(){
        return legemiddel.hentPris();
    }


 }