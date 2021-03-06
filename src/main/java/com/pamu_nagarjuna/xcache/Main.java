package com.pamu_nagarjuna.xcache;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by pnagarjuna on 25/08/15.
 */
public class Main {
    public static void main(String ... args) {
        System.out.println("XCache Performance analysis running ...");
        final int million = 1000000;
        XCache<Integer, Integer> xCache = new XCache<>(million);
        //for(int i = 0; i < million; i++) xCache.put(i, i);
        File statsGet = new File(System.getProperty("user.home") + "/Desktop/statsGet.txt");
        File statsPut = new File(System.getProperty("user.home") + "/Desktop/statsPut.txt");
        try {
            PrintWriter writerGet = new PrintWriter(statsGet);
            PrintWriter writerPut = new PrintWriter(statsPut);
            for(int tc = 1; tc <= 10; tc ++) {
                double getTime = 0;
                double putTime = 0;
                for(int i = 0; i < 100; i ++) {
                    long timeTakenPut = getRunningTime(tc, new Runnable() {
                        @Override
                        public void run() {
                            putOperation(xCache, million);
                        }
                    });
                    putTime = putTime + timeTakenPut;
                }

                putTime = putTime/100;

                for(int i = 0;  i < 100; i ++) {
                    long timeTakenGet = getRunningTime(tc, new Runnable() {
                        @Override
                        public void run() {
                            getOperation(xCache, million);
                        }
                    });
                    getTime = getTime + timeTakenGet;
                }

                getTime = getTime/100;

                writerPut.println((putTime/million));
                writerPut.flush();
                writerGet.println((getTime/million));
                writerGet.flush();
                xCache.getCache().clear();
            }
            writerGet.close();
            writerPut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Done ... ");
    }

    public static void putOperation(XCache<Integer, Integer> xCache, int operations) {
        for(int i = 0; i < operations; i++) {
            xCache.put(i, i);
        }
    }

    public static void getOperation(XCache<Integer, Integer> xCache, int operations) {
        for(int i = 0; i < operations; i++) {
            xCache.get(i);
        }
    }

    public static long getRunningTime(int threads, Runnable runnable) {
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        long start = System.nanoTime();
        executorService.execute(runnable);
        long stop = System.nanoTime();
        executorService.shutdown();
        return (stop - start);
    }
}
