package com.mekcone.playground.thread;

/**
 * @author Tenton Lien
 */
public class FirstThread extends Thread {
    private int i;

    // 重写 run() 方法，即线程执行体；
    @Override
    public void run() {
        for (; i < 100; i ++) {
            // 继承 Thread 类时，直接使用 this 可以获得当前进程
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i ++) {
            // 调用 currentThread() 方法获取当前线程；
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                // 创建并启动第一个线程
                new FirstThread().start();
                // 创建并启动第二个线程
                new FirstThread().start();
            }
        }
    }
}