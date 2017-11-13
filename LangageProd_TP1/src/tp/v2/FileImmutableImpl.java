package tp.v2;

import java.util.Iterator;

public class FileImmutableImpl implements FileImmutable<E> {
    @Override
    public E premier() {
        return null;
    }

    @Override
    public FileImmutable<E> suivants() {
        return null;
    }

    @Override
    public int taille() {
        return 0;
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
