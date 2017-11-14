package tp.v2;

import java.util.Iterator;

public class FileMutableImpl<E> implements FileMutable<E>{

    private ListeMutable<E> liste;
    private E fin;

    @Override
    public void ajouter(E element) {
        if(estVide()){
            liste.changerTete(element);
        }
        else{
            liste = ListeMutable.cons(fin,liste.miroir()).miroir();
            fin = element;
        }
    }

    @Override
    public void retirer() {
        if(estVide())
            throw new UnsupportedOperationException();
        fin = liste.miroir().tete();
    }

    @Override
    public E premier() {
        return null;
    }

    @Override
    public int taille() {
        return 0;
    }

    @Override
    public FileMutable<E> creer() {
        return null;
    }

    @Override
    public FileMutable<E> creerCopie() {
        return null;
    }

    @Override
    public void ajouter(File<E> secondeFile) {

    }

    @Override
    public Iterator<E> iterator() {
        return liste.iterator();
    }
}
