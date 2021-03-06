package tp.v3;

import java.util.Iterator;

public interface Liste<E> extends ListeRenversable<E> {
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
	default Liste<E> reste() {
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
	 * Fabrique une liste vide
	 * @param <E> Types d'lements de la liste annonyme
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

	/**
	 * Ajout en tête
	 * @param tete de la nouvelle liste
	 * @param reste liste des étléments de queue
	 * @param <E> Type d' éléments de la liste anonyme
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
