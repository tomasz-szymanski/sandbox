package com.tutorial.thread;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadTest {

    class ThreadEx extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("test");
            value = 1;
        }
    }

    private int value;

    @Before
    public void setUp() throws Exception {
        value = 0;
    }

    @Test
    public void shouldCreateThreadByExtendingThread() throws InterruptedException {
        ThreadEx threadEx = new ThreadEx();
        threadEx.start();
        threadEx.join();
        Assert.assertEquals(1, this.value);
    }

    @Test
    public void shouldCreateThreadByImplRunnable() throws InterruptedException {
        ThreadEx threadEx = new ThreadEx();
        threadEx.start();

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Assert.assertEquals(1, this.value);
    }

    @Test
    public void shouldCreateTwoThreads() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        for (int key = 0; key < 1000; key++) {
            hashMap.put(key, new Object());
        }

        Runnable r1 = () -> {
            System.out.println(Thread.currentThread().getName() + " " + hashMap.size());
            hashMap.remove(2);
            System.out.println(Thread.currentThread().getName() + " " + hashMap.size());
        };
        Runnable r2 = () -> {
            System.out.println(Thread.currentThread().getName() + " " + hashMap.size());
            hashMap.remove(765);
            System.out.println(Thread.currentThread().getName() + " " + hashMap.size());
        };

        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);
        thread1.start();
        thread2.start();

        System.out.println("HashMap size: " + hashMap.size());

    }
}
