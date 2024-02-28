package com.vancone.playground.thread;

/**
 * @author Tenton Lien
 */
public class InterruptDemo implements Runnable {

    private final Object lock = new Object();

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " runs");

        // Wait 抛出异常
        try {
            // 调用对象的 wait 方法之前，需要先持有该对象的锁，否则会抛出异常
            synchronized (lock) {
                lock.wait();
            }
        } catch (InterruptedException e) {
            System.out.println("Wait interrupted: " + e);
        }

        // Sleep 抛出异常
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted: " + e);
        }

        // 主动检测
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Runnable interrupted");
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InterruptDemo demo = new InterruptDemo();
        Thread thread = new Thread(demo, "InterruptThreadDemo");
        thread.start();

        Thread.sleep(2000);
        thread.interrupt();

        Thread.sleep(2000);
        thread.interrupt();

        Thread.sleep(2000);
        thread.interrupt();
    }
}
