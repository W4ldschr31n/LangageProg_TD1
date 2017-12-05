package filRouge.v6;

import filRouge.v5.ListeImmutable;
import filRouge.v5.Mesurable;

public class Miroir<E> implements Mesurable{

    private ListeImmutable<E> inversion;
    private ListeImmutable<E> calcul;
    private int taille;

    public Miroir(ListeImmutable<E> source){
        inversion = source;
        calcul = ListeImmutable.vide();
        taille = source.taille();
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

    @Override
    public int taille() {
        return taille;
    }
}