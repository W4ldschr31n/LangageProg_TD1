package tp.v1.test;
import java.util.Arrays;
import java.util.EmptyStackException;

import tp.v1.Fabriques.FabriqueFileMutableAvecListeChainee;
import tp.v1.Files.FileMutableAvecListeChainee;


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
		System.out.println("2 est dans �a: "+fm1.toString()+"? "+fm1.contient(new Integer(2)));
		FileMutableAvecListeChainee<Integer> fm2 = new FileMutableAvecListeChainee();
		System.out.println("File num�ro 2: "+ fm2.toString());
		fm2.concatener(fm1);
		System.out.println("La file num�ro 2 concat�n�e � "+fm1.toString()+ " : "+fm2.toString());
		fm2.concatener(fm2);
		System.out.println("Concat�naception! "+fm2.toString());
		
		System.out.println(fm1.toString()+" vide? "+fm1.estVide());
		try{
			System.out.println("Provocation d'exception");
			fm1.enleverTete();
			fm1.enleverTete();
			fm1.enleverTete();
			fm1.enleverTete();
			fm1.enleverTete();
		}
		catch (EmptyStackException e){
			System.out.println("Exception attrappee!");
		}

		System.out.println(fm1.toString()+" vide? "+fm1.estVide());
		
//		FileMutableAvecListeChainee<Boolean> fm3 = new FileMutableAvecListeChainee();
//		fm3.ajouterQueue(true);
//		fm3.ajouterQueue(false);
//		System.out.println("fm3: "+fm3.toString());
//		System.out.println("fm2: "+fm2.toString());
//		fm2.concatener(fm3);
//		System.out.println(fm2.toString());
		
		FabriqueFileMutableAvecListeChainee<Integer> fab = new FabriqueFileMutableAvecListeChainee<>();
		FileMutableAvecListeChainee<Integer> fileacomparer1 = fab.creerFileElements(new Integer[] {4,12,9,32,7});
		FileMutableAvecListeChainee<Integer> fileacomparer2 = fab.creerFileElements(new Integer[] {4,12,9,32,7});
		FileMutableAvecListeChainee<Integer> fileacomparer3 = fab.creerFileElements(new Integer[] {0,-1});
		FileMutableAvecListeChainee<Integer> fileacomparer4 = fab.creerFileElements(new Integer[] {4,12,9,32,8});
		
		System.out.println("true = "+fileacomparer1.equals(fileacomparer2));
		System.out.println("false = "+fileacomparer1.equals(fileacomparer3));
		System.out.println("false = "+fileacomparer1.equals(fileacomparer4));
		System.out.println("false = "+fileacomparer1.equals(1));
		System.out.println("false = "+fileacomparer1.equals(fab.creerFileVide()));


		
		
		
		
		
		
	}
}
