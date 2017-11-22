package filRouge.v5;

import java.util.Iterator;

public class EnveloppeListeMutableDoubleAcces<E> implements EtatFileMutable<EnveloppeListeMutableDoubleAcces<E>,E> {
    private ListeMutable<E> debut;
    private ListeMutable<E> fin;

    public EnveloppeListeMutableDoubleAcces(){
        this.debut = ListeMutable.vide();
        this.fin = ListeMutable.vide();
    }
    public EnveloppeListeMutableDoubleAcces(ListeMutable debut, ListeMutable fin){
        if(debut.estVide()){
            debut = (ListeMutable) fin.miroir();
            fin = ListeMutable.vide();
        }else {
            this.debut = debut;
            this.fin = fin;
        }


    }

    @Override
    public E premier() {
        return this.debut.tete();
    }

    @Override
    public EtatFileMutable<EnveloppeListeMutableDoubleAcces<E>, E> suivants() {
        return new EnveloppeListeMutableDoubleAcces(debut.reste(),fin);
    }

    @Override
    public int taille() {
        return debut.taille()+fin.taille();
    }

    @Override
    public Iterator<E> iterator() {
        ListeMutable<E> concatener = debut;
        for (E el: fin.miroir() ) {
            concatener = concatener.creer(el);
        }
        return concatener.iterator();
    }
}
