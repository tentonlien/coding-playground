package com.vanconeplayground.thread;

/**
 * @author Tenton Lien
 */
public class CreateThreadByRunnableDemo implements Runnable {
    private int i;


    @Override
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
                CreateThreadByRunnableDemo createThreadByRunnableDemo = new CreateThreadByRunnableDemo();

                // 通过 new Thread(target, name) 创建新线程
                new Thread(createThreadByRunnableDemo, "新线程1").start();
                new Thread(createThreadByRunnableDemo, "新线程2").start();
            }
        }
    }
}