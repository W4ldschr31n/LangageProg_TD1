package Fabriques;

import Files.Interface.File;
import Files.Interface.FileMutable;

public interface FabriqueFileMutable<T> extends FabriqueFile<T> {
	/**
	 * cree une file mutable sans aucun element
	 * @return une file mutable de T vide
	 */
	public FileMutable<T> creerFileVide();
	/**
	 * cree une file mutable et y insere des elements en conservant l'ordre d'origine
	 * @param elements un tableau contenant des T de maniere indexes
	 * @return une file mutable de T pre-remplie
	 */
	public FileMutable<T> creerFileElements(T[] elements);
}
