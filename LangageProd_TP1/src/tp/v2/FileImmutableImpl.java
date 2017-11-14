package tp.v2;

import java.util.Iterator;

public class FileImmutableImpl<E> implements FileImmutable<E> {

    private Liste<E> debut;
    private Liste<E> fin;

    /**
     * Construit une File vide
     */
    public FileImmutableImpl(){
        this.debut = ListeMutable.vide();
        this.fin = ListeMutable.vide();
    }

    /**
     * Construit une File deja pleine
     * @param debut
     * @param fin
     */
    private FileImmutableImpl(Liste debut, Liste fin){
        this.debut =debut;
        this.fin = fin;
    }

    /**
     *
     * @return le premier element de la file
     */
    @Override
    public E premier() {
        return this.debut.tete();
    }

    /**
     * Retourne les éléments qui suives
     * @return une file contenqnt les éléments suivants
     */
    @Override
    public FileImmutable<E> suivants() {
        Liste reste = this.fin.reste().miroir().reste().miroir();
        return new FileImmutableImpl<E>(this.debut.reste(),reste);
    }

    /**
     *  Taille de la file
     * @return la taille
     */
    @Override
    public int taille() {
        return debut.taille();
    }


    @Override
    public FileImmutable<E> creer() {
        return new FileImmutableImpl<>();
    }

    /**
     * Crée un liste content un élément
     * @param dernier
     * @return
     */
    @Override
    public FileImmutable<E> creer(E dernier) {
       return  new FileImmutableImpl<>(Liste.cons(dernier,Liste.vide()),Liste.cons(dernier,Liste.vide()));
    }


    @Override
    public Iterator<E> iterator() {
        return new IterateurListe<E>(this.debut);
    }

    /* TODO a supprimer li on trouve comment faire ajout dans l' interface*/
    @Override
    public FileImmutable<E> ajout(E dernierDansFile) {
        if( this.suivants().estVide()){
            return  new FileImmutableImpl<>(Liste.cons(dernierDansFile,this.fin).miroir(),Liste.cons(dernierDansFile,this.fin));
        }
        else {
            return this.suivants().ajout(dernierDansFile);
        }

    }
}
