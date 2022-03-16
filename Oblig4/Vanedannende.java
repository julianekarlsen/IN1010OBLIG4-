 
 public class Vanedannende extends Legemiddler {
     int styrke;

     public Vanedannende(String navn, int pris, double virkestoff, int styrke){
         super(navn, pris, virkestoff);
         this.styrke = styrke;

     }

     public int hentVanedannendeStyrke(){
         return styrke;
     }

     String tostring() {
        return super.toString() + " Type: Vanedannende Vanedannendestyrke: "+ styrke;



 }
}