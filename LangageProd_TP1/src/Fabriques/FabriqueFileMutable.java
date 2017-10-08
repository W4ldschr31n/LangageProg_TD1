package Fabriques;

import Files.Interface.File;
import Files.Interface.FileMutable;

public interface FabriqueFileMutable<T> extends FabriqueFile<T> {
	public FileMutable<T> FabriqueFileVide();
	public FileMutable<T> FabriqueFileElements(T[] elements);
}
