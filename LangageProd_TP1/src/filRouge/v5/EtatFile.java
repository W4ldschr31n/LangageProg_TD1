package filRouge.v5;

public interface EtatFile<K extends EtatFile<K, E>,E> extends Iterable<E>, Mesurable{

    /**
     * Accesseurs
     */

    E premier(); //Premier de la file
    K suivants(); // Ses suivants
    default boolean estVide(){
        return true;
    }

    /**
     * Fabriques
     */
    K creer();
    @SuppressWarnings("unchecked")
    default K sujet(){
        return (K)this;
    }

    /**
     * Services
     */
    K ajout(E dernierDansFile); // Ajout en fin
    K retrait(); // Retrait du premier element
    default K ajout(K secondeFile) { // Ajout de la seconde file en fin de file
        K clone = sujet();
        for(E element:secondeFile){
            clone.ajout(element);
        }
        return clone;
    }

}
