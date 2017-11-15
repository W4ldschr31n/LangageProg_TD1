package tp.v2;

import java.util.Iterator;

public interface FileImmutable<E> extends File<E> {

	/*
	 * Accesseurs
	 */

	/**
	* Retourne la file d'elements qui suivent la tete de file.
	*/
	FileImmutable<E> suivants();

	/*
	 * Fabriques
	 */

	 /**
		* Fabrique une file vide.
		* @return une instance de File
		*/
	FileImmutable<E> creer();

	/**
	 * Fabrique une file avec un element en tete
	 * @return une instance de File*
	 * @param  dernier un elément de type E
	 */
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
	 * Ajoute un element a la fin de la file.
	 * @param dernierDansFile l'element a ajouter en queue de file
	 * @return la file resultant de l'ajout
	 */
	@Override
	default FileImmutable<E> ajout(E dernierDansFile) {
		return creer(dernierDansFile);
	}

	/**
	 * Enleve le premier element de la file.
	 * @return la file sans l'élément de tête
	 */
	@Override
	default FileImmutable<E> retrait() {
		return this.suivants();
	}
	// Complexité O(|secondeFile|)

	/**
	 * Ajoute tout les éléments d'une file a la file actuelle
	 * @param secondeFile un File de E
	 * @return une file concaténée
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
