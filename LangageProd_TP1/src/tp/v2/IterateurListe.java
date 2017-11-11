package tp.v2;

import java.util.Iterator;

public class IterateurListe<E> implements Iterator<E> {
	private Liste premier;
	private Liste courant;

	public IterateurListe(Liste<E> liste){
		this.premier = liste;
		this.courant = liste;

	}

	@Override
	public boolean hasNext() {
		return courant.reste().casVide();
	}

	@Override
	public E next() {
		this.courant = this.courant.reste();
		return (E)this.courant.tete();
	}

}
