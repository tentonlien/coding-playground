package com.vanconeplayground.thread;

import java.util.concurrent.FutureTask;

/**
 * @author Tenton Lien
 */
public class CreateThreadByCallableDemo {
    public static void main(String[] args) {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            int i = 0;
            for (; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
            return i;
        });

        for (int i = 0; i < 100; i ++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                new Thread(task, "有返回值的线程").start();
            }
        }
        try {
            System.out.println("子线程的返回值：" + task.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}