package tp.v2.tests;

import tp.v2.Liste;

public class TestListe {
    public static void testListe(){
        Liste liste = Liste.vide();
        System.out.println("Vide ? true = "+    liste.estVide());
        liste = Liste.cons( "un",Liste.cons("deux",Liste.vide()));
        System.out.println("Vide ? false = "+    liste.estVide());
        System.out.println("Tete ? 'un' = "+liste.tete());
        System.out.println("Tete ? 'deux' = "+liste.reste().tete());
        System.out.println("taille? 2 ="+liste.taille());
        liste = Liste.cons( "trois",liste);
        System.out.println("Tete ? 'tois' = "+liste.tete());
        System.out.println("Tete ? 'un' = "+liste.reste().tete());
        System.out.println("Tete ? 'deux' = "+liste.reste().reste().tete());
        System.out.println("taille? 3 = "+liste.taille());
        liste = liste.miroir();
        System.out.println("Tete ? 'deux' = "+liste.tete());
        System.out.println("Tete ? 'un' = "+liste.reste().tete());
        System.out.println("Tete ? 'trois' = "+liste.reste().reste().tete());


    }
    public static void main(String[] args){
        testListe();
    }

}
