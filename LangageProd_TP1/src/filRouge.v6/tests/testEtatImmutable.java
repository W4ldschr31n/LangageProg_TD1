package filRouge.v6.tests;

import filRouge.v6.EtatFileImmutable;
import filRouge.v6.EtatImmutableAvecInversionParesseuse;

public class testEtatImmutable {

    public static void main(String[] args){
        EtatImmutableAvecInversionParesseuse<Integer> file = EtatImmutableAvecInversionParesseuse.vide();
        System.out.println(file);
        EtatFileImmutable<Integer> file2 = file.creer(1);
        System.out.println(file2);
        file2 = file2.creer(2);
        System.out.println(file2);
        file2 = file2.creer(3);
        System.out.println(file2);
        file2 = file2.creer(4);
        System.out.println(file2);
        file2 = file2.suivants();
        System.out.println(file2);
        file2 = file2.suivants();
        System.out.println(file2);
        file2 = file2.creer(5);
        System.out.println(file2);
        file2 = file2.creer(6);
        System.out.println(file2);
        file2 = file2.suivants();
        System.out.println(file2);
        file2 = file2.suivants();
        System.out.println(file2);

    }

}
