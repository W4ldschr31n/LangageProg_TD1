package Fabriques;

import Files.Interface.File;

public interface FabriqueFile<T> {
	public File<T> FabriqueFileVide();
	public File<T> FabriqueFileElements(T[] elements);
}
