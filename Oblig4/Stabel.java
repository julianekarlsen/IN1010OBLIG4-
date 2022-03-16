
public class Stabel<T> extends LenkeListe<T> {


    @Override
    public void leggTil(T x){
        Node nyNode = new Node(x);

        if (stoerrelse == 0){
            forste = nyNode;
            stoerrelse ++;

        }else{
        forste.forrige = nyNode;
        nyNode.neste = forste;
        forste = nyNode;
        stoerrelse ++;

        }
    }
}
