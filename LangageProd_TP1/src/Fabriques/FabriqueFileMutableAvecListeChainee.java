package Fabriques;

import Files.FileMutableAvecListeChainee;
import Files.Interface.File;
import Files.Interface.FileMutable;

public class FabriqueFileMutableAvecListeChainee<T> implements FabriqueFileMutable<T> {

	/**
	 * cree une file mutable utilisant une liste chainee sans aucun element
	 * @return une file mutable de T vide
	 */
	@Override
	public FileMutableAvecListeChainee<T> creerFileVide() {
		return new FileMutableAvecListeChainee<T>();
	}

	/**
	 * cree une file mutable utilisant une liste chainee et y insere des elements en conservant l'ordre d'origine
	 * @param elements un tableau contenant des T de maniere indexes
	 * @return une file mutable utilisant une liste chainee de T pre-remplie
	 */
	@Override
	public FileMutableAvecListeChainee<T> creerFileElements(T[] elements) {
		FileMutableAvecListeChainee<T> file = new FileMutableAvecListeChainee<T>();
		for(T element : elements) {
			file.ajouterQueue(element);
		}
		return file;
	}
}
