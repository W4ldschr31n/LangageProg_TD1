package filRouge.v6;

import filRouge.v5.ListeImmutable;

import java.util.Iterator;

public interface EtatImmutableAvecInversionParesseuse<E> extends EtatFileImmutable<E> {

    @Override
    default E premier(){
        throw new UnsupportedOperationException();
    }

    @Override
    default EtatFileImmutable<E> suivants() {
        throw new UnsupportedOperationException();
    }

    @Override
    default EtatFileImmutable<E> creer() {
        return vide();
    }

    @Override
    default Iterator<E> iterator() {
        return new IterateurEtatFileImmutable<>(null);
    }

    static <E> EtatImmutableAvecInversionParesseuse<E> vide(){
        return new EtatImmutableAvecInversionParesseuse<E>() {

            @Override
            public EtatFileImmutable<E> creer(E dernier) {
                return cons(ListeImmutable.<E>vide().creer(dernier), new EtatEnveloppeDeuxListesImmutables(), ListeImmutable.vide());
            }

            @Override
            public int taille() {
                return 0;
            }

            public String toString(){
                return "file vide";
            }

        };
    }

    static <E> EtatImmutableAvecInversionParesseuse<E> cons(ListeImmutable<E> ld, EtatFileImmutable<Miroir<E>> fm, ListeImmutable<E> lf){
        return new EtatImmutableAvecInversionParesseuse<E>() {
            private ListeImmutable<E> _ld = ld; // taille >0
            private EtatFileImmutable<Miroir<E>> _fm = fm; // pour tout miroir, non vide
            private ListeImmutable<E> _lf = lf; // taille(ld) + taille(fm) > taille(lf)
            {
                //INVARIANT
                while(!(_fm.taille()+_ld.taille()>_lf.taille())){
                    //System.out.println("taille ld : "+_ld.taille()+"\ttaille fm : "+_fm.taille()+"\ttaille lf : "+_lf.taille());
                    _fm = fm.creer(new Miroir<>(lf));
                    _lf = ListeImmutable.vide();
                }
                while(_ld.estVide()){
                    _ld = fm.premier().miroir();
                    _fm = fm.suivants();
                }
            }

            @Override
            public EtatFileImmutable<E> creer(E dernier) {
                return cons(_ld, _fm, _lf.creer(dernier));
            }

            @Override
            public int taille() {
                return _ld.taille()+_fm.taille()+_lf.taille();
            }

            @Override
            public E premier() {
                return _ld.tete();
            }

            @Override
            public EtatFileImmutable<E> suivants() {
                return cons((_ld.taille()>1 ? _ld.reste() : _ld.creer()), _fm, _lf) ;
            }

            @Override
            public Iterator<E> iterator() {
                return new IterateurEtatFileImmutable<>(this);
                //return null;
            }

            public String toString(){
                System.out.println("taille ld : "+_ld.taille()+"\ttaille fm : "+_fm.taille()+"\ttaille lf : "+_lf.taille());
                System.out.println("taille : "+taille());
                if(!_ld.estVide())
                    System.out.println("tete : "+_ld.representation());
                if(!_fm.estVide())
                    System.out.println("miroir : "+_fm.representation());
                if(!_lf.estVide())
                    System.out.println("queue : "+_lf.representation());
                String s="";//ld : \n" + ld.representation()+"\nfm : \n"+fm.representation()+"\nlf :\n"+lf.representation();
                return s;
            }
        };
    }
}
