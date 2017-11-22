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
            this.debut = (ListeMutable) fin.miroir();
            this.fin = ListeMutable.vide();
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
    public EnveloppeListeMutableDoubleAcces<E> creer() {
        return new EnveloppeListeMutableDoubleAcces<>();
    }

    public EnveloppeListeMutableDoubleAcces<E> creer(E dernier) {
        return new EnveloppeListeMutableDoubleAcces<E>(this.debut,ListeMutable.cons(dernier,this.fin));
    }

    @Override
    public EnveloppeListeMutableDoubleAcces<E> suivants() {
        return new EnveloppeListeMutableDoubleAcces<E>(debut.reste(),fin);
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

    @Override
    public String toString() {
        return representation();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof EnveloppeListeMutableDoubleAcces) {
            estEgal((EtatFileMutable<EnveloppeListeMutableDoubleAcces<E>, E>) obj);
        }
        return false;
    }

}
