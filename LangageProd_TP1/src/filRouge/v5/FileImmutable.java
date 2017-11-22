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
    static <E> FileImmutable<E> creerAvecEtat(EtatFile etatFile){
        return new FileImmutable<E>() {
            private EtatFile<? extends EtatFile, E> etat = etatFile;

            @Override
            public String typeEtat() {
                return this.etat.getClass().toString();
            }

            @Override
            @SuppressWarnings("unchecked")
            public FileImmutable<E> creer(E e) {
                return  creerAvecEtat(etat.ajouter(e));
            }

            @Override
            public E premier() {
                return etat.premier();
            }

            @Override
            public FileImmutable<E> suivants() {
                return creerAvecEtat(etat.suivants());
            }

            @Override
            @SuppressWarnings("unchecked")
            public FileImmutable<E> creer() {
                return creerAvecEtat(EtatFileMutable.vide());
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
