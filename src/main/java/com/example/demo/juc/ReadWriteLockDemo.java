package com.example.demo.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(final String[] args) {

        final MyCache myCache = new MyCache();
        for (int i = 0; i < 5; i++) {
            final int tmp = i;
            new Thread(() -> {
                myCache.put(String.valueOf(tmp), tmp);
            }, String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            final int tmp = i;
            new Thread(() -> {
                myCache.get(String.valueOf(tmp));
            }, String.valueOf(i)).start();
        }
    }

}

class MyCache {
    // private Map<String, Object> cache = new HashMap<String, Object>();
    private final Map<String, Object> cache = new ConcurrentHashMap<String, Object>();

    ReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(final String key, final Object value) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t正在写入数据");
            cache.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t写入数据完成");
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.writeLock().unlock();
        }

    }

    public void get(final String key) {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t正在读取数据");
            cache.get(key);
            System.out.println(Thread.currentThread().getName() + "\t读取数据完成");
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lock.readLock().unlock();
        }

    }
}
