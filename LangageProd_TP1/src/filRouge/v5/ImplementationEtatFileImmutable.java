package filRouge.v5;

import java.util.Iterator;
import java.util.LinkedList;

public class ImplementationEtatFileImmutable<K,E> implements EtatFileImmutable<K,E>{
    private ListeImmutable<E> liste;

    public ImplementationEtatFileImmutable(){
        this.liste = ListeImmutable.vide();
    }

    public ImplementationEtatFileImmutable(E e, ImplementationEtatFileImmutable<K,E> etat){
        liste = ListeImmutable.vide();
        for(E el:etat){
        	liste = ListeImmutable.cons(el, liste);
        }
        liste = ListeImmutable.cons(e, liste);
        liste = liste.miroir();
    }

    @Override
    public E premier() {
        return liste.tete();
    }

    @Override
    public EtatFileImmutable<K, E> suivants() {
    	ImplementationEtatFileImmutable<K,E> suivants = new ImplementationEtatFileImmutable<>();
    	Iterator<E> it = this.iterator();
    	if (this.estVide()){
    		throw new UnsupportedOperationException();
    	}
    	else{
    		it.next();
    		while (it.hasNext()){
    			suivants = new ImplementationEtatFileImmutable<>(it.next(),suivants);
    		}
    		return suivants;
    	}
    }

    @Override
    public int taille() {
        return liste.taille();
    }

    @Override
    public Iterator<E> iterator() {
        return liste.iterator();
    }

    public String representer(){
       return liste.representation();
    }
    
    @Override
    public boolean estVide(){
    	return liste.casVide();
    }

//    @Override
//    @SuppressWarnings("unchecked")
//    public EtatFileImmutable<K,E> cons(E e, EtatFileImmutable<? extends EtatFileImmutable, E> etat) {
//        return new ImplementationEtatFileImmutable(e, (ImplementationEtatFileImmutable) etat);
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public EtatFileImmutable<K,E> vide() {
//        return new ImplementationEtatFileImmutable<>();
//    }

}
