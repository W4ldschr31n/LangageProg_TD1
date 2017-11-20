package filRouge.v5;

public interface FileMutable<E> extends
	File<FileMutable<E>, E>,
	IdentifiableParIteration<FileMutable<?>, E>,
	RepresentableParIteration<E> {

	/*
	 * Accesseurs.
	 */

	void ajouter(E element);
	void retirer();

	FileMutable<E> getReste(); // Les elements suivants

	@Override
	default FileMutable<E> suivants(){ // Une copie des elements suivants
		return getReste().creerCopie();
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

	void ajouter(FileMutable<E> secondeFile);
}
	
	/*
	 * Services
	 */
/*Fabriques statiques
	public static <E> FileMutable<E> vide() {
		return new FileMutable<E>() {

			@Override
			public boolean casVide(){
				return true;
			}
			@Override
			public boolean equals(Object obj){
				if(!(obj instanceof FileMutable<?>))
					return false;
				FileMutable<?> l = (FileMutable<?>)obj;
				return this.estEgal(l);
			}
			@Override
			public String toString() {
				return this.representation();
			}

		};
	}

	
	public static <E> FileMutable<E> cons(E t, FileMutable<E> r) {
		return new FileMutable<E>() {
			private E tete = t;
			private FileMutable<E> reste = r;
			private int taille = r.taille() + 1;
			@Override
			public boolean casCons(){
				return true;
			}
			public E tete() {
				return this.tete;
			}
			public FileMutable<E> reste() {
				return this.reste;
			}
			@Override
			public int taille() {
				return this.taille;
			}

			@Override
			public void changerTete(E tete) {
				this.tete = tete;
			}

			@Override
			public void ajouter(E element) {
				this.reste = this.creerCopie();
				this.tete = element;
			}

			@Override
			public void retirer() {
				this.tete = this.reste.tete();
				this.reste = this.reste.reste();
			}

			@Override
			public void changerReste(FileMutable<E> reste) {
				this.reste = reste;
			}
			@Override
			public boolean equals(Object obj){
				if(!(obj instanceof FileMutable<?>))
					return false;
				FileMutable<?> l = (FileMutable<?>)obj;
				return this.estEgal(l);
			}
			@Override
			public String toString() {
				return this.representation();
			}
		};
	}

	default FileMutable ajout(E element){
		return 	cons(element,this);
	}
	@Override
	default FileMutable<E> retrait(){
		return 	this.suivants();
	}

	//facultatif
	default void ajouter(FileMutable<E> file2){
		for(E element : file2){
			this.ajout(element);
		}
	}


}
*/