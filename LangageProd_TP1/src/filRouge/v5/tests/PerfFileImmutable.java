package filRouge.v5.tests;

import filRouge.v5.*;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;


public class PerfFileImmutable {
    private static final ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
    private static long diviseur = 100000;

    public static void main(String[] args){

        EtatFileMutable<EtatFileMutable,String> etatMut = EtatFileMutable.vide();
        EtatFileImmutable<EtatFileMutable,String> etatImmut = EtatFileImmutable.vide();

        EnveloppeListeMutableDoubleAcces<String> etatMutDoubleAcces = new EnveloppeListeMutableDoubleAcces<>();
        EnveloppeDeuxListesImmutables<String> etatImmutDoubleAcess = new EnveloppeDeuxListesImmutables<>();

        //I = immutable E = avec etat M = mutable / I = immutable C = concret / I = implentation

        FileImmutable<String> fileIEMC = FileImmutable.creerAvecEtat(etatMut);
        FileImmutable<String> fileIEIC = FileImmutable.creerAvecEtat(etatImmut);
        FileImmutable<String> fileIEMI = FileImmutable.creerAvecEtat(etatMutDoubleAcces);
        FileImmutable<String> fileIEII = FileImmutable.creerAvecEtat(etatImmutDoubleAcess);

        perfTester(fileIEMC);
        perfTester(fileIEIC);
        perfTester(fileIEMI);
        perfTester(fileIEII);


    }

    public static void perfTester(FileImmutable file){
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
