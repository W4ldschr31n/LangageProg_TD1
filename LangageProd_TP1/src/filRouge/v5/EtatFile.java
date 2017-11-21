package filRouge.v5;

import java.util.Iterator;

public interface EtatFile<K extends EtatFile<K, E>,E> extends Iterable<E>, Mesurable{


    /**
     * Accesseurs
     */

    E premier(); //Premier de la file
    K suivants(); // Ses suivants

    K ajouter(E e);

    default boolean estVide(){
        return true;
    }
    int taille();

    K creer(E dernier, K etat);
    K creer();

    @Override
    Iterator<E> iterator();

    default String representer(){
        return this.toString();
    }


}
