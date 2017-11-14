package tp.v3;

import java.util.Iterator;

public class IterateurListe<E> implements Iterator<E> {
  private Liste premier;
  private Liste courant;

  public IterateurListe(ListeParente<E> liste){
    this.premier = liste;
    this.courant = liste;

  }

  @Override
  public boolean hasNext() {
    return courant.reste()!=null;
  }

  @Override
  public E next() {
    E tete = (E)courant.tete();
    this.courant = this.courant.reste();
    return tete;
  }

}
