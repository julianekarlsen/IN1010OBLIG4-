import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Legesystem extends LenkeListe<Lege> {

    protected int linjenr = 0;
    protected String linje;
    protected String dataType;
    protected IndeksertListe<Pasient> pasientListe = new IndeksertListe<Pasient>();
    protected IndeksertListe<Lege> legeListe = new IndeksertListe<Lege>();
    protected IndeksertListe<Legemiddler> legemiddelListe = new IndeksertListe<Legemiddler>();

    public void lesInnFil(String filnavn){
        try {
            Scanner nyFil = new Scanner(new File(filnavn));

            while(nyFil.hasNextLine()){
                String lin = nyFil.nextLine();
                linjenr++;
                String[] linje = lin.split(" ");
                if (lin.contains("#")){
                    dataType = linje[1];
                }else{
                if(dataType.equals("Pasienter")){
                    String[] pasientLinje = lin.split(","); 
                    if(pasientLinje.length == 2){
                        Pasient pasient = new Pasient(pasientLinje[0], pasientLinje[1]);
                        pasientListe.leggTil(pasient);
                    } else{
                        System.out.println("Formatet er feil 1 :(");
                    }
                    // String navn = pasientLinje[0];
                    // int fnr = Integer.parseInt(pasientLinje[1]);
                }
                if(dataType.equals("Legemidler")){
                    String [] legemiddelLinje = lin.split(",");
                    if (legemiddelLinje.length == 5){
                        System.out.println(legemiddelLinje);
                        String navn = legemiddelLinje[0];
                        String type = legemiddelLinje[1];
                        int pris = Integer.parseInt(legemiddelLinje[2]);
                        int virkestoff = Integer.parseInt(legemiddelLinje[3]);
                        int styrke = Integer.parseInt(legemiddelLinje[4]);

                        if(type.equals("narkotisk")){
                            Narkotisk narkotisk = new Narkotisk(navn, pris, virkestoff, styrke);
                            legemiddelListe.leggTil(narkotisk);
                        }
                        if(type.equals("vanedannende")){
                            Vanedannende vanedannende = new Vanedannende(navn, pris, virkestoff, styrke);
                            legemiddelListe.leggTil(vanedannende);
                        }
                        if(type.equals("vanlig")){
                            Vanlig vanlig = new Vanlig(navn, pris, styrke);
                            legemiddelListe.leggTil(vanlig);
                        }
                    } else{
                        System.out.println("Formatet er feil 2 :(");
                    }
                }
                
                if(dataType.equals("Leger")){
                    String[] legeLinje = lin.split(",");

                    if(legeLinje.length == 2){
                        String navn = legeLinje[0];
                        String kontrollId = legeLinje[1];

                        if(kontrollId.equals("0")){
                            Lege lege = new Lege(navn);
                            legeListe.leggTil(lege);
                        }
                        Spesialister spesialist = new Spesialister(navn, kontrollId);
                        legeListe.leggTil(spesialist);
                    }

                }else{
                    System.out.println("Formatet er feil 3:(");
                }

                if(dataType.equals("Resepter")){
                    String[] reseptLinje = lin.split(",");
                    int legemiddelNummer = Integer.parseInt(reseptLinje[0]);
                    String legeNavn = reseptLinje[1];
                    int pasientID = Integer.parseInt(reseptLinje[2]);
                    String type = reseptLinje[3];
                    int reit = Integer.parseInt(reseptLinje[4]);

                    Legemiddler lm = null;
                    Lege l = null;
                    Pasient pid = null;


                    for (Legemiddler ilm : legemiddelListe){
                        if(ilm.hentId() == legemiddelNummer){
                            lm = ilm;
                        }
                    }
                    for (Lege il : legeListe){
                        if(il.hentNavn() == legeNavn){
                            l = il;
                        }
                    }
                    for (Pasient ip : pasientListe){
                        if(ip.hentId() == pasientID){
                            pid = ip;
                        }
                    }
                    
                    if(reseptLinje.length == 5){
                        if(type.equals("hvit")){
                            Hviteresepter hvitresept = new Hviteresepter(lm, l, pid, reit);
                        }
                        if(type.equals("blaa")){
                            Blaresepter blaaresept = new Blaresepter(lm, l, pid, reit);
                        }
                        if(type.equals("p")){
                            P_resepter presept = new P_resepter(lm, l, pid, reit);
                        }
                    }
                    if(reseptLinje.length ==4){
                        if(type.equals("militaer")){
                            MilResept milresept = new MilResept(lm, l, pid);
                        }
            
                    }
                    //trim før split fordi det ikke er et tall bakerst
                }
            }
        nyFil.close();
        } 
        catch (FileNotFoundException e){
            System.out.println("Finner ikke " + filnavn + " oppretter et tomt Legesystem");
            return;
        }
    }
}
//Legg inn -metode
