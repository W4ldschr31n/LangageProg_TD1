package Fabriques;

import Files.Interface.File;

public interface FabriqueFile<T> {
	public File<T> creerFileVide();
	public File<T> creerFileElements(T[] elements);
}
