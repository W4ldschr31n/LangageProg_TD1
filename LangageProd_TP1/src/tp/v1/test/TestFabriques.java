package tp.v1.test;

import tp.v1.Fabriques.*;
import tp.v1.Files.*;
import tp.v1.Files.Interface.File;

public class TestFabriques {

	public static void main(String[] args) {
		FabriqueFileMutableAvecListeChainee<Integer> fab = new FabriqueFileMutableAvecListeChainee();
		FileMutableAvecListeChainee<Integer> fileVide = fab.creerFileVide();
		System.out.println("File vide");
		System.out.println(fileVide);
		fileVide.ajouterQueue(45);
		System.out.println("File avec un élément");
		System.out.println(fileVide);
		Integer[] tabi = new Integer[] {1,2,89,56,78,456,7896};
		FileMutableAvecListeChainee<Integer> fileRemplie = fab.creerFileElements(tabi);
		System.out.println("File avec des éléments");
		System.out.println(fileRemplie);

	}

}
