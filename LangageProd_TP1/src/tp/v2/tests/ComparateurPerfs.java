package tp.v2.tests;



import tp.v2.File;
import tp.v2.FileImmutableImpl;
import tp.v2.FileMutableImpl;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class ComparateurPerfs {
    private static final ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
    private static long diviseur = 1000000000;

    private static void tester(File file) {
        long temps = threadBean.getCurrentThreadCpuTime();

        System.out.println(file.representation());
        file = file.ajout("un");
        file = file.ajout("deux");
        file = file.ajout("trois");
        System.out.println( file.representation());
        file = file.retrait();
        file = file.retrait();
        file = file.retrait();

        System.out.println( file.representation());
        temps = threadBean.getCurrentThreadCpuTime() - temps;
        System.out.println(file.getClass() + "  ajout/retrait: " + (temps / diviseur));
    }

    public static void main(String[] arg){
        tester(new FileMutableImpl());
        tester(new FileImmutableImpl());


    }
}
