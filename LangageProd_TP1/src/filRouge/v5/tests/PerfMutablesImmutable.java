package filRouge.v5.tests;

import filRouge.v5.*;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;


public class PerfMutablesImmutable {
    private static final ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
    private static long diviseur = 100000;

    public static void main(String[] args){

        EtatFileMutable<EtatFileMutable,String> etatMut = EtatFileMutable.vide();
        FileMutable<String> fileMut = FileMutable.creerAvecEtat(etatMut);
        perfTester(fileMut);

        FileImmutable<String> fileIm = FileImmutable.creerAvecEtat(etatMut);
        perfTester(fileIm);

        EtatFileImmutable<EtatFileMutable,String> etatImmut = EtatFileImmutable.vide();
        fileMut = FileMutable.creerAvecEtat(etatImmut);
        perfTester(fileMut);

        fileIm = FileImmutable.creerAvecEtat(etatImmut);
        perfTester(fileIm);

        EnveloppeListeMutableDoubleAcces<String> etatMutDoubleAcces = new EnveloppeListeMutableDoubleAcces<>();
         fileMut = FileMutable.creerAvecEtat(etatMutDoubleAcces);
        perfTester(fileMut);

        fileIm = FileImmutable.creerAvecEtat(etatMutDoubleAcces);
        perfTester(fileIm);

        EnveloppeDeuxListesImmutables<String> etatImmutDoubleAcess = new EnveloppeDeuxListesImmutables<>();
        fileMut = FileMutable.creerAvecEtat(etatImmutDoubleAcess);
        perfTester(fileMut);

        fileIm = FileImmutable.creerAvecEtat(etatImmutDoubleAcess);
        perfTester(fileIm);


    }

    public static void perfTester(File file){
        long temps = threadBean.getCurrentThreadCpuTime();

        for (int i = 0; i < 500; i++) {
            file = file.ajout("element"+i);
        }
        for (int i = 0; i < 250; i++) {
            file = file.retrait();

        }

        temps= threadBean.getCurrentThreadCpuTime() - temps;
        System.out.println(file.getClass()+"-"+file.typeEtat() + "  ajout/retrait: " + (temps / diviseur));

    }



}
