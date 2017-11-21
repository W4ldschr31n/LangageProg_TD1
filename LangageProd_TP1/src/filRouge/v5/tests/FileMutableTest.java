package filRouge.v5.tests;

import filRouge.v5.EtatFileImmutable;
import filRouge.v5.EtatFileMutable;
import filRouge.v5.FileImmutable;
import filRouge.v5.FileMutable;

public class FileMutableTest {
    public static void main(String[] args){
        System.out.println( "Test FileMutables");
        EtatFileMutable<EtatFileMutable,String> etat0 = EtatFileMutable.vide();
        FileMutable<String> file = FileMutable.creerAvecEtat(etat0);

        System.out.println("taille  0 ? = " +file.taille());
        System.out.println("estVide true ? = "+file.estVide());
        file.ajouter("un");
        System.out.println("File [un] = "+file.representation());
        file.ajouter("deux");file.ajouter("trois");
        System.out.println("File [un,deux,trois]="+file.representation());
        System.out.println("taille  3 ? = "+file.taille());
        System.out.println("tete  un ? = "+file.premier());
        System.out.println("Suivants [deux,trois]="+file.suivants().representation());
    }
}
