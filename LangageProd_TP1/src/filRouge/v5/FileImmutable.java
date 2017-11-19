package filRouge.v5;

public interface FileImmutable<E> extends
        File<FileImmutable<E>, E>,
        IdentifiableParIteration<FileImmutable<?>, E>,
        RepresentableParIteration<E>
{

	/*
	 * Accesseurs.
	 */
	/*
	 * Fabriques
	 */

    @Override
    default FileImmutable<E> creer() {
        return vide();
    }
    @Override
    default FileImmutable<E> creer(E e) {
        return cons(e, this);
    }

	/*
	 * Services
	 */


    /*
     * Fabriques statiques.
     */
    public static <E> FileImmutable<E> vide() {
        return new FileImmutable<E>() {
            @Override
            public boolean casVide(){
                return true;
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

    public static <E> FileImmutable<E> cons(E t, FileImmutable<E> r) {
        return new FileImmutable<E>() {
            private FileImmutable<E> reste = r;
            private int taille = r.taille() + 1;
            @Override
            public boolean casCons(){
                return true;
            }
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
