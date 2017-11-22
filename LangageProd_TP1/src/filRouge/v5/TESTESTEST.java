package filRouge.v5;

public class TESTESTEST {
    public static void main(String[] args){
        EtatFileMutable<EtatFileMutable,String> etatMutable = EtatFileMutable.vide();
        EtatFileImmutable<EtatFileImmutable,String> etatImmutable = EtatFileImmutable.vide();

        System.out.println( "Test FileMutable par EtatMutable");

        FileMutable<String> fileMEM = FileMutable.creerAvecEtat(etatMutable);

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
        FileMutable<String> fileMEI = FileMutable.creerAvecEtat(etatImmutable);

        System.out.println("taille  0 ? = " +fileMEI.taille());
        System.out.println("estVide true ? = "+fileMEI.estVide());
        fileMEI.ajouter("un");
        System.out.println("File [un] = "+fileMEI.representation());
        fileMEI.ajouter("deux");fileMEI.ajouter("trois");
        System.out.println("File [un,deux,trois]="+fileMEI.representation());
        System.out.println("taille  3 ? = "+fileMEI.taille());
        System.out.println("tete  un ? = "+fileMEI.premier());
        System.out.println("Suivants [deux,trois]="+fileMEI.suivants().representation());

        System.out.println("/////////////////////////////////");

        etatMutable = EtatFileMutable.vide();
        etatImmutable = EtatFileImmutable.vide();
        System.out.println( "Test FileImmutable par EtatMutable");
        FileImmutable<String> fileIEM = FileImmutable.creerAvecEtat(etatMutable);

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
        FileImmutable<String> fileIEI = FileImmutable.creerAvecEtat(etatImmutable);

        System.out.println("taille  0 ? = " +fileIEI.taille());
        System.out.println("estVide true ? = "+fileIEI.estVide());
        fileIEI = fileIEI.ajout("un");
        System.out.println("File [un] = "+fileIEI.representation());
        fileIEI = fileIEI.ajout("deux");fileIEI = fileIEI.ajout("trois");
        System.out.println("File [un,deux,trois]="+fileIEI.representation());
        System.out.println("taille  3 ? = "+fileIEI.taille());
        System.out.println("tete  un ? = "+fileIEI.premier());
        System.out.println("Suivants [deux,trois]="+fileIEI.suivants().representation());

        System.out.println("\\\\\\\\\\\\\\\\\\TESTS AVEC LES CLASSES D'IMPLEMENTATION\\\\\\\\\\\\\\\\\\\\\\\\\\");
        EnveloppeListeMutableDoubleAcces<String> classeEtatMutable = new EnveloppeListeMutableDoubleAcces<>();
        EnveloppeDeuxListesImmutables<String> classeEtatImmutable = new EnveloppeDeuxListesImmutables<>();

        System.out.println( "Test FileMutable par EtatMutable");

        FileMutable<String> fileMEM2 = FileMutable.creerAvecEtat(classeEtatMutable);

        System.out.println("taille  0 ? = " +fileMEM2.taille());
        System.out.println("estVide true ? = "+fileMEM2.estVide());
        fileMEM2.ajouter("un");
        System.out.println("File [un] = "+fileMEM2.representation());
        fileMEM2.ajouter("deux");fileMEM2.ajouter("trois");
        System.out.println("File [un,deux,trois]="+fileMEM2.representation());
        System.out.println("taille  3 ? = "+fileMEM2.taille());
        System.out.println("tete  un ? = "+fileMEM2.premier());
        System.out.println("Suivants [deux,trois]="+fileMEM2.suivants().representation());

        System.out.println( "Test FileMutable par EtatImmutable");
        FileMutable<String> fileMEI2 = FileMutable.creerAvecEtat(classeEtatImmutable);

        System.out.println("taille  0 ? = " +fileMEI2.taille());
        System.out.println("estVide true ? = "+fileMEI2.estVide());
        fileMEI2.ajouter("un");
        System.out.println("File [un] = "+fileMEI2.representation());
        fileMEI2.ajouter("deux");fileMEI2.ajouter("trois");
        System.out.println("File [un,deux,trois]="+fileMEI2.representation());
        System.out.println("taille  3 ? = "+fileMEI2.taille());
        System.out.println("tete  un ? = "+fileMEI2.premier());
        System.out.println("Suivants [deux,trois]="+fileMEI2.suivants().representation());

        System.out.println("/////////////////////////////////");

        classeEtatMutable = new EnveloppeListeMutableDoubleAcces<>();
        System.out.println( "Test FileImmutable par EtatMutable");
        FileImmutable<String> fileIEM2 = FileImmutable.creerAvecEtat(classeEtatMutable);

        System.out.println("taille  0 ? = " +fileIEM2.taille());
        System.out.println("estVide true ? = "+fileIEM2.estVide());
        fileIEM2 = fileIEM2.ajout("un");
        System.out.println("File [un] = "+fileIEM2.representation());
        fileIEM2 = fileIEM2.ajout("deux");fileIEM2 = fileIEM2.ajout("trois");
        System.out.println("File [un,deux,trois]="+fileIEM2.representation());
        System.out.println("taille  3 ? = "+fileIEM2.taille());
        System.out.println("tete  un ? = "+fileIEM2.premier());
        System.out.println("Suivants [deux,trois]="+fileIEM2.suivants().representation());

        System.out.println( "Test FileImmutable par EtatImmutable");
        FileImmutable<String> fileIEI2 = FileImmutable.creerAvecEtat(classeEtatImmutable);

        System.out.println("taille  0 ? = " +fileIEI2.taille());
        System.out.println("estVide true ? = "+fileIEI2.estVide());
        fileIEI2 = fileIEI2.ajout("un");
        System.out.println("File [un] = "+fileIEI2.representation());
        fileIEI2 = fileIEI2.ajout("deux");fileIEI2 = fileIEI2.ajout("trois");
        System.out.println("File [un,deux,trois]="+fileIEI2.representation());
        System.out.println("taille  3 ? = "+fileIEI2.taille());
        System.out.println("tete  un ? = "+fileIEI2.premier());
        System.out.println("Suivants [deux,trois]="+fileIEI2.suivants().representation());

    }


}
