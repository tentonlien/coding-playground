package com.vancone.playground.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {

    static class MyConcurrentMap {
        private final Map<String, String> map = new HashMap<>();
        private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
        private final Lock rl = rwl.readLock();
        private final Lock wl = rwl.writeLock();

        public String get(String key) {
            rl.lock();
            System.out.println("读锁锁定");
            try {
                return map.get(key);
            } finally {
                rl.unlock();
            }
        }

        public void put(String key, String value) {
            wl.lock();
            System.out.println("写锁锁定");
            try {
                map.put(key, value);
            } finally {
                wl.unlock();
            }
        }
    }

    public static void main(String[] args) {
        MyConcurrentMap map = new MyConcurrentMap();
        map.put("key", "value");
        System.out.println(map.get("key"));
    }
}
