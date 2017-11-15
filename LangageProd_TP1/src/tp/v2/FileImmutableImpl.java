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

    @Override
    public FileImmutable<E> creerCopie() {
        Iterator<E> it = this.iterator();
        FileImmutable<E> copie = creer();
        while (it.hasNext()){
            copie = copie.ajout(it.next());
        }
        return copie;
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
     * Ajoute un élément a la fin de la liste
     * @param dernier
     * @return liste avec un element en plus
     */
    @Override
    public FileImmutable<E> creer(E dernier) {
        return new FileImmutableImpl<E>(Liste.cons(dernier,this.debut.miroir()).miroir(),Liste.cons(dernier,this.fin));
    }


    @Override
    public Iterator<E> iterator() {
        return new IterateurListe<E>(this.debut);
    }


}
