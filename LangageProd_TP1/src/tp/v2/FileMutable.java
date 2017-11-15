package tp.v2;

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
	 * Ajoute un élément à la file.
	 * @param element l'élément à ajouter
	 */
	void ajouter(E element);
	
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
	 * Crée une copie de la file actuelle.
	 * @return	une nouvelle instance de file identique à celle-ci.
	 */
	FileMutable<E> creerCopie();
	
	/*
	 * Services
	 */
	/**
	 * Ajoute un élément en queue de file.
	 * @return la liste avec l'élément ajouté.
	 */
	@Override
	default FileMutable<E> ajout(E dernierDansFile) {
		this.ajouter(dernierDansFile);
		return this;
	}
	/**
	 * Retire l'élément en tête de file.
	 * Retourne la file sans l'ancien élément de tête.
	 */
	@Override
	default FileMutable<E> retrait() {
		this.retirer();
		return this;
	}
	
	// ComplexitÃ© O(|secondeFile|)
	/**
	 * Ajoute une seconde file à la file actuelle.
	 * @param secondeFile La file à ajouter à la file actuelle.
	 * @return la file avec les nouveaux éléments ajoutés.
	 */
	@Override
	default FileMutable<E> ajout(File<E> secondeFile) {
		for(E e : secondeFile){
			this.ajout(e);
		}
		return this;
	}
	
	// ComplexitÃ© en O(1).
	/**
	 * Ajoute une seconde file à la file actuelle.
	 * @param secondeFile LA file à ajouter à la file actuelle.
	 */
	void ajouter(File<E> secondeFile);

}
