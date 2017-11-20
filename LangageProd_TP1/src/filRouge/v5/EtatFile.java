package filRouge.v5;

import java.util.Iterator;

public interface EtatFile<K extends EtatFile<K, E>,E> extends Iterable<E>, Mesurable{


    /**
     * Accesseurs
     */

    E premier(); //Premier de la file
    K suivants(); // Ses suivants
    default boolean estVide(){
        return true;
    }
    int taille();

    @Override
    Iterator<E> iterator();

    /**
     * Fabriques
     */

    static EtatFileVide creerVide(){
        return  EtatFileVide.creer();
    }
    static EtatFileCons creerCons(E el, K File){
        return  EtatFileCons.creer(E el, K File);
    }




}
