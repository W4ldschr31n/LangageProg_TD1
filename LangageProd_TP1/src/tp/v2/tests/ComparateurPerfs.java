package tp.v2.tests;



import tp.v2.File;
import tp.v2.FileMutableImpl;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class ComparateurPerfs {
    private static final ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
    private static long diviseur = 100000;

    private static void tester(File<String> file) {
        long temps = threadBean.getCurrentThreadCpuTime();
        System.out.println("Vide ? true = "+    file.estVide());
        file = file.ajout("un");
        System.out.println("Vide ? false = "+    file.estVide());
        file = file.ajout("deux");
        file = file.ajout("trois");
        System.out.println( file.representation());
        System.out.println( file.retrait());
        System.out.println( file.representation());
        System.out.println( file.retrait());
        System.out.println( file.retrait());
        System.out.println("Vide ? true = "+    file.estVide());
            


        temps = threadBean.getCurrentThreadCpuTime() - temps;
        System.out.println(file.getClass() + " - ajout/retrait: " + (temps / diviseur));
    }

    public static void main(String[] arg){

        //tester(new FileImutableImpl());
        tester(new FileMutableImpl());

    }
}
