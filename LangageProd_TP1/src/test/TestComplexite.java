package test;

import java.util.Arrays;

import Fabriques.FabriqueFileMutableAvecListeChainee;
import Files.FileMutableAvecListeChainee;

public class TestComplexite {
	
public static void main(String[] args) {
	testerContient(10,100);
	testerContient(10,1000);
	testerContient(10,1000000);
	
	System.out.println("");
	
	testerGetQueue(10,100);
	testerGetQueue(10,1000);
	testerGetQueue(10,1000000);
	
   System.out.println("");
	
	testerAjouter(10,100);
	testerAjouter(10,1000);
	testerAjouter(10,1000000);
	


	
}
	
	public static  void testerContient(int min, int max) {
		Integer[] tabMin = new Integer[min];
		Integer[] tabMax = new Integer[max];
		Arrays.fill(tabMin,0);
		Arrays.fill(tabMax,0);
		tabMin[min-1]=1;
		tabMax[max-1]=1;
		FabriqueFileMutableAvecListeChainee<Integer> fab = new FabriqueFileMutableAvecListeChainee<>();
		FileMutableAvecListeChainee<Integer> fileComplexite1 = fab.creerFileElements(tabMin);
		FileMutableAvecListeChainee<Integer> fileComplexite2 = fab.creerFileElements(tabMax);

		long startTime = System.nanoTime();
		fileComplexite1.contient(1);
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);
		System.out.println("Durée méthode contient pour "+min+": "+duration+"ms");
	
		
		startTime = System.nanoTime();
		fileComplexite2.contient(1);
		endTime = System.nanoTime();
		long duration2 = (endTime - startTime);
		System.out.println("Durée méthode contient pour "+max+": "+duration2+"ms");
		
		
		double complexite = (duration2/duration);
	
		System.out.println("Complexite de la methode contient: "+complexite+"n");
		

	}
	
	
	public static void testerGetQueue(int min, int max) {
		Integer[] tabMin = new Integer[min];
		Integer[] tabMax = new Integer[max];
		Arrays.fill(tabMin,0);
		Arrays.fill(tabMax,0);
		tabMin[min-1]=1;
		tabMax[max-1]=1;
		FabriqueFileMutableAvecListeChainee<Integer> fab = new FabriqueFileMutableAvecListeChainee<>();
		FileMutableAvecListeChainee<Integer> fileComplexite1 = fab.creerFileElements(tabMin);
		FileMutableAvecListeChainee<Integer> fileComplexite2 = fab.creerFileElements(tabMax);


		long startTime = System.nanoTime();
		fileComplexite2.getQueue();
		long endTime = System.nanoTime();
		long durationQueue = (endTime - startTime);
		System.out.println("Durée méthode getQueue pour "+min+": "+durationQueue+"ms");
		
	
		startTime = System.nanoTime();
		fileComplexite2.getQueue();
		endTime = System.nanoTime();
		long durationQueue2 = (endTime - startTime);
		System.out.println("Durée méthode getQueue pour "+max+": "+durationQueue2+"ms");
		
		
		double complexite2 = (durationQueue2/durationQueue);
		
		System.out.println("Complexite de la methode getQueue: "+complexite2+"n");

	}
	
	public static void testerAjouter(int min, int max) {
		
		Integer[] tabMin = new Integer[min];
		Integer[] tabMax = new Integer[max];
		Arrays.fill(tabMin,0);
		Arrays.fill(tabMax,0);
		tabMin[min-1]=1;
		tabMax[max-1]=1;
		FabriqueFileMutableAvecListeChainee<Integer> fab = new FabriqueFileMutableAvecListeChainee<>();
		FileMutableAvecListeChainee<Integer> fileComplexite1 = fab.creerFileElements(tabMin);
		FileMutableAvecListeChainee<Integer> fileComplexite2 = fab.creerFileElements(tabMax);


		long startTime = System.nanoTime();
		fileComplexite2.ajouterQueue(0);
		long endTime = System.nanoTime();
		long durationQueue = (endTime - startTime);
		System.out.println("Durée méthode Ajouter pour "+min+": "+durationQueue+"ms");
		
	
		startTime = System.nanoTime();
		fileComplexite2.ajouterQueue(0);
		endTime = System.nanoTime();
		long durationQueue2 = (endTime - startTime);
		System.out.println("Durée méthode Ajouter pour "+max+": "+durationQueue2+"ms");
		
		
		double complexite2 = (durationQueue2/durationQueue);
		
		System.out.println("Complexite de la methode Ajouter: "+complexite2+"n");
		
	}
}
