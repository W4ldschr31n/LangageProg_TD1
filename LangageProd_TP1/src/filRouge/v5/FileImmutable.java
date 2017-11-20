package filRouge.v5;

public interface FileImmutable<E> extends
        File<FileImmutable<E>, E>,
        IdentifiableParIteration<FileImmutable<?>, E>,
        RepresentableParIteration<E> {

	/*
	 * Fabriques
	 */

    /*@Override
    default FileImmutable<E> creer() {
        return vide();
    }*/

    FileImmutable<E> creer(E e); // Fabrique d'une file formee de la file cible et
    // d'un nouveau dernier element

	/*
	 * Services
	 */
    @Override
    default FileImmutable<E> retrait(){
        return suivants();
    }

    @Override
    default FileImmutable<E> ajout(E dernier){
        return creer(dernier);
    }
}

    /*
     * Fabriques statiques.
     *//*
    public static <E> FileImmutable<E> vide() {
        return new FileImmutable<E>() {

            @Override
            public boolean equals(Object obj){
                if(!(obj instanceof FileImmutable<?>))
                    return false;
                FileImmutable<?> l = (FileImmutable<?>)obj;
                return this.estEgal(l);
            }
            @Override
            public String toString() {
                return this.representation();
            }
        };
    }

    public static <E> FileImmutable<E> cons(E t, FileImmutable<E> r) {
        return new FileImmutable<E>() {
            private FileImmutable<E> reste = r;
            private int taille = r.taille() + 1;
            public E tete() {
                return t;
            }
            public FileImmutable<E> reste() {
                return this.reste;
            }
            @Override
            public int taille() {
                return this.taille;
            }
            @Override
            public boolean equals(Object obj){
                if(!(obj instanceof FileImmutable<?>))
                    return false;
                FileImmutable<?> l = (FileImmutable<?>)obj;
                return this.estEgal(l);
            }
            @Override
            public String toString() {
                return this.representation();
            }
        };
    }


}
*/