package filRouge.v5;

import java.util.Iterator;

public interface EtatFileImmutable<K,E> extends EtatFile<EtatFileImmutable<K,E>,E>{
    
	public static <K,E> EtatFileImmutable creerVide(){
		return new EtatFileImmutable<K,E>(){

			@Override
			public E premier() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public EtatFileImmutable<K, E> suivants() {
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
	
	public static <K,E> EtatFileImmutable creerCons(){
		return new EtatFileImmutable<K,E>(){

			@Override
			public E premier() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public EtatFileImmutable<K, E> suivants() {
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
