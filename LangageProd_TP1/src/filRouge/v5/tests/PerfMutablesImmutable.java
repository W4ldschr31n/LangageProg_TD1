package filRouge.v5.tests;

import filRouge.v5.*;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;


public class PerfMutablesImmutable {
    private static final ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
    private static long diviseur = 1;

    public static void main(String[] args){

       /* EtatFileMutable<EtatFileMutable,String> etatMut = EtatFileMutable.vide();
        FileMutable<String> fileMut = FileMutable.creerAvecEtat(etatMut);
        perfTester(fileMut);
        etatMut = EtatFileMutable.vide();
        FileImmutable<String> fileIm = FileImmutable.creerAvecEtat(etatMut);
        perfTester(fileIm);

        EtatFileImmutable<EtatFileMutable,String> etatImmut = EtatFileImmutable.vide();
        fileMut = FileMutable.creerAvecEtat(etatImmut);
        perfTester(fileMut);

        fileIm = FileImmutable.creerAvecEtat(etatImmut);
        perfTester(fileIm);*/

        EnveloppeListeMutableDoubleAcces<String> etatMutDoubleAcces = new EnveloppeListeMutableDoubleAcces<>();
        FileMutable<String> fileMut2 = FileMutable.creerAvecEtat(etatMutDoubleAcces);
        perfTesterMutable(fileMut2);
        etatMutDoubleAcces = new EnveloppeListeMutableDoubleAcces<>();
        FileImmutable<String> fileIm2 = FileImmutable.creerAvecEtat(etatMutDoubleAcces);
        perfTesterImmutable(fileIm2);

        EnveloppeDeuxListesImmutables<String> etatImmutDoubleAcess = new EnveloppeDeuxListesImmutables<>();
        fileMut2 = FileMutable.creerAvecEtat(etatImmutDoubleAcess);
        perfTesterMutable(fileMut2);

        fileIm2 = FileImmutable.creerAvecEtat(etatImmutDoubleAcess);
        perfTesterImmutable(fileIm2);


    }

    public static void perfTesterImmutable(FileImmutable file){
        long temps = threadBean.getCurrentThreadCpuTime();
        for (int i = 0; i < 100000; i++) {
            file = file.ajout("element"+i);
        }
        long tempsAjout = threadBean.getCurrentThreadCpuTime();
        for (int i = 0; i < 100000; i++) {
            file = file.retrait();

        }
        long tempsRetrait= threadBean.getCurrentThreadCpuTime();
        System.out.println(file.getClass()+"-"+file.typeEtat() + "  ajout: " + (tempsAjout-temps)+"\tretrait : "+(tempsRetrait-tempsAjout));

    }

    public static void perfTesterMutable(FileMutable file){
        long temps = threadBean.getCurrentThreadCpuTime();
        for (int i = 0; i < 100000; i++) {
            file.ajouter("element"+i);
        }
        long tempsAjout = threadBean.getCurrentThreadCpuTime();
        for (int i = 0; i < 100000; i++) {
            file.retirer();

        }
        long tempsRetrait= threadBean.getCurrentThreadCpuTime();
        System.out.println(file.getClass()+"-"+file.typeEtat() + "  ajout: " + (tempsAjout-temps)+"\tretrait : "+(tempsRetrait-tempsAjout));

    }



}
