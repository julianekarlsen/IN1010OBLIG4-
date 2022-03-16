
 public class MilResept extends Hviteresepter {
   
    public MilResept(Legemiddler legemiddel, Lege utskrivendeLege, Pasient pasient){
        super(legemiddel, utskrivendeLege,  pasient, 3);
        reit = 3;
    }

    @Override
    public int prisAaBetale(){
        int prisen = legemiddel.hentPris();
        prisen = prisen - (prisen*1);

        return prisen;

    }

    





 }