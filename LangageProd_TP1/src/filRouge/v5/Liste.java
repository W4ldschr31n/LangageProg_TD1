package filRouge.v5;

import java.util.Iterator;

public interface Liste<K extends Liste<K, E>, E> extends Iterable<E>, Mesurable {
	/*
	 * Accesseurs
	 */
	default boolean casVide() {
		return false;
	}
	default E tete() {
		throw new UnsupportedOperationException();
	}
	default K reste() {
		throw new UnsupportedOperationException();
	}
	default boolean casCons() {
		return false;
	}
	default  boolean estVide(){
		return this.taille() == 0;
	}
	@Override
	default  int taille(){
		return 0;
	}
	/*
	 * Fabriques
	 */
	@SuppressWarnings("unchecked")
	default K sujet(){
		return (K)this;
	}
	K creer();
	K creer(E e);
	
	/*
	 * Services
	 */
	@Override
	default Iterator<E> iterator() {
		return new IterateurListe<K, E>(this.sujet());
	}
	default K miroir(){
		K r = creer();
		for(E e : this){
			r = r.creer(e);
		}
		return r;
	}

	K ajout(E dernierDansFile); // Ajout en fin
	K retrait(); // Retrait de premier élément
	// Ajout de la seconde file en fin de file
	default K ajout(K secondeFile){
		K somme = creer();
		for(E element:secondeFile){
			somme.ajout(element);
		}
		return somme;
	}
	
}
