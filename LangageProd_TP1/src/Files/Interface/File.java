package Files.Interface;

public interface File<T> {

    /**
     * Renvoie le premier element de la file
     *
     * @return    le premier element de la file
     */
    T getTete();

    /**
     * Revoie le dernier element de la file
     *
     * @return dernier élément
     */
    T getQueue();

    /**
     * Retourne tout les éléments de la file de manière ordonnée
     *
     * @return Tableau d'elements de la file ou l'indice 0 correspond a la tête
     */
    T[] getElements();

    /**
     * Elève le dernier élement de la file
     *
     * @return un objet représentant la tete de la file pour ne pas perdre d'information
     */
    Object enleverTete();

    /**
     * Teste si un élément est/ou non dans la file
     *
     * @param element
     * @return Vrai si l'élément est présent dans la file
     */
    boolean contient(T element);

    /**
     * Revoie le nombre d'éléments présents dans la fille
     *
     * @return taille
     */
    int taille();

    /**
     * Teste si la file est vide ou non
     *
     * @return Vrai si la file est vide
     */
    boolean estVide();
}
