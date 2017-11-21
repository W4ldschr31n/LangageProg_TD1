package filRouge.v5;

import java.util.Iterator;
import java.util.LinkedList;

public class ImplementationEtatFileImmutable<K,E> implements EtatFileImmutable<K,E>{
    private LinkedList<E> liste;

    public ImplementationEtatFileImmutable(){
        this.liste = new LinkedList<>();
    }

    public ImplementationEtatFileImmutable(E e, ImplementationEtatFileImmutable<K,E> etat){
        liste = new LinkedList<E>();
        for(E el:etat){
            liste.add(el);
        }
        liste.add(e);
    }

    @Override
    public E premier() {
        return liste.get(0);
    }

    @Override
    public EtatFileImmutable<K, E> suivants() {
        return null;
    }

    @Override
    public int taille() {
        return liste.size();
    }

    @Override
    public Iterator<E> iterator() {
        return liste.iterator();
    }

    public String representer(){
        String s = "[";
        for(E e:liste){
            s += e+", ";
        }
        s +="]";
        return s;
    }

    @Override
    @SuppressWarnings("unchecked")
    public EtatFileImmutable<K,E> cons(E e, EtatFileImmutable<? extends EtatFileImmutable, E> etat) {
        return new ImplementationEtatFileImmutable(e, (ImplementationEtatFileImmutable) etat);
    }

    @Override
    @SuppressWarnings("unchecked")
    public EtatFileImmutable<K,E> vide() {
        return new ImplementationEtatFileImmutable();
    }
}
