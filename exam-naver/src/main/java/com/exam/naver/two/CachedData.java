package com.exam.naver.two;

import org.springframework.beans.factory.parsing.FailFastProblemReporter;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * description: 缓存
 * author:zzj
 * create:2020/2/22 10:11
 */
public class CachedData {
    // 缓存的map
    private Map<String, Object> map = new HashMap<>();
    // 读写锁对象
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void processCachedData() {
        readWriteLock.readLock().lock();
        try {
            if (map.isEmpty()) {
                readWriteLock.readLock().unlock();
                readWriteLock.writeLock().lock();
                try {
                    if (map.isEmpty()) {
                        this.putData();
                        System.out.println("cache completed!");
                    }
                    readWriteLock.readLock().lock();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    readWriteLock.writeLock().unlock();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    private void putData() {
        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i), new Random().nextInt(100));
        }
    }

    public static void main(String[] args) {
        CachedData cachedData = new CachedData();
        for (int i = 1; i <= 1000; i++) {
            new Thread(cachedData::processCachedData, String.valueOf(i)).start();
        }
        for (Map.Entry<String, Object> stringObjectEntry : cachedData.map.entrySet()) {
            System.out.print("keys:" + stringObjectEntry.getKey() + "\t");
        }
        System.out.println();
        for (Map.Entry<String, Object> stringObjectEntry : cachedData.map.entrySet()) {
            System.out.print("values:" + stringObjectEntry.getValue() + "\t");
        }
    }
}
