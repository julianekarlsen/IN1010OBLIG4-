public class Stabel <T> extends Lenkeliste <T> {

    @Override
    public void leggTil(T x) {
        Node nyNode = new Node(x);
        stoerrelse ++;   
        if(forste == null){
            forste = nyNode;
            siste = nyNode;
        } else {
            nyNode.neste = forste;
            forste.forrige = nyNode;
            forste = nyNode;
        }
    }
    
}