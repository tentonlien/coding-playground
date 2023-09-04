package com.vanconeplayground.thread.sychronized;

import java.util.ArrayList;
import java.util.List;

// 在多线程中最好不要直接对基本数据类型对象进行加锁来实现线程同步；
// 对于static全局变量，最好的方式是对类（不是类对象）进项加锁

public class SynchronizedLock implements Runnable {

    // 是否开启锁
    private final boolean ENABLE_LOCK = true;

    private static Integer balance = 1000;
    private static List<TransactionRecord> transactionRecordList = new ArrayList<TransactionRecord>();

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(Math.round(Math.random() * 50));
                if (ENABLE_LOCK) {
                    synchronized (SynchronizedLock.class) {
                        Thread.sleep(Math.round(Math.random() * 50));
                        balance -= 1;
                        TransactionRecord transactionRecord = new TransactionRecord(Thread.currentThread().getName(), balance);
                        transactionRecordList.add(transactionRecord);
                    }
                } else {
                    Thread.sleep(Math.round(Math.random() * 50));
                    balance -= 1;
                    TransactionRecord transactionRecord = new TransactionRecord(Thread.currentThread().getName(), balance);
                    transactionRecordList.add(transactionRecord);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedLock synchronizedLock = new SynchronizedLock();

        Thread[] threads = new Thread[100];

        for (int i = 0; i < threads.length; i ++) {
            threads[i] = new Thread(synchronizedLock, "Thread-" + i);
        }

        for (Thread value : threads) {
            value.start();
        }

        for (Thread thread : threads) {
            thread.join();  // 主线程等待子线程结束后再继续运行
        }

        for (TransactionRecord transactionRecord : transactionRecordList) {
            if (transactionRecord == null) {
                System.out.println("============= NULL ============");
            } else {
                transactionRecord.print();
            }
        }
        System.out.println("Transaction Amount: " + transactionRecordList.size() + ", Balance: " + balance);
    }
}
