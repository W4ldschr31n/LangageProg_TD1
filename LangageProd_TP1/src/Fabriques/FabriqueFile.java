package Fabriques;

import Files.Interface.File;

public interface FabriqueFile<T> {
	/**
	 * cree une file sans aucun element
	 * @return une file de T vide
	 */
	public File<T> creerFileVide();
	/**
	 * cree une file et y insere des elements en conservant l'ordre d'origine
	 * @param elements un tableau contenant des T de maniere indexes
	 * @return une file de T pre-remplie
	 */
	public File<T> creerFileElements(T[] elements);
}
