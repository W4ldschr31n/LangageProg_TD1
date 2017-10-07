import java.util.EmptyStackException;


public class Test {

	public static void main(String[] args){
		FileMutableAvecListeChainee<Integer> fm1 = new FileMutableAvecListeChainee<>();
		fm1.ajouterQueue(new Integer(1));
		fm1.ajouterQueue(new Integer(2));
		fm1.ajouterQueue(new Integer(3));
		fm1.ajouterQueue(new Integer(4));
		
		System.out.println(fm1.toString());
		System.out.println("tete: "+fm1.getTete());
		System.out.println("queue "+fm1.getQueue());
		fm1.enleverTete();
		System.out.println(fm1);
		System.out.println("2 est dans ça: "+fm1.toString()+"? "+fm1.contient(new Integer(2)));
		FileMutableAvecListeChainee<Integer> fm2 = new FileMutableAvecListeChainee();
		System.out.println("File numéro 2: "+ fm2.toString());
		fm2.concatener(fm1);
		System.out.println("La file numéro 2 concaténée à "+fm1.toString()+ " : "+fm2.toString());
		fm2.concatener(fm2);
		System.out.println("Concaténaception! "+fm2.toString());
		
		System.out.println(fm1.toString()+" vide? "+fm1.estVide());
		try{
			fm1.enleverTete();
			fm1.enleverTete();
			fm1.enleverTete();
			fm1.enleverTete();
			fm1.enleverTete();
		}
		catch (EmptyStackException e){
			System.out.println("File vide! "+e.getMessage());
		}

		System.out.println(fm1.toString()+" vide? "+fm1.estVide());
		
//		FileMutableAvecListeChainee<Boolean> fm3 = new FileMutableAvecListeChainee();
//		fm3.ajouterQueue(true);
//		fm3.ajouterQueue(false);
//		System.out.println("fm3: "+fm3.toString());
//		System.out.println("fm2: "+fm2.toString());
//		fm2.concatener(fm3);
//		System.out.println(fm2.toString());

		
	}
}
