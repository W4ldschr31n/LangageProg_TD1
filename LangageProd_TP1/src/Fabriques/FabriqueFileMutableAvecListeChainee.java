package Fabriques;

import Files.FileMutableAvecListeChainee;
import Files.Interface.File;
import Files.Interface.FileMutable;

public class FabriqueFileMutableAvecListeChainee<T> implements FabriqueFileMutable<T> {

	@Override
	public FileMutableAvecListeChainee<T> creerFileVide() {
		return new FileMutableAvecListeChainee<T>();
	}

	@Override
	public FileMutableAvecListeChainee<T> creerFileElements(T[] elements) {
		FileMutableAvecListeChainee<T> file = new FileMutableAvecListeChainee<T>();
		for(T element : elements) {
			file.ajouterQueue(element);
		}
		return file;
	}


}
