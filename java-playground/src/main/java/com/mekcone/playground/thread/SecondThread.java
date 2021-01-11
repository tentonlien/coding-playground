package com.mekcone.playground.thread;

/**
 * @author Tenton Lien
 */
public class SecondThread implements Runnable {
    private int i;

    public void run() {
        for (; i < 100; i ++) {
            // 不能直接通过 this 获取当前线程对象
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i ++) {
            System.out.println(Thread.currentThread().getName() + " " + i);

            if (i == 20) {
                SecondThread secondThread = new SecondThread();

                // 通过 new Thread(target, name) 创建新线程
                new Thread(secondThread, "新线程1").start();
                new Thread(secondThread, "新线程2").start();
            }
        }
    }
}