 
 public class Narkotisk extends Legemiddler {
     int styrke;

     public Narkotisk(String navn, int pris, double virkestoff, int styrke){
         super(navn, pris, virkestoff);
         this.styrke = styrke;

     }

     int hentNarkotiskStyrke(){
        return styrke;
    }

    String tostring() {
        return super.toString() + " Type: Narkotisk NarkotiskStyrke: "+ styrke;

    }



 }