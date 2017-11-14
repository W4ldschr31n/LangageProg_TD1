package tp.v2;

import java.util.Iterator;
import java.util.LinkedList;

public interface ListeMutable<E> extends Liste<E>{

	/*
	 * Accesseurs.
	 */
	/**
	 * Retourne le reste des éléments de la liste.
	 */
	default ListeMutable<E> reste() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Change le reste des éléments de la liste (qui suivent la tête).
	 * @param reste la liste des nouveaux éléments à changer.
	 */
	default void changerReste(ListeMutable<E> reste) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Change la tête de liste.
	 * @param tete la nouvelle tête à changer
	 */
	default void changerTete(E tete) {
		throw new UnsupportedOperationException();
	}

	/*
	 * Services
	 */
	/**
	 * Inverse la liste (le premier élément devient le dernier et vice versa).
	 * @return la liste inversée.
	 */
	default ListeMutable<E> miroir(){
		Iterator<E> it = this.iterator();
		ListeMutable<E> miroir = ListeMutable.vide();
		while(it.hasNext()){

			miroir = ListeMutable.cons(it.next(), miroir);
		}
		return miroir;

	}

	/**
	 * Ajoute un élément en début de liste
	 * @param t un élément à ajouter
	 * @param r la liste à laquelle on ajoute l'élément au début
	 * @return la liste avec l'élément ajouté au début.
	 */
	public static <E> ListeMutable<E> cons(E t, ListeMutable<E> r){
		return new ListeMutable<E>() {
			private E tete = t;
			private ListeMutable<E> reste=r;
			
			@Override
			public void changerTete(E tete) {
				this.tete=tete;
			}
			@Override
			public void changerReste(ListeMutable<E> r){
				this.reste = ListeMutable.vide();
				//permet d'ajouter en reste le m�me objet
				//parce que sinon �a bug vu qu'on modifie
				//en m�me temps la m�me instance
				ListeMutable listeTmp = r.miroir();
				IterateurListe<E> it = new IterateurListe<>(listeTmp);
				while(it.hasNext()){
					this.reste = ListeMutable.cons((E) it.next(), this.reste);
				}
				
			}

			@Override
			public E tete(){
				return this.tete;
			}
			@Override
			public ListeMutable<E> reste(){
				return this.reste;
			}
			@Override 
			public boolean casCons(){
				return true;
			}
			@Override 
			public boolean casVide(){
				return false;
			}
			@Override
			public int taille(){
				return 1+this.reste.taille();
			}
			
		};
	}
	
	/**
	 * Vide la liste.
	 * @return la liste vidée.
	 */
	public static <E> ListeMutable<E> vide() {
		return new ListeMutable<E>() {
			private E tete;
			private ListeMutable<E> reste;
			@Override
			public void changerTete(E tete) {
				this.tete=tete;
			}
			@Override
			public void changerReste(ListeMutable<E> r){
				this.reste=r;
			}
			@Override
			public ListeMutable<E> reste(){
				return this.reste;
			}
			@Override 
			public boolean casCons(){
				return false;
			}
			@Override 
			public boolean casVide(){
				return true;
			}
		};
	}
	
}
