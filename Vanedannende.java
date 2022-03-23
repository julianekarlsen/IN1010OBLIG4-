class Vanedannende extends Legemiddel{
    protected int vanedannendeStyrke;

    public Vanedannende(String n, int p, double mgV, int vs){
        super( n, p, mgV);
        vanedannendeStyrke = vs;

    }

    public int hentVanedannendeStyrke(){
        return vanedannendeStyrke;
    }

    public String toString(){
        return ID + " " + navn + " " + pris + " " + mgVirkestoff + " " + vanedannendeStyrke; 
    }
}


