package com.vancone.playground.lock;

import java.util.concurrent.locks.StampedLock;

/**
 * StampedLock 相比 ReentrantReadWriteLock，多支持了优化读模式
 */
public class StampedLockDemo {
    private final StampedLock lock = new StampedLock();

    String read() {
        return "data";
    }
    void write() {}

    void mutate() {
        long stamp = lock.writeLock();
        try {
            write();
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    String access() {
        long stamp = lock.tryOptimisticRead();
        String data = read();
        if (!lock.validate(stamp)) {
            stamp = lock.readLock();
            try {
                data = read();
            } finally {
                lock.unlockRead(stamp);
            }
        }
        return data;
    }

    public static void main(String[] args) {

    }
}
