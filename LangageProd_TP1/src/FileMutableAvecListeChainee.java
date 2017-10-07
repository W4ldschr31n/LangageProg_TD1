import java.util.EmptyStackException;
import java.util.LinkedList;


public class FileMutableAvecListeChainee <T> { //implements FileMutable

	private LinkedList<T> elements;
	
	public FileMutableAvecListeChainee(){
		this.elements = new LinkedList<T>();
	}
	
	public T getTete(){
		return this.elements.getFirst();
	}
	
	public T getQueue(){
		return this.elements.getLast();
	}
	
	public LinkedList<T> getElements(){
		return this.elements;
	}
	
	public void ajouterQueue(T element){
		this.elements.add(element);
	}
	
	public T enleverTete() throws EmptyStackException{
		if(this.estVide()){
			throw new EmptyStackException();
		}
		return this.elements.pop(); 
	}
	
	public boolean contient(T element){
		return this.elements.contains(element);
	}
	
	public int taille(){
		return this.elements.size();
	}
	
	public void concatener(FileMutableAvecListeChainee<T> f){
		this.elements.addAll(f.getElements());
	}
	
	public boolean estVide(){
		return this.elements.isEmpty();
	}
	
	public String toString(){
		return this.elements.toString();
	}
}
