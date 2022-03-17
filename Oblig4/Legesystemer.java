import java.io.File;
import java.util.Scanner;

public class Legesystemer extends LenkeListe<Lege> {
    
    protected int linjeNr = 0;
    protected String linje;
    protected String dataType;

    private IndeksertListe<Pasient> pasientListe = new IndeksertListe<Pasient>();
    private IndeksertListe<Lege> legeListe = new IndeksertListe<Lege>();
    private IndeksertListe<Legemiddler> legemiddelListe = new IndeksertListe<Legemiddler>();


    public void lesInnFil(String filnavn){


        try{
            Scanner nyFil = new Scanner(new File(filnavn));

                while(nyFil.hasNextLine()){
                    String lin = nyFil.nextLine();
                    linjeNr++;
                    String[] linje = lin.split(" ");

                    if(lin.contains("#")){
                        dataType;
                        dataType = linje[1];
    
                        }
            
                }
                



        //       String lin = nyFil.nextLine();.
        //       System.out.println(lin);
        //       String[] linje = lin.split(" ");
      
        //       int antallNoder = Integer.parseInt(linje[0]);
        //       int antProsessorer = Integer.parseInt(linje[1]);
        //       int minnePrN = Integer.parseInt(linje[2]);
      
        //       for (int i = 0; i < antallNoder; i++){
        //         settInnNode(new Node(minnePrN, antProsessorer));
        //       }
        nyFil.close();

      
          }catch (Exception e){
             System.out.println("Kan ikke lese " + filnavn + "!");
             System.out.println(e.getMessage());           // om man ikke finner filen
           }






    
 }
}







/// Streng.equals("#")              .contains("#")