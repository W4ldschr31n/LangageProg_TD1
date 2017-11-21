package filRouge.v5.tests;

import filRouge.v5.EtatFileMutable;

public class etatFileMutableTest {
    public static void main(String[] args){
        EtatFileMutable<EtatFileMutable,String> etat0 = EtatFileMutable.vide();

        System.out.println("taille " +etat0.taille());
        System.out.println("estVide true ? = "+etat0.estVide());
        etat0 = EtatFileMutable.cons("un",etat0);
        System.out.println("File [un] = "+etat0.representer());
        etat0 = EtatFileMutable.cons("deux",etat0);
        etat0 = EtatFileMutable.cons("trois",etat0);
        System.out.println("File [un,deux,trois]="+etat0.representer());
        System.out.println("taille  3 ? = "+etat0.taille());
        System.out.println("tete  un ? = "+etat0.premier());
        System.out.println("Suivants [deux,trois]="+etat0.suivants().representer());
    }

}
