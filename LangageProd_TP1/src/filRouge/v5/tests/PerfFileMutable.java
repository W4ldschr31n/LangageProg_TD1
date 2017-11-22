package filRouge.v5.tests;

import filRouge.v5.*;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;


public class PerfFileMutable {
    private static final ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
    private static long diviseur = 100000;

    public static void main(String[] args){

        EtatFileMutable<EtatFileMutable,String> etatMut = EtatFileMutable.vide();
        EtatFileImmutable<EtatFileMutable,String> etatImmut = EtatFileImmutable.vide();

        EnveloppeListeMutableDoubleAcces<String> etatMutDoubleAcces = new EnveloppeListeMutableDoubleAcces<>();
        EnveloppeDeuxListesImmutables<String> etatImmutDoubleAcess = new EnveloppeDeuxListesImmutables<>();

        //M = mutable E = avec etat M = mutable / I = immutable C = concret / I = implentation

        FileMutable<String> fileMEMC = FileMutable.creerAvecEtat(etatMut);
        FileMutable<String> fileMEIC = FileMutable.creerAvecEtat(etatImmut);
        FileMutable<String> fileMEMI = FileMutable.creerAvecEtat(etatMutDoubleAcces);
        FileMutable<String> fileMEII = FileMutable.creerAvecEtat(etatImmutDoubleAcess);

        perfTester(fileMEMC);
        perfTester(fileMEIC);
        perfTester(fileMEMI);
        perfTester(fileMEII);


    }

    public static void perfTester(FileMutable file){
        long temps = threadBean.getCurrentThreadCpuTime();

        for (int i = 0; i < 500; i++) {
            file.ajouter("element"+i);
        }
        for (int i = 0; i < 250; i++) {
            file.retirer();

        }

        temps= threadBean.getCurrentThreadCpuTime() - temps;
        System.out.println(file.getClass()+"-"+file.typeEtat() + "  ajout/retrait: " + (temps / diviseur));

    }



}
