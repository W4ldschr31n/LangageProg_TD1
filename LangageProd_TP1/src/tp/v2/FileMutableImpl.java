package tp.v2;

import java.util.Iterator;
import java.util.LinkedList;

public class FileMutableImpl<E> implements FileMutable<E>{
	private E premier;
	private FileMutable<E> suivants;
	private int taille;
	
	public FileMutableImpl(){
		this.taille=0;
	}

	@Override
	public E premier() {
		return this.premier;
	}

//	@Override
//	public FileMutable<E> suivants() {
//		return this.suivants;
//	}

	@Override
	public int taille() {
		return this.taille;
	}

	/**
	 * Permet d'ajouter un element en queue de file
	 * @param dernierDansFile
	 * @return
	 */
	@Override
	public FileMutable<E> ajout(E dernierDansFile) {
//		Iterator it = iterator();
//		FileMutable<E> fileCourante = this;
//		while (it.hasNext()){
//			it.next();
//			fileCourante = fileCourante.suivants();
//		}
//		FileMutable<E> derniere = creer();
//		fileCourante.
		return null;
	}

	/**
	 * Retire le premier elements de la file
	 * @return
	 */
	@Override
	public FileMutable<E> retrait() {
		this.premier=suivants().premier();
		this.suivants=suivants().suivants();
		return this;
	}

	
	@Override
	public FileMutable<E> ajout(File secondeFile) {
		ajouter(secondeFile);
		return this;
	}

	@Override
	public Iterator<E> iterator() {
		LinkedList<E> it = new LinkedList<>();
		it.add(this.premier);
		FileMutable<E> suiv = this.suivants;
		while (suiv !=null){
			it.add(suiv.premier());
			suiv = suiv.suivants();
		}
		System.out.println(it.toString());
		return it.iterator();
	}

	/**
	 * Permet d'ajouter le premier element
	 * @param element
	 */
	@Override
	public void ajouter(E element) {
		this.premier=element;
	}

	/**
	 * Retire le premeir element
	 */
	@Override
	public void retirer() {
		retrait();
	}

	@Override
	public FileMutable<E> creer() {
		return new FileMutableImpl();
	}

	@Override
	public FileMutable<E> creerCopie() {
		Iterator<E> it = this.iterator();
		FileMutable<E> copie = creer();
		while (it.hasNext()){
			copie.ajout(it.next());
		}
		return copie;
	}

	@Override
	public void ajouter(File<E> secondeFile) {
		Iterator<E> it = this.iterator();
		while (it.hasNext()){
			ajout(it.next());
		}
	}
	public String toString(){
		Iterator it = iterator();
		String rep = "(";
		while (it.hasNext()){
			rep+=it.next()+",";
		}
		rep.substring(0, rep.length());
		return rep+=")";
	}

}
