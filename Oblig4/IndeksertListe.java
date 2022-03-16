public class IndeksertListe<T> extends LenkeListe<T> {
    protected int pos;


    public void leggTil(int pos, T x)throws UgyldigListeindeks{
        Node nyNode = new Node(x);


        if (pos < 0 || pos > stoerrelse){
            throw new UgyldigListeindeks(pos);


        }

        if (pos == 0){
            nyNode.neste = forste;

             if (stoerrelse > 0){
                 forste.forrige = nyNode;
        
             } else{
                 siste = nyNode;
             }

            forste = nyNode;

        }else if (stoerrelse == pos){
            siste.neste = nyNode;
            nyNode.forrige = siste;
            siste = nyNode;

       }else{
            Node temp = forste;

            for (int index = 0; index < pos-1 ; index++){
                temp = temp.neste;
            }

            if (temp.neste != null){
            temp.neste.forrige = nyNode;
        }
            nyNode.neste = temp.neste;
            nyNode.forrige = temp;
            temp.neste = nyNode;
        
           
        }
        stoerrelse ++;

    }
    public void sett(int pos, T x)throws UgyldigListeindeks{

        if (pos < 0 || pos >= stoerrelse){
            throw new UgyldigListeindeks(pos);

        }
            
            Node temp = forste;

            for (int index = 0; index < pos ; index++){
                temp = temp.neste;
            }

            temp.data = x;
        }
    

    public T hent(int pos){
        	System.out.println();


        if (pos < 0 || pos > stoerrelse){
            throw new UgyldigListeindeks(pos);
        }
        Node temp = forste;

        for (int index = 0; index < pos ; index++){
            temp = temp.neste;
        }
        return temp.data;

    }
    public T fjern(int pos)throws UgyldigListeindeks{

        if (pos < 0 || pos >= stoerrelse){
            throw new UgyldigListeindeks(-1);

        }

        T fjernetData;

        if (pos == 0){
            fjernetData = forste.data;
            forste = forste.neste;

            if (forste != null){
                forste.forrige = null;
            }
        }else {
             Node temp = forste;

            for (int index = 0; index < pos-1 ; index++){
                temp = temp.neste;
            }
            fjernetData = temp.neste.data;
            temp.neste = temp.neste.neste;

            if (temp.neste != null){
                temp.neste.forrige = temp;
            }



        }



        stoerrelse --;


        return fjernetData;




        

    }
    
}
