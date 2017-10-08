package Files.Interface;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public interface FileMutable<T> extends File<T> {

    /**
     * Renvoie le premier element de la file
     *
     * @return    le premier element de la file
     */
    T getTete() throws NoSuchElementException;

    /**
     * Revoie le dernier element de la file
     *
     * @return dernier élément
     */
    T getQueue() throws NoSuchElementException;

    /**
     * Retourne tout les éléments de la file de manière ordonnée
     * Le type de retour dois être adapté au type d'implémentation
     *
     * @return  Tableau d'elements de la file ou l'indice 0 correspond a la tête
     */
    T[] getElements();

    /**
     * Ajoute un element du meme type que les elements de la file en bout de file
     * La modification se fait sur l'objet même
     *
     * @param  element  Un element de type T
     */
    void ajouterQueue(T element);

    /**
     * Renvoie le premier element de la file et le supprime apres de la file
     * La modification se fait sur l'objet même
     * Preconditions: La file ne dois pas être vide.
     *
     * @return  Un element de type T
     */
    T enleverTete() throws EmptyStackException;

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
     * Concatène a la queue une autre file f en conservant l'ordre de ses éléments
     * Pre Condition: les éléments de l'autre file sont également de type T
     *
     * @param f une autre File
     */
    void concatener(File<T> f);

    /**
     * Teste si la file est vide ou non
     *
     * @return Vrai si la file est vide
     */
    boolean estVide();
}
