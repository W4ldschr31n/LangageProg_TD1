package tp.v2.tests;

import tp.v2.*;

public class TestFilesImmutables {
    private static void tester() {
        File<String> file1 = new FileImmutableImpl<>();
        file1 = file1.ajout("test1");
        System.out.println("taille 1 ? " + file1.taille());
        System.out.println("rep: " + file1.representation());
        file1 =file1.ajout("test2");
        System.out.println("rep: " + file1.representation());
        file1 = file1.ajout("test3");
        System.out.println("rep: " + file1.representation());
        file1 = file1.ajout("test4");
        System.out.println("taille 4? " + file1.taille());
        System.out.println("rep: " + file1.representation());
        file1 = file1.retrait();
        System.out.println("retrait: " + file1.representation());
        System.out.println("taille 3 ? " + file1.taille());
        file1 = file1.retrait().retrait().retrait();
        System.out.println("taille 0 ? " + file1.taille() + " | Rep: "+file1.representation());


        System.out.println("---------------\ncréation d'une deuxieme file à partir de file1\n-------------");
        File<String> file2 = file1.creer();
        System.out.println("Rep de la deuxieme file vide: " + file2.representation());
        file2 = file2.ajout("teteFile2");
        file2 = file2.ajout("elem2");
        file2 = file2.ajout("elem3");
        System.out.println("Ajout element: " + file2.representation());
        System.out.println("Tete de la deuxieme file: " + file2.premier());

        System.out.println("---------------\ncréation d'une troisieme file identique à file2\n-------------");
        File<String> file3 = file2.creerCopie();
        System.out.println("Rep de la deuxieme file vide: " + file3.representation());
        System.out.println("Tete de la deuxieme file: " + file3.premier());

        System.out.println("---------------\nDéclenchement de l'exception retrait\n-------------");
        System.out.println("File avant d'avoir retiré les élements: " + file3.representation());
        file3 = file3.retrait();
        file3 = file3.retrait();
        file3 = file3.retrait();
        System.out.println("File après avoir retiré les éléments: " + file3.representation());
        try {
            file3 = file3.retrait();
        }catch (UnsupportedOperationException e){
        }
        System.out.println("Exception!");

    }

    public static void main(String[] arg){

        tester();


    }
}
