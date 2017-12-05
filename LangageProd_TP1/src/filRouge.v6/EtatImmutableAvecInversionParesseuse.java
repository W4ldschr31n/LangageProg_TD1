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
        return new IterateurEtatFileImmutable<>(this);
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
            private int taille;
            {
                taille = ld.taille() + lf.taille();
                for (Miroir<E> m : fm)
                    taille += m.taille();
                //INVARIANT
                while(!(_fm.taille()+_ld.taille()>_lf.taille())){
                    //System.out.println("taille ld : "+_ld.taille()+"\ttaille fm : "+_fm.taille()+"\ttaille lf : "+_lf.taille());
                    _fm = _fm.creer(new Miroir<>(_lf));
                    _lf = ListeImmutable.vide();
                }
                if(_ld.estVide()){
                    while(_fm.premier().estInversible())
                        _fm.premier().inverser();
                    _ld = _fm.premier().miroir();
                    _fm = _fm.suivants();
                }
            }

            @Override
            public EtatFileImmutable<E> creer(E dernier) {
                return cons(_ld, _fm, _lf.creer(dernier));
            }

            @Override
            public int taille() {
                return taille;
            }

            @Override
            public E premier() {
                return _ld.tete();
            }

            @Override
            public EtatFileImmutable<E> suivants() {
                if(taille()==1)
                    return vide();
                return cons((_ld.taille()>1 ? _ld.reste() : _ld.creer()), _fm, _lf) ;
            }

            public String toString(){
                /*System.out.println("taille ld : "+_ld.taille()+"\ttaille fm : "+_fm.taille()+"\ttaille lf : "+_lf.taille());
                System.out.println("taille : "+taille());*/
                String s = "";
                if(!_ld.estVide())
                    s+=_ld.representation();
                if(!_fm.estVide())
                   s+=_fm.representation();
                if(!_lf.estVide())
                    s+=_lf.representation();
                return s;
            }
        };
    }
}
