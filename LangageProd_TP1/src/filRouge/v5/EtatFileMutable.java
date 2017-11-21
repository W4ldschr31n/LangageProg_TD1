package filRouge.v5;

import java.util.Iterator;

public interface EtatFileMutable<K,E> extends EtatFile<EtatFileMutable<K,E>,E>{

	default EtatFileMutable<K,E> creer(E e, EtatFileMutable<K,E> etat){
		return cons(e, etat);
	}
	default EtatFileMutable<K,E> creer(){
		return vide();
	}

	static <K,E> EtatFileMutable<K,E> vide(){
		return new EtatFileMutable<K,E>(){
			private ListeMutable<E> liste = ListeMutable.vide();

			@Override
			public E premier() {
				throw new UnsupportedOperationException();
			}

			@Override
			public EtatFileMutable<K, E> suivants() {
				throw new UnsupportedOperationException();
			}

			@Override
			public int taille() {
				return 0;
			}

			@Override
			public Iterator<E> iterator() {
				return liste.iterator();
			}

		};
	}

	static <K,E> EtatFileMutable<K,E> cons(E e, EtatFileMutable<K,E> etat){
		return new EtatFileMutable<K,E>(){
			private ListeMutable<E> liste;

			{
				liste = ListeMutable.vide();
				for(E el:etat){
					liste = liste.creer(el);
				}
				liste = liste.creer(e);
				liste = liste.miroir();
			}

			@Override
			public E premier() {
				return liste.tete();
			}

			@Override
			public EtatFileMutable<K, E> suivants() {
				EtatFileMutable<K,E> suivants = EtatFileMutable.vide();
				Iterator<E> it = this.iterator();
				if (this.estVide()){
					throw new UnsupportedOperationException();
				}
				else{
					it.next();
					while (it.hasNext()){
						suivants = EtatFileMutable.cons(it.next(),suivants);
					}
					return suivants;
				}
			}

			@Override
			public int taille() {
				return liste.taille();
			}

			@Override
			public Iterator<E> iterator() {
				return liste.iterator();
			}

			public String representer(){
				return liste.representation();
			}

			@Override
			public boolean estVide(){
				return liste.casVide();
			}



		};
	}


}
