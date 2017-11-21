package filRouge.v5;

public class TESTESTEST {
    public static void main(String[] args){
        ImplementationEtatFileImmutable<ImplementationEtatFileImmutable,String> etat0 = new ImplementationEtatFileImmutable();
        FileImmutable<String> file = FileImmutable.creerAvecEtatImmutable(etat0);
        System.out.println(file.taille());
        System.out.println(file.representation());
        file = file.ajout("lol");
        System.out.println(file.representation());
        file = file.ajout("c'est");
        file = file.ajout("compliqué");
        System.out.println(file.representation());
        System.out.println(file.taille());
        System.out.println(file.premier());
    }


}
