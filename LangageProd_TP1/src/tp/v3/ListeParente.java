package tp.v3;

import java.util.Iterator;

public interface ListeParente<E> extends Iterable<E> {
  /**
   *  Indique si l'instance est une liste Vide
   * @return true si la liste est vide false sinon
   */
  default boolean casVide() {
    return false;
  }

  /**
   * Revoie la Tête de la liste
   * @return l'élément de tête
   */
  default E tete() {
    throw new UnsupportedOperationException();
  }

  /**
   * Revoie les éléments suivants
   * @return une liste délémentd de type E
   */
  default ListeParente<E> reste() {
    throw new UnsupportedOperationException();
  }

  /**
   * Indique si la liste n'est pas vide
   * @return false si la liste est vide true sinon
   */
  default boolean casCons() {
    return false;
  }

  /**
   * Renvoie le nombre d'éléments dans la liste
   * @return nombre d'éléments
   */
  default public int taille(){
    return 0;
  }

  /**
   * Teste si la liste est vide
   * @return true si la liste est vide false sinon
   */
  default public boolean estVide(){
    return this.taille() == 0;
  }

  /**
   * Cree un iterator sur la liste
   * @return IterateurListe
   */
  default Iterator<E> iterator() {
    return new IterateurListe<E>(this);
  }

  /**
   * Inverse les éléments de la liste
   * @return
   */
  default ListeParente<E> miroir(){
    ListeParente miroir = vide();
    Iterator iterateur = iterator();
    while (iterateur.hasNext()){
      cons((E)(iterateur.next()),miroir);
    }
    return miroir;
  }

  ListeParente<E> vide();
  ListeParente<E> cons(E tete, ListeParente<E> reste);
}
