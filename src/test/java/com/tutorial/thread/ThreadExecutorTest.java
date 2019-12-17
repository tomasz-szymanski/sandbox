package com.tutorial.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class ThreadExecutorTest {

    @Test
    void shouldSumbmitAndShutdownToWaitForCompletion() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + " start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " end");
        };
        executor.submit(runnable);
        executor.shutdown();
        while(!executor.isTerminated()){
            System.out.println("Processing...");
            Thread.sleep(500);
        }
    }

    @Test
    void shouldSubmitAndProcessCallable() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Callable<Integer> callable = () -> {
            System.out.println(Thread.currentThread().getName() + " starting processing");
            Thread.sleep(5000);
            return 5;
        };
        Future<Integer> submit = executorService.submit(callable);
        while (!submit.isDone()){
            System.out.println("not finished");
            Thread.sleep(1000);
        }
        System.out.println(submit.get());
    }
}
