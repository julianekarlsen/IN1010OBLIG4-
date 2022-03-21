import java.io.File;
import java.util.Scanner;

public class Legesystemer extends LenkeListe<Lege> {
    
    protected int linjeNr = 0;
    protected String linje;
    protected String dataType;

    protected IndeksertListe<Pasient> pasientListe = new IndeksertListe<Pasient>();
    protected IndeksertListe<Lege> legeListe = new IndeksertListe<Lege>();
    protected IndeksertListe<Legemiddler> legemiddelListe = new IndeksertListe<Legemiddler>();


    public void lesInnFil(String filnavn){
        try{
            Scanner nyFil = new Scanner(new File(filnavn));
            
                while(nyFil.hasNextLine()){
                    String lin = nyFil.nextLine();
                    linjeNr++;
                    String[] linje = lin.split(" ");
                                                                // while inni?? 
                    if(lin.contains("#")){
                        dataType = linje[1];

                    }

                    if (dataType.equals("Pasienter")){
                     String[] pasiantLinje = lin.split(",");
                                // System.out.println(pasiantLinje);
                     if (pasiantLinje.length == 2){

                            Pasient pasient = new Pasient(pasiantLinje[0],pasiantLinje[1]);
                            pasientListe.leggTil(pasient);

                        //navn = pasiantLinje[0];

                 //    int fnr = Integer.parseInt(pasiantLinje[1]);

                    }else{
                        System.out.println("Feil format..");
                        }
                    }

                    if(dataType.equals("Legemidler")){
                    String[] legemiddlerlinje = lin.split(",");

                    if (legemiddlerlinje.length == 5){

                        String navn = legemiddlerlinje[0];
                        String type = legemiddlerlinje[1];
                        int pris = Integer.parseInt(legemiddlerlinje[2]);
                        int virkestoff = Integer.parseInt(legemiddlerlinje[3]);
                        int styrke = Integer.parseInt(legemiddlerlinje[4]);


                        if (type.equals("narkotisk")){
                            Narkotisk narkotisk = new Narkotisk(navn, pris, virkestoff, styrke);

                            legemiddelListe.leggTil(narkotisk);

                        }
                        
                        if (type.equals("vanedannende")){

                            Vanedannende vanedannende = new Vanedannende(navn, pris, virkestoff, styrke);

                            legemiddelListe.leggTil(vanedannende);

                        }

                        if (type.equals("vanlig")){

                            Vanlig vanlig = new Vanlig(navn, pris, virkestoff);

                            legemiddelListe.leggTil(vanlig);

                        }
                        
                    }else{
                        System.out.println("Feil format...");
                        }

                    if(dataType.equals("Leger")){
                        String [] legelinje = lin.split(",");

                        if(legelinje.length == 2){
                            String navn = legelinje[0];
                            String kontrollId = legelinje[1];

                            if (kontrollId.equals("0")){
                                Lege lege = new Lege(navn);

                                legeListe.leggTil(lege);

                            }
                            Spesialister spesialist = new Spesialister(navn, kontrollId);

                            legeListe.leggTil(spesialist);
                        }
                        
                    }else{
                        System.out.println("Feil format...");
                        }

                    if(dataType.equals("Resepeter")){
                        String[] reseptLinje = lin.split(",");

                            int legemiddelNummer = Integer.parseInt(reseptLinje[0]);
                            String legenavn = reseptLinje[1];
                            int pasiendId = Integer.parseInt(reseptLinje[2]);
                            String type = reseptLinje[3];
                            int reit = Integer.parseInt(reseptLinje[4]);

                            Legemiddler lm = null;
                            Lege l = null;
                            Pasient p = null;

                        for(Legemiddler ilm : legemiddelListe){

                            if (ilm.hentId() == legemiddelNummer){
                               lm = ilm;
                            }

                        for(Lege il : legeListe){

                            if (il.hentNavn() == legenavn){
                                l = il;
                            }
                            
                        }
                        for(Pasient ip : pasientListe){

                            if (ip.hentId() == pasiendId){
                                p = ip;
                            }
                            
                        }
                       if(reseptLinje.length == 5){
                            if(type.equals("hvit")){

                                Hviteresepter hviteresepter = new Hviteresepter(lm, l, p, reit);

                                System.out.println(hviteresepter);


                    
                            }   if(type.equals("blaa")){

                                Blaresepter blaaresepter = new Blaresepter(lm, l, p, reit);

                                System.out.println(blaaresepter);


                            }      if(type.equals("p")){   

                                P_resepter p_resepter = new P_resepter(lm, l, p, reit);

                                System.out.println(p_resepter);


                            } 
                        }
                        if (reseptLinje.length == 4){

                            if (type.equals("militaer")){
                                
                                MilResept milResept = new MilResept(lm, l, p);

                                System.out.println(milResept);
                            }
                        } 
             }

            }
        
            }
          }
          nyFil.close();

        }catch (Exception e){
             System.out.println("Kan ikke lese " + filnavn + "!");
             System.out.println(e.getMessage());           // om man ikke finner filen


        }


    }
}








/// Streng.equals("#")              .contains("#")