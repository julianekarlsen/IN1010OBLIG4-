import java.util.Iterator;

public class Prioritetskoe<T extends Comparable<T>> extends LenkeListe<T>{


    @Override
    public void leggTil(T x){
        Node nyNode = new Node(x);


       if (stoerrelse == 0){
           // forste = nyNode;
           // siste = nyNode;
            super.leggTil(x);
            return;
        }

        if (forste.data.compareTo(x) > 0){          // hvis noden er mindre enn den forste, settes forst
            forste.forrige = nyNode;
            nyNode.neste = forste;
            forste = nyNode;
        }

        else if (x.compareTo(siste.data) >= 0){         // hvis den siste, er storre eller lik noden settes den bakerst
            siste.neste = nyNode;
            nyNode.forrige = siste;
            siste = nyNode;

        } else {                                          // hvis den siste ikke er storre
            Node temp = forste;

            while(true){  
                if (x.compareTo(temp.data) <= 0) {        // gar gjennom listen til den ikke er storre 
                    nyNode.neste = temp.neste;
                    temp.neste = nyNode;
                    break;
                }
                temp = temp.neste;
            }
        

        }

        stoerrelse ++;
        
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

}