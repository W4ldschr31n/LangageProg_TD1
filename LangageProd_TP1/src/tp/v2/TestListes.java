package tp.v2;

public class TestListes {
    public static void main(String[] arg){
    	ListeMutable l1 = ListeMutable.vide();
    	System.out.println("Liste avec un élément (false)? "+l1.casCons());
    	System.out.println("liste vide (true)? "+l1.casVide());
    	int un = 1;
    	int deux = 2;
    	int trois = 3;
    	int quatre = 4;
    	
    	
    	l1 = ListeMutable.cons(un, l1);
    	l1 = ListeMutable.cons(deux, l1);
    	l1 = ListeMutable.cons(trois, l1);
    	l1 = ListeMutable.cons(quatre, l1);
    	l1 = l1.miroir();
    	IterateurListe it = new IterateurListe(l1);
    	while (it.hasNext()){
    		System.out.println(it.next());
    	}
    	
    	System.out.println("Liste de taille 4? "+ l1.taille());
    	l1.changerTete(99);
    	it = new IterateurListe(l1);
    	System.out.println("Changement de tête de 4 par 99:");
    	while (it.hasNext()){
    		System.out.println(it.next());
    	}
    	System.out.println("CHangement de reste (3,2,1) par liste vide:");
    	l1.changerReste(ListeMutable.vide());
    	System.out.println("taille (1)? "+l1.taille());
    	it = new IterateurListe(l1);
    	while (it.hasNext()){
    		System.out.println(it.next());
    	}
    	System.out.println("CHangement de reste par la liste elle même:");
    	l1.changerReste(l1);
    	System.out.println("Taille (2) ?"+l1.taille());
    	it = new IterateurListe(l1);
    	while (it.hasNext()){
    		System.out.println(it.next());
    	}
    }
}
