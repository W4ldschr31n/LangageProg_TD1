package tp.v2;

public interface File<E> extends Iterable<E> {

	/**
	 * Accesseur premier élément
	 * @return premier élément de la file
	 */
	E premier();
	/**
	 * Accesseur suivants
	 * @return file des éléments suivants
	 */
	File<E> suivants();

	/**
	 * Asserte si la file est vide
	 * @return true si la file est vide
	 */
	default boolean estVide() {
		return this.taille() == 0;
	}

	/**
	 * Retourne la Taille
	 * @return
	 */
	int taille();

	/**
	 * Fabrique
	 * @return une instance de File
	 */
	File<E> creer();

	/**
	 * Ajoute un élément a la queue de la file
	 * @param dernierDansFile
	 * @return la file qui résulte de l'ajout
	 */
	File<E> ajout(E dernierDansFile);

	/**
	 * Supprime l'élément de tête
	 * @return la file qui résulte du retrait
	 */
	File<E> retrait();

	/**
	 * Ajoute en queue une file d'éléments
	 * @param secondeFile
	 * @return la file résultant de l'ajout
	 */
	File<E> ajout(File<E> secondeFile);
	
	default String representation() {
		String representation = "[/]";
		if(!estVide()){
			representation = "["+premier().toString()+"]"+suivants().representation();
		}
		return representation;
	}

	/**
	 * Compare l'égalitée de deux file
	 * Pré cond: Les éléments de type E doivent définir une méthode equals  qui ait du sens
	 * @param file
	 * @return
	 */
	default boolean estEgal(File<E> file){
		return premier().equals(file.premier()) && suivants().estEgal(file.suivants());
	}


	
	
}