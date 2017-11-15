package tp.v2.tests;



import tp.v2.File;
import tp.v2.FileImmutableImpl;
import tp.v2.FileMutableImpl;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class ComparateurPerfs {
    private static final ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
    private static long diviseur = 100000;

    private static void tester(File file) {
        long temps = threadBean.getCurrentThreadCpuTime();


        System.out.println(file.representation());
        for (int i = 0; i < 100; i++) {
            file = file.ajout("element"+i);
        }
        System.out.println( file.representation());
        for (int i = 0; i < 100; i++) {
            file = file.retrait();
        }

        System.out.println( file.representation());
        temps= threadBean.getCurrentThreadCpuTime() - temps;
        System.out.println(file.getClass() + "  ajout/retrait: " + (temps / diviseur));
    }

    public static void main(String[] arg){
        tester(new FileMutableImpl());
        tester(new FileImmutableImpl());


    }
}
