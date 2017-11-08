package tp.v2;

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
		LinkedList<E> liste = new LinkedList<>();
		for (E element: this){
			liste.add(element);
		}
		vide();// on vide la ListeMutable
		for (int i=liste.size()-1;i>=0;i--){
			cons(liste.get(i), this);// on ajoute en tete les elements en partant de la fin de la liste
		}
		return this;
		
	}

	/**
	 * Ajoute un élément en début de liste
	 * @param t un élément à ajouter
	 * @param r la liste à laquelle on ajoute l'élément au début
	 * @return la liste avec l'élément ajouté au début.
	 */
	public static <E> ListeMutable<E> cons(E t, ListeMutable<E> r){
		return new ListeMutable<E>() {
			@Override
			public void changerTete(E tete) {
				ListeMutable.super.changerTete(t);
			}
			@Override
			public void changerReste(ListeMutable<E> r){
				ListeMutable.super.changerReste(r);
			}
			
		};
	}
	
	/**
	 * Vide la liste.
	 * @return la liste vidée.
	 */
	public static <E> ListeMutable<E> vide() {
		return new ListeMutable<E>() {
			// TODO DÃ©finir les mÃ©thodes utiles.						
		};
	}
	
}
