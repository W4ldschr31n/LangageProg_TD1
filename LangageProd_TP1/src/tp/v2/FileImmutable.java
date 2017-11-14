package tp.v2;

public interface FileImmutable<E> extends File<E> {

	/* 
	 * Accesseurs
	 */
	FileImmutable<E> suivants();
	
	/*
	 * Fabriques
	 */
	FileImmutable<E> creer();
	FileImmutable<E> creer(E dernier);
	
	/*
	 * Services
	 */

	/**
	 * Ajoute un element a la fin de la file
	 * @param dernierDansFile l'element a ajouter
	 * @return la file correspondant
	 */
	@Override
	default FileImmutable<E> ajout(E dernierDansFile) {
		return creer(dernierDansFile);
	}

	/**
	 * Enleve le premier element de la file
	 * @return
	 */
	@Override
	default FileImmutable<E> retrait() {
		return suivants().retrait();
	}
	// Complexité O(|secondeFile|)
	@Override
	default FileImmutable<E> ajout(File<E> secondeFile){
		FileImmutable<E> r = this;
		for(E e : secondeFile){
			r = r.ajout(e);
		}
		return r;
	}

}
