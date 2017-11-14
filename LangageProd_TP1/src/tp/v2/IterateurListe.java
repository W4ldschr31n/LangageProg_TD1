package tp.v2;

import java.util.Iterator;

public class IterateurListe<E> implements Iterator<E> {
	private Liste courant;

	public IterateurListe(Liste<E> liste){
		this.courant = liste;

	}

	@Override
	public boolean hasNext() {
		return !courant.casVide();
	}

	@Override
	public E next() {
		E tete = (E)courant.tete();
		this.courant = this.courant.reste();
		return tete;
	}

}
