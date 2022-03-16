import java.util.Iterator;

public abstract class LenkeListe<T> implements Liste<T>{
    protected Node forste  = null;
    protected Node siste  = null;
    protected int stoerrelse = 0;

    public class Node{
        T data;
        Node neste = null;
        Node forrige =  null;

        Node(T data) {
            this.data = data;
        }

    }
    @Override
    public int stoerrelse(){
        return stoerrelse;

    }
    @Override
    public void leggTil(T x){
        Node nyNode = new Node(x);
        stoerrelse ++;

        if (forste == null){
            forste = nyNode;
            siste = nyNode;

        }else{
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

        Node temp = forste;

        if (stoerrelse == 0){
          throw new UgyldigListeindeks(0);

        }
        if (stoerrelse == 1){
            forste = null;
            siste = null;
        }else{
        forste.neste.forrige = null;
        forste = forste.neste;

        }
        stoerrelse --;
        return temp.data;
        
     }
    @Override
    public String toString(){

        String string = "";
        Node temp = forste;

        while (temp != null){
            string += "Data: " + temp.data + "--->" ;

            temp = temp.neste;

        }

        return string;
        
    }
    public Iterator<T> iterator(){
        return new LenkelisteIterator();
    }


     class LenkelisteIterator implements Iterator<T>  {

        Node temp = forste;

        public boolean hasNext(){
            if (temp == null){
                return false;
            }
            return true;
        }
    
        public T next(){
            T returVerdi = temp.data;
            temp = temp.neste;

            return returVerdi;
            
        }

        
    
        
    }
    
    

}



