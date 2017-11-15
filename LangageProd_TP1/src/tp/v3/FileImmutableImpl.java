package tp.v3;


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
  	 * Crée une copie de la file actuelle.
  	 * @return	une nouvelle instance de file identique à celle-ci.
  	 */
    @Override
    public FileImmutable<E> creerCopie() {
        Iterator<E> it = this.iterator();
        FileImmutable<E> copie = creer();
        while (it.hasNext()){
            copie = (FileImmutable<E>) copie.ajout(it.next());
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

    /**
  	 * Fabrique une file avec un element en tete
  	 * @return une instance de File
  	 */
    @Override
    public FileImmutable<E> creer() {
        return new FileImmutableImpl<>();
    }

    /**
     * Ajoute un élément a la fin de la liste
     * @param dernier nouvel élément de type E
     * @return liste avec un element en plus
     */
    @Override
    public FileImmutable<E> creer(E dernier) {
        return new FileImmutableImpl<E>(Liste.cons(dernier,this.debut.miroir()).miroir(),Liste.cons(dernier,this.fin));
    }

    /**
    * Permet de récupérer un itérateur de la file.
    * @return un iterateur qui va itérer sur la file
    */
    @Override
    public Iterator<E> iterator() {
        return new IterateurListe<E>(this.debut);
    }


}
