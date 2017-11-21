package filRouge.v5;

public class TESTESTEST {
    public static void main(String[] args){
        EtatFileMutable<EtatFileMutable,String> etatMutable = EtatFileMutable.vide();
        EtatFileImmutable<EtatFileImmutable,String> etatImmutable = EtatFileImmutable.vide();

        System.out.println( "Test FileMutable par EtatMutable");

        FileMutable<String> fileMEM = FileMutable.creerAvecEtatMutable(etatMutable);

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
        FileMutable<String> fileMEI = FileMutable.creerAvecEtatImmutable(etatImmutable);

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
        FileImmutable<String> fileIEM = FileImmutable.creerAvecEtatMutable(etatMutable);

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
        FileImmutable<String> fileIEI = FileImmutable.creerAvecEtatImmutable(etatImmutable);

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
