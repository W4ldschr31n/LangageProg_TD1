package filRouge.v6;

import filRouge.v5.ListeImmutable;

public class Miroir<E> {

    private ListeImmutable<E> inversion;
    private ListeImmutable<E> calcul;

    public Miroir(ListeImmutable<E> source){
        inversion = source;
        calcul = ListeImmutable.vide();
    }

    public boolean estInversible(){
        return !inversion.estVide();
    }

    public void inverser(){
        calcul = calcul.creer(inversion.tete());
        inversion = inversion.reste();
    }

    public ListeImmutable<E> miroir(){
        if(!estInversible()){
            return calcul;
        }else{
            throw new UnsupportedOperationException();
        }
    }

    public String toString(){
        return inversion.representation();
    }
}
