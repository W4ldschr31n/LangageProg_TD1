package tp.v2;

import java.util.Iterator;

public class FileImmutableImpl<E> implements FileImmutable<E> {

    private ListeMutable<E> debut;
    private ListeMutable<E> fin;

    public FileImmutableImpl(){
        this.debut = ListeMutable.vide();
        this.fin = ListeMutable.vide();
    }

    /**
     *
     * @return le premier element de la file
     */
    @Override
    public E premier() {
        return this.debut.tete();
    }

    @Override
    public FileImmutable<E> suivants() {
        return null;
    }

    @Override
    public int taille() {
        return debut.taille();
    }

    @Override
    public FileImmutable<E> creer() {
        return null;
    }

    @Override
    public FileImmutable<E> creer(E dernier) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
