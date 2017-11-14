package tp.v2;

public class TestListesMutables {
    public static void main(String[] arg){
    	ListeMutable l1 = ListeMutable.vide();
    	System.out.println("Liste avec un �l�ment (false)? "+l1.casCons());
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
    	System.out.println(l1.representer());
    	
    	System.out.println("Liste de taille 4? "+ l1.taille());
    	System.out.println("Miroir: " + l1.miroir().representer());
    	l1.changerTete(99);
    	System.out.println("Changement de t�te de 4 par 99:");
		System.out.println(l1.representer());
    	System.out.println("CHangement de reste (3,2,1) par liste vide:");
    	l1.changerReste(ListeMutable.vide());
    	System.out.println("taille (1)? "+l1.taille());
		System.out.println(l1.representer());
    	System.out.println("CHangement de reste par la liste elle m�me:");
    	l1.changerReste(l1);
    	System.out.println("Taille (2) ?"+l1.taille());
		System.out.println(l1.representer());
    }
}
