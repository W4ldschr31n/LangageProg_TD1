package tp.v2.tests;



import tp.v2.File;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class ComparateurPerfs {
    private static final ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
    private static long diviseur = 100000;

    private static void tester(File<String> file) {
        long temps = threadBean.getCurrentThreadCpuTime();
        file = file.ajouterQueue("un");
        file = file.ajouterQueue("deux");
        file = file.ajouterQueue("trois");
        System.out.println( file.representation());
        System.out.println( file.enleverTete());

        temps = threadBean.getCurrentThreadCpuTime() - temps;
        System.out.println(file.getClass() + " - ajout/retrait: " + (temps / diviseur));
    }

    public static void main(String[] arg){

        //tester(new FileImutableImpl());
        //tester(new FileMutableImpl());

    }
}
