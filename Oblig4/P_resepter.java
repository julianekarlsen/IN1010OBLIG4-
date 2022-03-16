
 public class P_resepter extends Hviteresepter {

    public P_resepter(Legemiddler legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
        super(legemiddel, utskrivendeLege, pasient, reit); 
    }

    @Override
    public int prisAaBetale(){
        int prisen = legemiddel.hentPris();
        if (prisen != 0){
            prisen = prisen - 108;
            if (prisen < 0){
                prisen = 0;
            }
        }

        return prisen;

    }

    





 }