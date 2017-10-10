package test;

import java.util.Arrays;

import Fabriques.FabriqueFileMutableAvecListeChainee;
import Files.FileMutableAvecListeChainee;

public class TestComplexite {
	
public static void main(String[] args) {
	testerComplexite(10,100);
	testerComplexite(10,1000);
	testerComplexite(10,1000000);

	
}
	
	public static  void testerComplexite(int min, int max) {
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
		fileComplexite2.getQueue();
		endTime = System.nanoTime();
		long durationQueue = (endTime - startTime);
		System.out.println("Durée méthode getQueue pour "+min+": "+durationQueue+"ms");
		
		startTime = System.nanoTime();
		fileComplexite2.contient(1);
		endTime = System.nanoTime();
		long duration2 = (endTime - startTime);
		System.out.println("Durée méthode contient pour "+max+": "+duration2+"ms");
		startTime = System.nanoTime();
		fileComplexite2.getQueue();
		endTime = System.nanoTime();
		long durationQueue2 = (endTime - startTime);
		System.out.println("Durée méthode getQueue pour "+max+": "+durationQueue2+"ms");
		
		double complexite = (duration2/duration);
		double complexite2 = (durationQueue2/durationQueue);
		System.out.println("Complexite de la methode concatener: "+complexite+"n");
		System.out.println("Complexite de la methode getQueue: "+complexite2+"n");

	}
		
}
