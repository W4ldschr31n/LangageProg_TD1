package filRouge.v5;

import java.util.Iterator;

public interface EtatFileMutable<K,E> extends EtatFile<EtatFileMutable<K,E>,E>{


	public static <K,E> EtatFileMutable creerVide(){
		return new EtatFileMutable<K,E>(){
			ListeMutable<E> reste = ListeMutable.vide();
			E tete=null;
			
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
				return this.reste.iterator();
			}
			
		};
	}

	


	public static <K,E> EtatFileMutable creerCons(E element, EtatFileMutable etatFileMutable){
		return new EtatFileMutable<K,E>(){
			ListeMutable<E> reste = ListeMutable.vide();
			E tete=null;

			@Override
			public E premier() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public EtatFileMutable<K, E> suivants() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int taille() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public Iterator<E> iterator() {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
	}
}
