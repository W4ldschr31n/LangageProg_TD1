package tp.v2.tests;

import tp.v2.FileMutable;
import tp.v2.FileMutableImpl;

import javax.sound.midi.SysexMessage;

public class TestFilesMutables {
	public static void main(String[] arg){
		FileMutableImpl<String> file1 = new FileMutableImpl<>();
		file1.ajouter("test1");
		System.out.println("taille 1 ? " + file1.taille());
		System.out.println("rep: " + file1);
		file1.ajouter("test2");
		System.out.println("rep: " + file1);
		file1.ajouter("test3");
		System.out.println("rep: " + file1);
		file1.ajouter("test4");
		System.out.println("taille 4? " + file1.taille());
		System.out.println("rep: " + file1);
		file1.retirer();
		System.out.println("retrait: " + file1);
		System.out.println("taille 3 ? " + file1.taille());
		file1.retrait().retrait().retrait();
		System.out.println("taille 0 ? " + file1.taille() + " | Rep: "+file1);


		System.out.println("---------------\ncréation d'une deuxieme file à partir de file1\n-------------");
		FileMutable<String> file2 = file1.creer();
		System.out.println("Rep de la deuxieme file vide: " + file2);
		file2.ajouter("teteFile2");
		file2.ajouter("elem2");
		file2.ajouter("elem3");
		System.out.println("Ajout element: " + file2);
		System.out.println("Tete de la deuxieme file: " + file2.premier());

		System.out.println("---------------\ncréation d'une troisieme file identique à file2\n-------------");
		FileMutable<String> file3 = file2.creerCopie();
		System.out.println("Rep de la deuxieme file vide: " + file3);
		System.out.println("Tete de la deuxieme file: " + file3.premier());

		System.out.println("---------------\nDéclenchement de l'exception retrait\n-------------");
		System.out.println("File avant d'avoir retiré les élements: " + file3);
		file3.retrait().retrait().retrait();
		System.out.println("File après avoir retiré les éléments: " + file3);
		try {
			file3.retrait();
		}catch (UnsupportedOperationException e){
		}
		System.out.println("Exception!");



	}
}
