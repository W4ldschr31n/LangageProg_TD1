package filRouge.v5;

import java.util.Iterator;

public interface FileMutable<E> extends
	File<FileMutable<E>, E>,
	IdentifiableParIteration<FileMutable<?>, E>,
	RepresentableParIteration<E> {

	/*
	 * Accesseurs.
	 */

	void ajouter(E element);
	void retirer();


	@Override
	default FileMutable<E> suivants(){ // Une copie des elements suivants
		FileMutable<E> copie = creerCopie();
		copie.retirer();
		return copie;
	}


	/*
	 * Fabriques.
	 */

	FileMutable<E> creerCopie(); // Fabrique realisant une copie de la file

	/**
	 * Services
	 */
	@Override
	default FileMutable<E> retrait(){
		return suivants();
	}
	@Override
	default FileMutable<E> ajout(E dernier){
		FileMutable<E> copie = creerCopie();
		copie.ajouter(dernier);
		return copie;
	}

	//facultatif
	default void ajouter(FileMutable<E> file2){
		for(E element : file2){
			this.ajout(element);
		}
	}


	/**
	 * Fabriques statiques
	 */


	static <E> FileMutable<E> creerAvecEtatMutable(EtatFileMutable<EtatFileMutable, E> etatFile){
		return new FileMutable<E>() {
			private EtatFileMutable<EtatFileMutable, E> etat = etatFile;

			@Override
			public void ajouter(E e) {
				etat = etat.ajouter(e);
			}

			@Override
			public void retirer() {
				etat = etat.suivants();
			}

			@Override
			public FileMutable<E> creerCopie() {
				return creerAvecEtatMutable(etat);
			}

			@Override
			public E premier() {
				return etat.premier();
			}

			@Override
			public FileMutable<E> creer() {
				return creerAvecEtatMutable(EtatFileMutable.vide());
			}

			@Override
			public int taille() {
				return etat.taille();
			}

			@Override
			public Iterator<E> iterator() {
				return etat.iterator();
			}

			public String toString(){
				return etat.toString();
			}
		};
	}

	static <E> FileMutable<E> creerAvecEtatImmutable(EtatFileImmutable<EtatFileImmutable, E> etatFile){
		return new FileMutable<E>() {
			private EtatFileImmutable<EtatFileImmutable, E> etat = etatFile;

			@Override
			public void ajouter(E e) {
				etat = etat.ajouter(e);
			}

			@Override
			public void retirer() {
				etat = etat.suivants();
			}

			@Override
			public FileMutable<E> creerCopie() {
				return creerAvecEtatImmutable(etat);
			}

			@Override
			public E premier() {
				return etat.premier();
			}

			@Override
			public FileMutable<E> creer() {
				return creerAvecEtatImmutable(EtatFileImmutable.vide());
			}

			@Override
			public int taille() {
				return etat.taille();
			}

			@Override
			public Iterator<E> iterator() {
				return etat.iterator();
			}

			public String toString(){
				return etat.toString();
			}
		};
	}





}