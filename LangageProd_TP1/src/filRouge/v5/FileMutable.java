package filRouge.v5;

public interface FileMutable<E> extends
	Liste<FileMutable<E>, E>,
	IdentifiableParIteration<FileMutable<?>, E>,
	RepresentableParIteration<E>
{

	/*
	 * Accesseurs.
	 */

	default void changerReste(FileMutable<E> reste) {
		throw new UnsupportedOperationException();
	}
	
	default void changerTete(E tete) {
		throw new UnsupportedOperationException();
	}

	void ajouter(E element);
	void retirer();

	default FileMutable<E> suivants(){
		FileMutable suivants = creerCopie();
		suivants.retirer();
		return suivants;
	}
	
	/*
	 * Fabriques.
	 */
	@Override
	default FileMutable<E> creer() {
		return vide();
	}
	@Override
	default FileMutable<E> creer(E e) {
		return cons(e, this);
	}

	//copie de la file this
	default FileMutable<E> creerCopie(){
		FileMutable copie = creer();
		copie.ajout(this);
		return copie;

	}

	
	/*
	 * Services
	 */

	public static <E> FileMutable<E> vide() {
		return new FileMutable<E>() {
			@Override
			public void ajouter(E element) {
				//TODO?????
			}

			@Override
			public void retirer() {
				throw new UnsupportedOperationException();
			}

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
