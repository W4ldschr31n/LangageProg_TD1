package filRouge.v5;

import java.util.Iterator;

public interface FileImmutable<E> extends
        File<FileImmutable<E>, E>,
        IdentifiableParIteration<FileImmutable<?>, E>,
        RepresentableParIteration<E> {

	/*
	 * Fabriques
	 */


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

    /*
     * Fabriques statiques.
     */
    static <E> FileImmutable<E> creerAvecEtatMutable(EtatFileMutable<EtatFileMutable, E> etatFile){
        return new FileImmutable<E>() {
            private EtatFileMutable<EtatFileMutable, E> etat = etatFile;

            @Override
            @SuppressWarnings("unchecked")
            public FileImmutable<E> creer(E e) {
                return  creerAvecEtatMutable(EtatFileMutable.creerCons(e, etat));
            }

            @Override
            public E premier() {
                return etat.premier();
            }

            @Override
            public FileImmutable<E> suivants() {
                return creerAvecEtatMutable(etat.suivants());
            }

            @Override
            @SuppressWarnings("unchecked")
            public FileImmutable<E> creer() {
                return creerAvecEtatMutable(EtatFileMutable.creerVide());
            }

            @Override
            public int taille() {
                return etat.taille();
            }

            @Override
            public Iterator<E> iterator() {
                return etat.iterator();
            }

            public String toString(){
                return etat.toString();
            }
        };
    }

    static <E> FileImmutable<E> creerAvecEtatImmutable(EtatFileImmutable<? extends EtatFileImmutable, E> etatFile){
        return new FileImmutable<E>() {
            private EtatFileImmutable<? extends EtatFileImmutable, E> etat = etatFile;

            @Override
            @SuppressWarnings("unchecked")
            public FileImmutable<E> creer(E e) {
                return  creerAvecEtatImmutable(etat.cons(e, etat));
            }

            @Override
            public E premier() {
                return etat.premier();
            }

            @Override
            public FileImmutable<E> suivants() {
                return creerAvecEtatImmutable(etat.suivants());
            }

            @Override
            @SuppressWarnings("unchecked")
            public FileImmutable<E> creer() {
                return creerAvecEtatImmutable(etat.vide());
            }

            @Override
            public int taille() {
                return etat.taille();
            }

            @Override
            public Iterator<E> iterator() {
                return etat.iterator();
            }

            public String toString(){
                return etat.toString();
            }
        };
    }


}
