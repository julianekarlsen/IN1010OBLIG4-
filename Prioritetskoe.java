public class Prioritetskoe<T extends Comparable<T>> extends Lenkeliste<T> {

    public void leggTil(T x){
        Node nyNode = new Node(x);

        if (stoerrelse == 0){
            forste = nyNode;
        } else if (x.compareTo(forste.data) < 0) {
            nyNode.neste = forste;
            forste = nyNode;
        }else {
            Node tmp = forste;
            for (int i = 0; i < stoerrelse -1; i++){

                if(x.compareTo(tmp.neste.data) < 0){
                    break;
                }
                tmp = tmp.neste;
            }

            nyNode.neste = tmp.neste;
            tmp.neste = nyNode;
            if (nyNode.neste != null) {nyNode.neste.forrige = nyNode;}
            nyNode.forrige = tmp;

        }

        stoerrelse ++;
    }    
}