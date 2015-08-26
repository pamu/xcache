package com.pamu_nagarjuna.xcache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by pnagarjuna on 25/08/15.
 */
public class Main {
    public static void main(String ... args) {
        System.out.println("XCache");
        long million = 1000000;
        for(int tc = 1; tc < 100; tc++) {

        }
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
        return (stop - start);
    }
}
