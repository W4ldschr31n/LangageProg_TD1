package tp.v2.tests;

import tp.v2.File;
import tp.v2.FileImmutableImpl;

public class TestFilesImmutables {
    private static void tester(File<String> file) {

        System.out.println("Vide ? true = "+    file.estVide());
        file = file.ajout("un");
        System.out.println("Vide ? false = "+    file.estVide());
        file = file.ajout("deux");
        file = file.ajout("trois");
        System.out.println( file.representation());
        System.out.println( file.retrait());
        System.out.println( file.representation());
        System.out.println( file.retrait());
        System.out.println( file.retrait());
        System.out.println("Vide ? true = "+    file.estVide());

    }

    public static void main(String[] arg){

        tester(new FileImmutableImpl());


    }
}
