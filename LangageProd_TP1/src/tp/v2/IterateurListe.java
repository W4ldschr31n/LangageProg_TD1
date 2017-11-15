package tp.v2;

import java.util.Iterator;

public class IterateurListe<E> implements Iterator<E> {
	private Liste courant;

	/**
	* Crée un itérateur sur une liste.
	* @param liste la liste sur laquelle on va itérer
	*/
	public IterateurListe(Liste<E> liste){
		this.courant = liste;
	}

	/**
	* Méthode qui permet de savoir si l'itérateur peut encore itérer
	* @return Renvoie un booléen (true) si l'élément n'est pas vide sinon (false)
	*/
	@Override
	public boolean hasNext() {
		return !courant.casVide();
	}

	/**
	* Renvoie l'élément courant.
	* @return l'élement courant de l'itérateur
	*/
	@Override
	public E next() {
		E tete = (E)courant.tete();
		this.courant = this.courant.reste();
		return tete;
	}

}
