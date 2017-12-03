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
                return cons(ListeImmutable.<E>vide().creer(dernier), EtatImmutableAvecInversionParesseuse.vide(), ListeImmutable.vide());
            }

            @Override
            public int taille() {
                return 0;
            }

        };
    }

    static <E> EtatImmutableAvecInversionParesseuse<E> cons(ListeImmutable<E> ld, EtatFileImmutable<Miroir<E>> fm, ListeImmutable<E> lf){
        return new EtatImmutableAvecInversionParesseuse<E>() {
            private ListeImmutable<E> _ld = ld; // taille >0
            private EtatFileImmutable<Miroir<E>> _fm = fm; // pour tout miroit, non vide
            private ListeImmutable<E> _lf = lf; // taille(ld) > taille(lf)
            {
                //INVARIANT
                while(!(fm.taille()>lf.taille())){
                    _fm = fm.creer(new Miroir<>(lf));
                    _lf = ListeImmutable.vide();
                }
                while(ld.estVide()){
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
                return _ld.taille();
            }

            @Override
            public E premier() {
                return _ld.tete();
            }

            @Override
            public EtatFileImmutable<E> suivants() {
                return taille()>1 ? cons(_ld.reste(), _fm, _lf) : vide();
            }

            @Override
            public Iterator<E> iterator() {
                //return new IterateurEtatFileImmutable<E, EtatFile<EtatImmutableAvecInversionParesseuse>>(this);
                return null;
            }
        };
    }
}
