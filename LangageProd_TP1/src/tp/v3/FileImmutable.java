package tp.v3;

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
	 * Enleve le premier element de la file.
	 * @return la file sans l'élément de tête
	 */
	@Override
	default FileImmutable<E> retrait() {
		return this.suivants();
	}


}
