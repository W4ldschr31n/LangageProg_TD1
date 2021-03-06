package filRouge.v5;

import java.util.Iterator;

public interface EtatFile<K extends EtatFile<K, E>,E> extends Iterable<E>, Mesurable, RepresentableParIteration<E>, IdentifiableParIteration<K, E>{


    /**
     * Accesseurs
     */

    E premier(); //Premier de la file
    K suivants(); // Ses suivants

    default K ajouter(E e){
        return sujet().creer(e);
    }

    @SuppressWarnings("unchecked")
    default K sujet(){
        return (K)this;
    }

    default boolean estVide(){
        return taille()==0;
    }
    int taille();

    K creer(E dernier);
    K creer();

    @Override
    Iterator<E> iterator();


}
