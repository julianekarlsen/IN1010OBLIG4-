class Vanlig extends Legemiddel {

    //Konstuktør
    public Vanlig(String n, int p, double mgV) {
        super(n,p,mgV);
    }

    public String toString(){
        return ID + " " + navn + " " + pris + " " + mgVirkestoff + " "; 
    }
    
}
