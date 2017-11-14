package tp.v3;

import java.util.Iterator;

public interface Liste<E> extends ListeParente<E> {


  /**
   * Ajout en tête
   * @param tete de la nouvelle liste
   * @param reste liste des étléments de queue
   * @param <E>
   * @return Une nouvelle liste avec l'élément en plus
   */
  public static <E> Liste<E> cons(E tete, Liste<E> reste) {
    return new Liste<E>() {

      @Override
      public E tete() {
        return tete;
      }

      @Override
      public Liste<E> reste() {
        return reste;
      }

      @Override
      public int taille() {
        return reste.taille()+1;
      }
    };
  }

  /**
   * Fabrique une liste vide
   * @param <E>
   * @return Une liste vide
   */
  public static <E> Liste<E> vide() {
    return new Liste<E>() {
      @Override
      public boolean casVide() {
        return true;
      }

      @Override
      public boolean casCons() {
        return false;
      }
    };
  }

}
