import java.util.Iterator;


abstract class Lenkeliste <T> implements Liste<T> {
    
    protected Node forste;
    protected Node siste; 
    protected int stoerrelse = 0; 

    public class Node{
        T data; 
        Node neste;
        Node forrige; 

        Node (T data){
            this.data = data;
        }
    }

    @Override
    public int stoerrelse() {
        return stoerrelse;
    }

    @Override
    public void leggTil(T x) {
        Node nyNode = new Node(x);
        stoerrelse ++;
        if(forste == null){
            forste = nyNode;
            siste = nyNode;

        } else {
            nyNode.forrige = siste;            
            siste.neste = nyNode;
            siste = nyNode;
        }
    }

    @Override
    public T hent(){
        return forste.data;
    }

    @Override
    public T fjern() throws UgyldigListeindeks{

        if(forste == null){
            throw new UgyldigListeindeks(0);
        }
        //if (stoerrelse == 0) {
        //    throw new UgyldigListeindeks(-1);
        //}
        Node tmp = forste;
        if(stoerrelse == 1){
            forste = null;
            siste = null;
        } else {
            forste.neste.forrige = null;
            forste = forste.neste;
        }
        stoerrelse --;
        return tmp.data;
        }

    @Override
    public String toString() {
        String string = "[";
    
        Node tmp = forste;
        for (int i = 0; i < stoerrelse; i++) {
            string += tmp.data + ", ";
            tmp = tmp.neste;
        }

        string += "]";
        return string;
    }

    class LenkelisteIterator implements Iterator<T>{
        Node tmp = forste;

        public boolean hasNext(){
            if (tmp == null){
                return false;
            } 
            return true;
            
        }
        public T next(){
            T returverdi = tmp.data;
            tmp = tmp.neste;
            return returverdi;
        }
    }
    
    public Iterator<T> iterator(){
        return new LenkelisteIterator();
    }
}