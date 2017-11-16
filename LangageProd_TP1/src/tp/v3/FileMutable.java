package tp.v3;

import java.util.Iterator;

public interface FileMutable<E> extends File<E> {


	/**
	 * Retourne les éléments suivants de la file.
	 * @return les éléments suivants de la file.
	 */
	@Override
	default FileMutable<E> suivants(){
		Iterator<E> i = this.iterator();
		FileMutable<E> suivants = creer();
		while (i.hasNext()){
			suivants.ajout(i.next());
		}
		return suivants;
	}
	
	/**
	 * Retire un élément.
	 */
	void retirer();
	
	/*
	 * Fabriques
	 */
	/**
	 * Crée une nouvelle file.
	 * @return	La file créée.
	 */
	FileMutable<E> creer();

	/**
	 * Fabrique une file avec un element en tete
	 * @return une instance de File*
	 * @param  dernier un elément de type E
	 */
	FileMutable<E> creer(E dernier);

	/**
	 * Crée une copie de la file actuelle.
	 * @return	une nouvelle instance de file identique à celle-ci.
	 */
	FileMutable<E> creerCopie();
	
	/*
	 * Services
	 */

	/**
	 * Retire l'élément en tête de file.
	 * Retourne la file sans l'ancien élément de tête.
	 */
	@Override
	default FileMutable<E> retrait() {
		this.retirer();
		return this;
	}


}
