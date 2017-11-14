package tp.v2;

import java.util.Iterator;

public class FileImmutableImpl<E> implements FileImmutable<E> {

    private Liste<E> debut;
    private Liste<E> fin;

    /**
     * Construit une File vide
     */
    public FileImmutableImpl(){
        this.debut = Liste.vide();
        this.fin = Liste.vide();
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
        //Liste reste = this.fin.reste().miroir().reste().miroir();
        if(!this.debut.casVide()){
            return new FileImmutableImpl<E>(this.debut.reste(),this.debut.reste().miroir());
        }
        else{
            return creer();
        }


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

    /* TODO a supprimer si on trouve comment faire ajout dans l' interface*/
    @Override
    public FileImmutable<E> ajout(E dernierDansFile) {
        if( this.suivants().estVide()){
            return  new FileImmutableImpl<>( (Liste.cons(dernierDansFile,debut.miroir())).miroir(),Liste.cons(dernierDansFile,this.fin));
        }
        else {
            //TODO problème ici la tete se fait ecraser
            FileImmutable ret = creer();
            ret.ajout(this.debut.tete());
            return ret.ajout(this.suivants().ajout(dernierDansFile));
        }

    }
}
