import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Iterator;


public class Legesystem extends Lenkeliste<Lege> {

    protected int linjenr = 0;
    protected String linje;
    protected String dataType;
    protected IndeksertListe<Pasient> pasientListe = new IndeksertListe<Pasient>();
    protected Prioritetskoe<Lege> legeListe = new Prioritetskoe<Lege>();
    protected IndeksertListe<Legemiddel> legemiddelListe = new IndeksertListe<Legemiddel>();

    public void lesInnFil(String filnavn){
        try {
            Scanner nyFil = new Scanner(new File(filnavn));

            while(nyFil.hasNextLine()){
                String lin = nyFil.nextLine();
                linjenr++;
                String[] linje = lin.split(" ");
                if (lin.contains("#")){
                    dataType = linje[1];
                } else{
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

                        if (legemiddelLinje.length == 5 || legemiddelLinje.length == 4){
                            String navn = legemiddelLinje[0];
                            String type = legemiddelLinje[1];
                            int pris = Integer.parseInt(legemiddelLinje[2]);
                            int virkestoff = Integer.parseInt(legemiddelLinje[3]);


                            if(type.equals("narkotisk")){
                                int styrke = Integer.parseInt(legemiddelLinje[4]);
                                Narkotisk narkotisk = new Narkotisk(navn, pris, virkestoff, styrke);
                                legemiddelListe.leggTil(narkotisk);
                            }
                            if(type.equals("vanedannende")){
                                int styrke = Integer.parseInt(legemiddelLinje[4]);
                                Vanedannende vanedannende = new Vanedannende(navn, pris, virkestoff, styrke);
                                legemiddelListe.leggTil(vanedannende);
                            }
                            if(type.equals("vanlig")){
                                Vanlig vanlig = new Vanlig(navn, pris, virkestoff);
                                legemiddelListe.leggTil(vanlig);
                            }
                        } else{
                            System.out.println("Formatet er feil 2 :(");
                        }
                    }
                    
                    if(dataType.equals("Leger")){
                        String[] legeLinje = lin.trim().split(",");

                        if(legeLinje.length == 2){
                            String navn = legeLinje[0];
                            String kontrollId = legeLinje[1];
                            // System.out.println(navn + " - KontrollID: " + kontrollId);
                            if(kontrollId.equals("0")){
                                Lege lege = new Lege(navn);
                                legeListe.leggTil(lege);
                            } else {
                                Spesialist spesialist = new Spesialist(navn, kontrollId);
                                legeListe.leggTil(spesialist);
                            }

                        } else{
                        System.out.println("Formatet er feil 3:(");
                        }
                    }   

                    if(dataType.equals("Resepter")){
                        String[] reseptLinje = lin.split(",");
                        int legemiddelNummer = Integer.parseInt(reseptLinje[0]);
                        String legeNavn = reseptLinje[1];
                        int pasientID = Integer.parseInt(reseptLinje[2]);
                        String type = reseptLinje[3];

                        Legemiddel lm = null;
                        Lege l = null;
                        Pasient pid = null;


                        for (Legemiddel ilm : legemiddelListe){
                            if(ilm.hentID() == legemiddelNummer){
                                lm = ilm;
                            }
                        }
                        for (Lege il : legeListe){
                            if(il.henteUtNavn().equals(legeNavn)){
                                l = il;
                            }
                        }
                        for (Pasient ip : pasientListe){
                            if(ip.hentPasientId() == pasientID){
                                pid = ip;
                            }
                        }
                        try{
                            if(reseptLinje.length == 5){
                                if(type.equals("hvit")){
                                    int reit = Integer.parseInt(reseptLinje[4]);
                                    l.skrivHviteresepter(lm, pid, reit);
                                }
                                if(type.equals("blaa")){
                                    int reit = Integer.parseInt(reseptLinje[4]);
                                    l.skrivBlaaresepter(lm, pid, reit);
                                }
                                if(type.equals("p")){
                                    int reit = Integer.parseInt(reseptLinje[4]);
                                    l.skrivPResept(lm, pid, reit);
                                }
                            }
                        
                            if(reseptLinje.length ==4){
                                if(type.equals("militaer")){
                                    l.skrivMilResept(lm, pid);
                                }
                            }
                        } catch (UlovligUtskrift e) {
                            System.out.println("Ulovlig resept ble ikke skrevet ut ");
                        }
                    }
                }
            }
        nyFil.close();
        } 
        catch (FileNotFoundException e){
            System.out.println("Finner ikke " + filnavn + " oppretter et tomt Legesystem");
            return;
        }
    }


    public void kommandoLokke(){

            Scanner kommando = new Scanner(System.in);
            System.out.println("Hei! Velg 1 for Skrive ut en fullstendig oversikt over pasienter, leger, legemidler og resepter. ");
            System.out.println("2 for aa opprette og legge til nye elementer i systemet.");
            System.out.println("3 for aa bruke en gitt resept fra listen til en pasient.");
            System.out.println("4 for aa skrive ut forskjellige former for statistikk.");
            System.out.println("5 for aa skrive alle data til fil eller 6 for avslutt");
        

            String valgtKommando = kommando.nextLine();  
            System.out.println("Du valgte " + valgtKommando);

            if (valgtKommando.equals("1")){
                kommando1();

            }

            if (valgtKommando.equals("2")){

            }

            if (valgtKommando.equals("3")){

            }

            if (valgtKommando.equals("4")){

            }

            if (valgtKommando.equals("5")){

            }

            if (valgtKommando.equals("6")){

            }

            kommando.close();
    }
  public void kommando1(){

    lesInnFil("Legedata.txt");
    // System.out.println(legemiddelListe);
    // System.out.println(legeListe);
    // System.out.println(pasientListe);

    for(Pasient p : pasientListe){
       System.out.println(p + " sin id: " + p.hentPasientId());

    }for(Legemiddel lm : legemiddelListe){
        System.out.println(lm);
 
     }for(Lege l : legeListe){
        System.out.println(l);
 
     }
  }

  public void kommando2(){

    Scanner kommando = new Scanner(System.in);

            System.out.println("Du valgte aa opprette et nytt element i systemet:)");
            System.out.println("1 for aa opprette et legemiddel");
            System.out.println("2 for aa oppdrette en pasient");
            System.out.println("3 for aa oppdrette en resept");
            System.out.println("4 for aa lage en lege");

            String valgtKommando = kommando.nextLine();  
            System.out.println("Du valgte aa oppdrette: " + valgtKommando);

            kommando.close();


//nytt legemiddel!!---------------------------------------------------

            if (valgtKommando.equals("1")){

                Scanner lmkommando = new Scanner(System.in);

                System.out.println("Du valgte aa opprette et nytt legemiddel:)");
                System.out.println("1 for aa opprette narkotisk");
                System.out.println("2 for aa oppdrette vanlig");
                System.out.println("3 for aa oppdrette vanedannende");

                String valgLm = lmkommando.nextLine();
                
                lmkommando.close();

//narkotisk
                if(valgLm.equals("1")){
                    System.out.println("Du valgte aa oppdrette type narkotisk");

                    Scanner navn = new Scanner(System.in);
                    System.out.println("Navn:");
                    String valgtnavn = navn.nextLine();
                    navn.close();

                    Scanner pris = new Scanner(System.in);
                    System.out.println("Pris:");
                    int valgtPris = pris.nextInt();
                    pris.close();

                    Scanner virkestoff = new Scanner(System.in);
                    System.out.println("Navn:");
                    int valgtVs = navn.nextInt();
                    virkestoff.close();

                    Scanner styrke = new Scanner(System.in);
                    System.out.println("Navn:");
                    int valgtStyrke = navn.nextInt();
                    styrke.close();

                    Narkotisk nyNarkotisk = new Narkotisk(valgtnavn, valgtPris, valgtVs, valgtStyrke);

                }
// vanlig
                if(valgLm.equals("2")){
                    System.out.println("Du valgte aa oppdrette type vanlig");

                    Scanner navn = new Scanner(System.in);
                    System.out.println("Navn:");
                    String valgtnavn = navn.nextLine();
                    navn.close();

                    Scanner pris = new Scanner(System.in);
                    System.out.println("Pris:");
                    int valgtPris = pris.nextInt();
                    pris.close();

                    Scanner virkestoff = new Scanner(System.in);
                    System.out.println("Navn:");
                    int valgtVs = navn.nextInt();
                    virkestoff.close();

                    Vanlig nyVanlig = new Vanlig(valgtnavn, valgtPris, valgtVs);

                }

// vanedannende
                if(valgLm.equals("3")){
                    System.out.println("Du valgte aa oppdrette narkotisk");

                    Scanner navn = new Scanner(System.in);
                    System.out.println("Navn:");
                    String valgtnavn = navn.nextLine();
                    navn.close();

                    Scanner pris = new Scanner(System.in);
                    System.out.println("Pris:");
                    int valgtPris = pris.nextInt();
                    pris.close();

                    Scanner virkestoff = new Scanner(System.in);
                    System.out.println("Navn:");
                    int valgtVs = navn.nextInt();
                    virkestoff.close();

                    Scanner styrke = new Scanner(System.in);
                    System.out.println("Navn:");
                    int valgtStyrke = navn.nextInt();
                    styrke.close();

                    Vanedannende nyvVanedannende = new Vanedannende(valgtnavn, valgtPris, valgtVs, valgtStyrke);


                }
            }

//nytt pasient!!---------------------------------------------------

            if (valgtKommando.equals("2")){

                System.out.println("Du har valgt aa lage en ny pasient");

                Scanner navn = new Scanner(System.in);
                    System.out.println("Navn:");
                    String valgtnavn = navn.nextLine();
                    navn.close();

                    Scanner fodelsNr = new Scanner(System.in);
                    System.out.println("Navn:");
                    String valgtfodelsNr = fodelsNr.nextLine();
                    fodelsNr.close();

                    Pasient nyPasient = new Pasient(valgtnavn, valgtfodelsNr);
            }

//nytt resept!!---------------------------------------------------

            if (valgtKommando.equals("3")){



                
                System.out.println("Du har valgt aa lage en ny resept");

                Scanner legeMiddel = new Scanner(System.in);
                System.out.println("Navn:");
                String valgtLm = legeMiddel.nextLine();

                                              // ikke finn paa nytt lm!!
                legeMiddel.close();

                    Scanner fodelsNr = new Scanner(System.in);
                    System.out.println("Navn:");
                    String valgtfodelsNr = fodelsNr.nextLine();
                    fodelsNr.close();

                    Pasient nyPasient = new Pasient(valgtnavn, valgtfodelsNr);

            }


      
}

public void kommando3(){
      
}

public void kommando4(){
      
}

public void kommando5(){
      
}

public void kommando6(){
      
}
}
//Legg inn -metode
