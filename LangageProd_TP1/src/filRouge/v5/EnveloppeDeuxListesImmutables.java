package filRouge.v5;

/*
 * Implem immutable.
 */

/*
 * Complexité : temps constant si usage linéaire
 * (sans persistance) (amortissement relatif à l'ajout)
 */

import java.util.Iterator;

public class EnveloppeDeuxListesImmutables<E> implements EtatFileImmutable<EnveloppeDeuxListesImmutables<E>,E> {

	private ListeImmutable<E> listeDebut; // liste de tete dans l'ordre
											// d'arrivée
	private ListeImmutable<E> listeFin;// liste de queue dans l'ordre inverse
										// d'arrivée
	// Invariant : si listeTete vide, alors listeFin vide.

	private int taille;

	public EnveloppeDeuxListesImmutables() {
		ListeImmutable<E> vide = ListeImmutable.vide();
		this.listeFin = vide;
		this.listeDebut = vide;
		this.taille = 0;
	}

	public EnveloppeDeuxListesImmutables(int taille, ListeImmutable<E> listeTete, ListeImmutable<E> listeFin) {
		this.taille = taille;
		if (listeTete.estVide()) {
			ListeImmutable<E> vide = listeTete;
			listeTete = listeFin.miroir();
			listeFin = vide;
		}
		this.listeDebut = listeTete;
		this.listeFin = listeFin;
	}

	@Override
	public E premier() {
		if (this.estVide()) {
			throw new UnsupportedOperationException();
		}
		return this.listeDebut.tete();
	}

	@Override
	public EnveloppeDeuxListesImmutables<E> suivants() {
		if (this.estVide()) {
			throw new UnsupportedOperationException();
		}
		return new EnveloppeDeuxListesImmutables<E>(this.taille - 1, this.listeDebut.reste(), this.listeFin);
	}

	@Override
	public int taille() {
		return this.taille;
	}


	@Override
	public EnveloppeDeuxListesImmutables<E> creer() {
		return new EnveloppeDeuxListesImmutables<>();
	}

	public EnveloppeDeuxListesImmutables<E> creer(E dernier) {
		return new EnveloppeDeuxListesImmutables<>(this.taille + 1, this.listeDebut,
				ListeImmutable.cons(dernier, this.listeFin));
	}

	@Override
	public Iterator<E> iterator() {
		ListeImmutable<E> concatener = listeFin;
		for (E el: listeDebut.miroir() ) {
			concatener = concatener.creer(el);
		}
		return concatener.iterator();
	}

	@Override
	public String toString() {
		return representation();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EnveloppeDeuxListesImmutables) {
			return estEgal((EtatFileImmutable<EnveloppeDeuxListesImmutables<E>, E>) obj);
		}
		return false;
	}

}
