package tp.v1.Files.Interface;

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
     * @return le dernier element
     */
    T getQueue();

    /**
     * Retourne tout les elements de la file de maniere ordonnee
     *
     * @return Tableau d'elements de la file ou l'indice 0 correspond a la tete
     */
    T[] getElements();

    /**
     * Retire le dernier element de la file
     *
     * @return un objet permettant ne pas perdre d'information sur la tete enlevee
     */
    Object enleverTete();

    /**
     * Teste si un element est ou non dans la file
     *
     * @param element de type T
     * @return Vrai si l'element est present dans la file
     */
    boolean contient(T element);

    /**
     * Revoie le nombre d'elements presents dans la file
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
    
    /**
     * Ajoute un element du meme type que les elements de la file en bout de file
     *
     * @param  element  Un element de type T
     * @return la file generee par l'operation
     */
    File<T> ajouterQueue(T element);
    
    
    /**
     * Concatene a la queue une autre file en conservant l'ordre de ses elements
     * Pre Condition: les elements de l'autre file sont egalement de type T
     *
     * @param f une autre File
     * @return la file resultant de l'operation
     */
    File<T> concatener(File<T> f);
}
