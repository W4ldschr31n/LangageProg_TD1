package tp.v1.Files.Interface;

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
     * @return dernier element
     */
    T getQueue() throws NoSuchElementException;

    /**
     * Retourne tout les elements de la file de maniere ordonnee
     * Le type de retour dois etre adapte au type d'implementation
     *
     * @return  Tableau d'elements de la file ou l'indice 0 correspond a la tete
     */
    T[] getElements();

    /**
     * Ajoute un element du meme type que les elements de la file en bout de file
     * La modification se fait sur l'objet mÃªme
     *
     * @param  element  Un element de type T
     *  @return la file apres tentative d'insertion
     */
    FileMutable<T> ajouterQueue(T element);

    /**
     * Renvoie le premier element de la file et le supprime apres de la file
     * La modification se fait sur l'objet meme
     * Preconditions: La file ne dois pas etre vide.
     *
     * @return  Un element de type T
     */
    T enleverTete() throws EmptyStackException;

    /**
     * Teste si un element est ou non dans la file
     *
     * @param element
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
     * Concatene a la queue une autre file en conservant l'ordre de ses elements
     * Pre Condition: les elements de l'autre file sont egalement de type T
     *
     * @param f une autre File
     * @return la file resultat de l'opération
     */
    FileMutable<T> concatener(File<T> f);

    /**
     * Teste si la file est vide ou non
     *
     * @return Vrai si la file est vide
     */
    boolean estVide();
}
