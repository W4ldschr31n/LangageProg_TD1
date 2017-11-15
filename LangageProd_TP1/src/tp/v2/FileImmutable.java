package tp.v2;

import java.util.Iterator;

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

	/**
	 * Crée une copie de la file actuelle.
	 * @return	une nouvelle instance de file identique à celle-ci.
	 */
	FileImmutable<E> creerCopie();

	
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
		return this.suivants();
	}
	// Complexité O(|secondeFile|)

	/**
	 *
	 * @param secondeFile
	 * @return
	 */
	@Override
	default FileImmutable<E> ajout(File<E> secondeFile){
		FileImmutable<E> r = this;
		for(E e : secondeFile){
			r = r.ajout(e);
		}
		return r;
	}

}
