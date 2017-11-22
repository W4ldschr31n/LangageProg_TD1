package filRouge.v5;

/*
 * Implem immutable.
 */

/*
 * Complexité : temps constant si usage linéaire
 * (sans persistance) (amortissement relatif à l'ajout)
 */

import java.util.Iterator;

class EnveloppeDeuxListesImmutables<E> implements EtatFileImmutable<EnveloppeDeuxListesImmutables<E>,E> {

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
		return listeDebut.iterator();
	}

	@Override
	public String toString() {
		return this.listeDebut.representation();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof EtatFile)) {
			return false;
		}
		EtatFile file = (EtatFile) obj;
		return this.estEgal(file);
	}

	boolean estEgal(EtatFile autre) {
		if (this.taille() != autre.taille()) {
			return false;
		}
		Iterator<E> iter1 = this.iterator();
		Iterator<?> iter2 = autre.iterator();
		while (iter1.hasNext()) {
			if (!iter1.next().equals(iter2.next())) {
				return false;
			}
		}
		return true;
	}
}
