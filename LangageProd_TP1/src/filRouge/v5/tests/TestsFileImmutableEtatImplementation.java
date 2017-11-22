package filRouge.v5.tests;

import filRouge.v5.*;

public class TestsFileImmutableEtatImplementation {

    public static void main(String[] args){
        EnveloppeListeMutableDoubleAcces<String> classeEtatMutable = new EnveloppeListeMutableDoubleAcces<>();
        EnveloppeDeuxListesImmutables<String> classeEtatImmutable = new EnveloppeDeuxListesImmutables<>();

        System.out.println( "Test FileImmutable par EtatMutable");
        FileImmutable<String> fileIEM = FileImmutable.creerAvecEtat(classeEtatMutable);

        System.out.println("taille  0 ? = " +fileIEM.taille());
        System.out.println("estVide true ? = "+fileIEM.estVide());
        fileIEM = fileIEM.ajout("un");
        System.out.println("File [un] = "+fileIEM.representation());
        fileIEM = fileIEM.ajout("deux");fileIEM = fileIEM.ajout("trois");
        System.out.println("File [un,deux,trois]="+fileIEM.representation());
        System.out.println("taille  3 ? = "+fileIEM.taille());
        System.out.println("tete  un ? = "+fileIEM.premier());
        System.out.println("Suivants [deux,trois]="+fileIEM.suivants().representation());

        System.out.println( "Test FileImmutable par EtatImmutable");
        FileImmutable<String> fileIEI = FileImmutable.creerAvecEtat(classeEtatImmutable);

        System.out.println("taille  0 ? = " +fileIEI.taille());
        System.out.println("estVide true ? = "+fileIEI.estVide());
        fileIEI = fileIEI.ajout("un");
        System.out.println("File [un] = "+fileIEI.representation());
        fileIEI = fileIEI.ajout("deux");fileIEI = fileIEI.ajout("trois");
        System.out.println("File [un,deux,trois]="+fileIEI.representation());
        System.out.println("taille  3 ? = "+fileIEI.taille());
        System.out.println("tete  un ? = "+fileIEI.premier());
        System.out.println("Suivants [deux,trois]="+fileIEI.suivants().representation());

    }
}
