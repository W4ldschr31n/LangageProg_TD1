package tp.v2;

import java.util.Iterator;
import java.util.LinkedList;

public class FileMutableImpl<E> implements FileMutable<E>{
	private E fin;
	private ListeMutable<E> liste;

	/**
	 * Construit une File vide
	 */
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

	/**
	 *  Taille de la file
	 * @return la taille
	 */
	@Override
	public int taille() {
		return this.liste.taille();
	}

	/**
	 * Permet d'ajouter un element en queue de file
	 * @param element de type E
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
	 */
    @Override
    public void retirer() {
        if(estVide())
            throw new UnsupportedOperationException();
        this.liste = this.liste.reste();
    }

	/**
  * Permet de récupérer un itérateur de la file.
  * @return un iterateur qui va itérer sur la file
  */
	@Override
	public Iterator<E> iterator() {
		return new IterateurListe<E>(this.liste);
	}

	/**
	 * Crée une nouvelle file.
	 * @return	La file créée.
	 */
	@Override
	public FileMutable<E> creer() {
		return new FileMutableImpl();
	}

	/**
	 * Crée une copie de la file actuelle.
	 * @return	une nouvelle instance de file identique à celle-ci.
	 */
	@Override
	public FileMutable<E> creerCopie() {
		Iterator<E> it = this.iterator();
		FileMutable<E> copie = creer();
		while (it.hasNext()){
			copie.ajouter(it.next());
		}
		return copie;
	}

	/**
	* Permet d'ajouter une file en queue de file.
	* @param secondeFile la seconde file à ajouter.
	*/
	@Override
	public void ajouter(File<E> secondeFile) {
		Iterator<E> it = this.iterator();
		while (it.hasNext()){
			ajouter(it.next());
		}
	}


}
