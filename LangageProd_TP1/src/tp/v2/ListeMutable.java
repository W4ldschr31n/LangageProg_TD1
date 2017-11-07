	package tp.v2;

import java.util.LinkedList;

public interface ListeMutable<E> extends Liste<E>{

	/*
	 * Accesseurs.
	 */
	default ListeMutable<E> reste() {
		throw new UnsupportedOperationException();
	}
	
	default void changerReste(ListeMutable<E> reste) {
		throw new UnsupportedOperationException();
	}
	
	default void changerTete(E tete) {
		throw new UnsupportedOperationException();
	}

	/*
	 * Services
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
	
	public static <E> ListeMutable<E> vide() {
		return new ListeMutable<E>() {
			// TODO Définir les méthodes utiles.						
		};
	}
	
}
