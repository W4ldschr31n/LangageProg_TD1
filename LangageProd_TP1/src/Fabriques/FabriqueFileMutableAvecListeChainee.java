package Fabriques;

public class FabriqueFileMutableAvecListeChainee<T> implements FabriqueFileMutable<T> {

	@Override
	public File<T> FabriqueFileVide() {
		FileMutable<T> file = new FileMutable<T>();
	}

	@Override
	public File<T> FabriqueFileElements(File<T>[] files) {
		FileMutable<T> file = new FileMutable<T>();
		for(File<T> f : files) {
			file.concatener(f);
		}
		return file;
	}

	@Override
	public File<T> FabriqueFileJSP() {
		// TODO Auto-generated method stub
		return null;
	}

}
