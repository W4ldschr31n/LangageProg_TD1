package filRouge.v5;

import java.util.Iterator;

public interface EtatFileImmutable<E> extends EtatFile<EtatFileImmutable<E>,E>{
    
	public static <E> EtatFileImmutable creerVide(){
		return new EtatFileImmutable<E>(){

			@Override
			public E premier() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public EtatFileImmutable<E> suivants() {
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
	
	public static <E> EtatFileImmutable creerCons(){
		return new EtatFileImmutable<E>(){

			@Override
			public E premier() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public EtatFileImmutable<E> suivants() {
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
