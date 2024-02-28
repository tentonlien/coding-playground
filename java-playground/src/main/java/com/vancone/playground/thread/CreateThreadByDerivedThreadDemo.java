package com.vancone.playground.thread;

/**
 * @author Tenton Lien
 */
public class CreateThreadByDerivedThreadDemo extends Thread {
    private int i;
    private final static int LOOP_NUM = 100;

    // 重写 run() 方法，即线程执行体
    @Override
    public void run() {
        for (; i < LOOP_NUM; i ++) {
            // 继承 Thread 类时，直接使用 this 可以获得当前进程
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < LOOP_NUM; i ++) {
            // 调用 currentThread() 方法获取当前线程；
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                // 创建并启动第一个线程
                new CreateThreadByDerivedThreadDemo().start();
                // 创建并启动第二个线程
                new CreateThreadByDerivedThreadDemo().start();
            }
        }
    }
}