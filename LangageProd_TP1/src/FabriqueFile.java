
public interface FabriqueFile<T> {
	public File<T> FabriqueFileVide();
	public File<T> FabriqueFileElements(File[] files);
	public File<T> FabriqueFileJSP();
}
