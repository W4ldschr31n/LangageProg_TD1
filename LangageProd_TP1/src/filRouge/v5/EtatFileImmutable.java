package filRouge.v5;

import java.util.Iterator;


public interface EtatFileImmutable<K,E> extends EtatFile<EtatFileImmutable<K,E>,E>{
//	
//	 EtatFileImmutable<K,E> cons(E e, EtatFileImmutable<? extends EtatFileImmutable, E> etat); 
//	 EtatFileImmutable<K,E> vide(); 
    
	static <K,E> EtatFileImmutable<K,E> cons(E e, EtatFileImmutable<K,E> etat){
		return new EtatFileImmutable<K,E>(){
		    private ListeImmutable<E> liste;
		    
		    {
		        liste = ListeImmutable.vide();
		        for(E el:etat){
		        	liste = ListeImmutable.cons(el, liste);
		        }
		        liste = ListeImmutable.cons(e, liste);
		        liste = liste.miroir();
		    }

		    @Override
		    public E premier() {
		        return liste.tete();
		    }

		    @Override
		    public EtatFileImmutable<K, E> suivants() {
		    	EtatFileImmutable<K,E> suivants = EtatFileImmutable.vide();
		    	Iterator<E> it = this.iterator();
		    	if (this.estVide()){
		    		throw new UnsupportedOperationException();
		    	}
		    	else{
		    		it.next();
		    		while (it.hasNext()){
		    			suivants = EtatFileImmutable.cons(it.next(),suivants);
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
	static <K,E> EtatFileImmutable<K,E> vide(){
		return new EtatFileImmutable<K,E>(){
		    private ListeImmutable<E> liste = ListeImmutable.vide();
		    
			@Override
			public E premier() {
				throw new UnsupportedOperationException();
			}

			@Override
			public EtatFileImmutable<K, E> suivants() {
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

}
