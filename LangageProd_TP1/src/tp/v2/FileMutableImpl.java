package tp.v2;

import java.util.Iterator;
import java.util.LinkedList;

public class FileMutableImpl<E> implements FileMutable<E>{
	private E fin;
	private ListeMutable<E> liste;

	public FileMutableImpl(){
	    this.fin = null;
	    this.liste = ListeMutable.vide();
    }


    /**
     * Retourne l'element en tete de la file
     * @return le premier element de la file
     */
	@Override
	public E premier() {
		return this.liste.tete();
	}

	@Override
	public int taille() {
		return this.liste.taille();
	}

	/**
	 * Permet d'ajouter un element en queue de file
	 * @param element
	 * @return
	 */
    @Override
    public void ajouter(E element) {

        if(estVide()){
            this.liste = ListeMutable.cons(element,this.liste);
        }
        else{
            this.liste = ListeMutable.cons(element,this.liste.miroir()).miroir();
        }
        this.fin = element;
    }

    /**
	 * Retire le premier element de la file
	 * @return
	 */
    @Override
    public void retirer() {
        if(estVide())
            throw new UnsupportedOperationException();
        this.liste = this.liste.reste();
    }


	@Override
	public Iterator<E> iterator() {
		return new IterateurListe<E>(this.liste);
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
			copie.ajouter(it.next());
		}
		return copie;
	}

	@Override
	public void ajouter(File<E> secondeFile) {
		Iterator<E> it = this.iterator();
		while (it.hasNext()){
			ajouter(it.next());
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
