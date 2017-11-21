package filRouge.v5;

import java.util.Iterator;

public interface FileParListeMutable<E> {


	/*
	 * Accesseurs.
	 */

	E premier();
	FileParListeMutable<E> suivants();
	int taille();
	boolean estVide();

	/*
	 * Fabriques.
	 */

	FileParListeMutable<E> creer();
	FileParListeMutable<E> creer(E dernierElement);

    /**
	 * Services
	 */
	void ajouter(E element);
	void retirer();
	void ajouter(FileParListeMutable<E> secondeFile);
	FileParListeMutable<E> miroir();

	static <E> FileParListeMutable<E> cons(){
		return new FileParListeMutable<E>() {
			private FileParListeMutable<E> suivants = cons();
			private E premier;
			private int taille = 0;

			@Override
			public void ajouter(E element) {
				if(!suivants.estVide()){
					suivants.ajouter(premier);
				}else{
					premier = element;
				}
				taille++;
			}

			@Override
			public void retirer() {
				if(estVide()){
					throw new UnsupportedOperationException();
				}else{
					premier = suivants.premier();
					if(!suivants.estVide())
						suivants = suivants.suivants();

				}
			}

			@Override
			public void ajouter(FileParListeMutable<E> secondeFile) {
				/*for(E element : secondeFile){
					ajouter(element);
				}*/
			}

			@Override
			public FileParListeMutable<E> miroir() {
				/*FileParListeMutable<E> miroir = creer();
				for(E element : miroir){
					miroir.creer(e);
				}*/
				return null;
			}

			@Override
			public E premier() {
				return premier;
			}

			@Override
			public FileParListeMutable<E> suivants() {
				return suivants;
			}

			@Override
			public int taille() {
				return taille;
			}

			@Override
			public boolean estVide() {
				return taille()==0;
			}

			@Override
			public FileParListeMutable<E> creer() {
				return cons();
			}

			@Override
			public FileParListeMutable<E> creer(E dernierElement) {
				FileParListeMutable<E> nouveau = cons();
				nouveau.ajouter(dernierElement);
				return nouveau;
			}
		};
	}
}