package filRouge.v5.tests;

import filRouge.v5.*;

public class TestsFileMutableEtatImplementation {
    public static void main(String[] args){

        EnveloppeListeMutableDoubleAcces<String> classeEtatMutable = new EnveloppeListeMutableDoubleAcces<>();
        EnveloppeDeuxListesImmutables<String> classeEtatImmutable = new EnveloppeDeuxListesImmutables<>();

        System.out.println( "Test FileMutable par EtatMutable");

        FileMutable<String> fileMEM = FileMutable.creerAvecEtat(classeEtatMutable);

        System.out.println("taille  0 ? = " +fileMEM.taille());
        System.out.println("estVide true ? = "+fileMEM.estVide());
        fileMEM.ajouter("un");
        System.out.println("File [un] = "+fileMEM.representation());
        fileMEM.ajouter("deux");fileMEM.ajouter("trois");
        System.out.println("File [un,deux,trois]="+fileMEM.representation());
        System.out.println("taille  3 ? = "+fileMEM.taille());
        System.out.println("tete  un ? = "+fileMEM.premier());
        System.out.println("Suivants [deux,trois]="+fileMEM.suivants().representation());

        System.out.println( "Test FileMutable par EtatImmutable");
        FileMutable<String> fileMEI = FileMutable.creerAvecEtat(classeEtatImmutable);

        System.out.println("taille  0 ? = " +fileMEI.taille());
        System.out.println("estVide true ? = "+fileMEI.estVide());
        fileMEI.ajouter("un");
        System.out.println("File [un] = "+fileMEI.representation());
        fileMEI.ajouter("deux");fileMEI.ajouter("trois");
        System.out.println("File [un,deux,trois]="+fileMEI.representation());
        System.out.println("taille  3 ? = "+fileMEI.taille());
        System.out.println("tete  un ? = "+fileMEI.premier());
        System.out.println("Suivants [deux,trois]="+fileMEI.suivants().representation());
    }
}
