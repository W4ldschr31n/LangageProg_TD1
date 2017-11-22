package filRouge.v5.tests;

import filRouge.v5.*;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;


public class PerfFileMutable {
    private static final ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();

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

        //perfTester(fileMEMC);
        //perfTester(fileMEIC);
        perfTester(fileMEMI);
        perfTester(fileMEII);


    }

    public static void perfTester(FileMutable file){
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
