class IndeksertListe<T> extends Lenkeliste<T> {

    public void leggTil (int pos, T x) {
        Node nyNode = new Node(x);

        if(pos < 0 || pos > stoerrelse){
            throw new UgyldigListeindeks(pos);            
        }

        if(pos == 0){
            nyNode.neste = forste;
            if (stoerrelse > 0){
                forste.forrige = nyNode;
            } else {
                siste = nyNode;
            }
            forste = nyNode;

        } else if (stoerrelse == pos){
            siste.neste = nyNode;
            nyNode.forrige = siste;
            siste = nyNode; 

        } else {
            Node tmp = forste;
            for(int i = 0; i < pos-1; i++){
                tmp = tmp.neste;
            }
            
            if (tmp.neste != null) {
                tmp.neste.forrige = nyNode;
            }
            nyNode.neste = tmp.neste;
            nyNode.forrige = tmp;    
            tmp.neste = nyNode;      
        }    
        stoerrelse ++;
    }

    public void sett (int pos, T x){
        if(pos < 0 || pos >= stoerrelse){
            throw new UgyldigListeindeks(pos-1);            
        }
        Node tmp = forste;
        for(int i = 0; i < pos; i++){
            tmp = tmp.neste;
        }
        tmp.data = x;
    }

    public T hent (int pos){
        if(pos < 0 || pos > stoerrelse){
            throw new UgyldigListeindeks(pos);            
        }

        Node tmp = forste;
        for(int i = 0; i < pos; i++){
            tmp = tmp.neste;
        }
        return tmp.data;        
    }

    public T fjern (int pos){
        if(pos < 0 || pos >= stoerrelse){
            throw new UgyldigListeindeks(-1);            
        }

        T returdata;

        if (pos == 0) {
            returdata = forste.data;
            forste = forste.neste;
            if (forste != null) {
                forste.forrige = null;
            }

        } else {
            Node tmp = forste;
            for(int i = 0; i < pos-1; i++){
                tmp = tmp.neste;
            }
            returdata = tmp.neste.data;
            tmp.neste = tmp.neste.neste;
            if (tmp.neste != null) {
                tmp.neste.forrige = tmp;
            }
        }

        stoerrelse--;
        return returdata;
    }
}