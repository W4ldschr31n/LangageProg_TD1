package tp.v2;

import java.util.Iterator;

public interface Liste<E> extends Iterable<E> {
	/*
	 * Accesseurs
	 */
	default boolean casVide() {
		return false;
	}
	default E tete() {
		throw new UnsupportedOperationException();
	}
	default Liste<E> reste() {
		throw new UnsupportedOperationException();
	}
	default boolean casCons() {
		return false;
	}
	default public int taille(){
		return 0;
	}
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
	default Liste<E> miroir(){
		Liste miroir = vide();
		Iterator iterateur = iterator();
		while (iterateur.hasNext()){
			cons(iterateur.next(),miroir);
		}
		return miroir;
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

		};
	}

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

	
}
