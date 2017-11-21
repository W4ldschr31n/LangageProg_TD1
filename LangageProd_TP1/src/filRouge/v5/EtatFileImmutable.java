package filRouge.v5;


public interface EtatFileImmutable<K,E> extends EtatFile<EtatFileImmutable<K,E>,E>{
    
	EtatFileImmutable<K,E> cons(E e, EtatFileImmutable<? extends EtatFileImmutable, E> etat);
	EtatFileImmutable<K,E> vide();

}
