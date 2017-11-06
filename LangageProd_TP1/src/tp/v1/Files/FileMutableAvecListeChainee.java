package tp.v1.Files;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import tp.v1.Fabriques.FabriqueFileMutableAvecListeChainee;
import tp.v1.Files.Interface.File;
import tp.v1.Files.Interface.FileMutable;


public class FileMutableAvecListeChainee <T> implements FileMutable<T> { //implements FileMutable

	private LinkedList<T> elements;
	
	/**
	 * Constructeur d'une file avec une liste chainee
	 * initialise l'attribut elements qui est une liste chainee
	 *
	 */
	public FileMutableAvecListeChainee(){
		this.elements = new LinkedList<T>();
	}
	
	/**
	 * Methode qui renvoie le premier element de la file
	 * 
	 * @exception NoSuchElementException si la file est vide
	 * @return      le premier element de la liste chainee
	 */
	public T getTete() throws NoSuchElementException{
		if (this.estVide()){
			throw new NoSuchElementException();
		}
		return this.elements.getFirst();
	}
	
	/**
	 * Methode qui renvoie le dernier element de la file
	 * 
	 * @exception NoSuchElementException si la file est vide
	 * @return      le dernier element de la liste chainee
	 */
	public T getQueue() throws NoSuchElementException{
		if (this.estVide()){
			throw new NoSuchElementException();
		}
		return this.elements.getLast();
	}
	
	/**
	 * Methode qui renvoie la liste chainee qui compose la file
	 * 
	 * @return      l'attribut elements qui correspond a la liste chainee
	 */
	public T[] getElements(){
		return (T[]) this.elements.toArray();	}

	/**
	 * Ajoute un element du meme type que les elements de la file en bout de file
	 * 
	 * @param  element  Un element de type T
	 * @return la liste après tentative d'insertion
	 */
	public FileMutableAvecListeChainee<T> ajouterQueue(T element){
		this.elements.add(element);
		return this;
	}
	
	/**
	 * Renvoie le premier element de la file et le supprime apres de la file
	 *
	 * @return  Un element de type T
	 */
	public T enleverTete() throws EmptyStackException{
		if(this.estVide()){
			throw new EmptyStackException();
		}
		return this.elements.pop(); 
	}


    /**
	 * Retourne un booleen pour indique si un element se trouve dans la file ou non.
	 * Renvoie "True" si la file contient l'element sinon renvoie "False"
	 *
	 * @param  element  Un element de type T
	 * @return      un booleen (true si l'element est contenu dans la liste sinon false)
	 */
	public boolean contient(T element){
		return this.elements.contains(element);
	}
	
	/**
	 * Renvoie la taille de la file (nombre d'elements)
	 *
	 * @return      un entier correspondant au nombre d'elements de la file
	 */
	public int taille(){
		return this.elements.size();
	}

	/**
	 * Concatene une file avec une autre dont les elements sont du meme type
	 *
	 * @param      f 	une file
	 * @return la file obtenue après operation
	 */
	public FileMutableAvecListeChainee<T> concatener(File f){
	    T[] elementF = (T[]) f.getElements();
        for (int i = 0; i <  elementF.length ; i++) {
            this.elements.add(elementF[i]);
        }
        return this;

	}
	
	/**
	 * Methode qui indique si la file ne contient aucun element
	 *
	 * @return      un booleen (true si la file est vide sinon false)
	 */
	public boolean estVide(){
		return this.elements.isEmpty();
	}
	
	public String toString(){
		return this.elements.toString();
	}
	
	public boolean equals(Object o) {
		if(o instanceof FileMutableAvecListeChainee) {
			FileMutableAvecListeChainee autre = (FileMutableAvecListeChainee) o;
			if(autre.taille()!=this.taille())
				return false;
			FabriqueFileMutableAvecListeChainee<T> fab = new FabriqueFileMutableAvecListeChainee();
			FileMutableAvecListeChainee<T> copie = fab.creerFileElements(this.getElements());
			boolean flag = false;
			while(!copie.estVide()) {
				if(!copie.enleverTete().equals(autre.enleverTete())) {
					flag = true;
					break;
				}
			}
			return !flag;
		}else
			return false;
	}



}
