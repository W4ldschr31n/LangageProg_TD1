package filRouge.v5;

public interface EtatFileImmutable<E> extends EtatFile<E> {

    @Override
    default EtatFileImmutable<E> creer() {
        return vide();
    }
    @Override
    default EtatFileImmutable<E> creer(E e) {
        return cons(e, this);
    }

    static <E> EtatFileImmutable<E> vide(){
        return new EtatFileImmutable<E>() {
            @Override
            public E premier() {
                throw new UnsupportedOperationException();
            }

            @Override
            public EtatFileImmutable<E> suivants() {
                throw new UnsupportedOperationException();
            }

            @Override
            public EtatFileImmutable<E> ajout(E dernier) {
                return cons(dernier, this);
            }

            @Override
            public EtatFileImmutable<E> retrait() {
                throw new UnsupportedOperationException();
            }
        }
    }

    static <E> EtatFileImmutable<E> cons(E dernier, EtatFileImmutable<E> reste){
        return new EtatFileImmutable<E>() {
            @Override
            public E premier() {
                return dernier;
            }

            @Override
            public EtatFile<E> suivants() {
                return reste;
            }

            @Override
            public EtatFile<E> ajout(E dernier) {
                return ();
            }

            @Override
            public EtatFile<E> retrait() {
                return null;
            }
        }
    }


}
