package filRouge.v6.tests;

import filRouge.v5.ListeImmutable;
import filRouge.v6.Miroir;

public class testMiroir {
    public static void main(String[] args) {
        ListeImmutable<Integer> liste = ListeImmutable.vide();
        liste = liste.creer(1);
        liste = liste.creer(2);
        liste = liste.creer(4);
        liste = liste.creer(8);
        System.out.println("Liste : "+liste.representation());
        Miroir<Integer> miroir = new Miroir<>(liste);
        System.out.println("Miroir inversible (true) : "+miroir.estInversible());
        try{
            System.out.println(miroir.miroir());
        }catch(UnsupportedOperationException e){
            System.out.println("Miroir pas encore possible");
        }
        while(miroir.estInversible()){
            miroir.inverser();
        }
        System.out.println("Miroir inversible (false) : "+miroir.estInversible());
        try{
            System.out.println(miroir.miroir());
        }catch(UnsupportedOperationException e){
            System.out.println("Miroir pas encore possible");
        }


    }
}
