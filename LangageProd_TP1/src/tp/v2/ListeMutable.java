package tp.v2;

import java.util.LinkedList;

public interface ListeMutable<E> extends Liste<E>{

	/*
	 * Accesseurs.
	 */
	/**
	 * Retourne le reste des �l�ments de la liste.
	 */
	default ListeMutable<E> reste() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Change le reste des �l�ments de la liste (qui suivent la t�te).
	 * @param reste la liste des nouveaux �l�ments � changer.
	 */
	default void changerReste(ListeMutable<E> reste) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Change la t�te de liste.
	 * @param tete la nouvelle t�te � changer
	 */
	default void changerTete(E tete) {
		throw new UnsupportedOperationException();
	}

	/*
	 * Services
	 */
	/**
	 * Inverse la liste (le premier �l�ment devient le dernier et vice versa).
	 * @return la liste invers�e.
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
	 * Ajoute un �l�ment en d�but de liste
	 * @param t un �l�ment � ajouter
	 * @param r la liste � laquelle on ajoute l'�l�ment au d�but
	 * @return la liste avec l'�l�ment ajout� au d�but.
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
	 * @return la liste vid�e.
	 */
	public static <E> ListeMutable<E> vide() {
		return new ListeMutable<E>() {
			// TODO Définir les méthodes utiles.						
		};
	}
	
}
