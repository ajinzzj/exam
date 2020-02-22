package com.exam.naver.one;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description: 所有任务方法
 * author:zzj
 * create:2020/2/22 10:45
 */
public class Methods {
    private int number = 1;//当前正在执行线程标记

    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();
    private Condition conditionD = lock.newCondition();
    private Condition conditionE = lock.newCondition();
    private Condition conditionF = lock.newCondition();
    private Condition conditionG = lock.newCondition();
    private Condition conditionH = lock.newCondition();

    //Test output: Task H, Task B, Task G, Task C, Task E, Task A, Task D, Task F
    public void methodA() {
        lock.lock();

        try {
            //判断
            if (number != 6) {
                conditionA.await();
            }
            //打印
            System.out.println(Thread.currentThread().getName());
            //唤醒
            number = 7;
            conditionD.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();

        }
    }

    public void methodB() {
        lock.lock();

        try {
            //判断
            if (number != 2) {
                conditionB.await();
            }
            //打印
            System.out.println(Thread.currentThread().getName());

            //唤醒
            number = 3;
            conditionG.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();

        }
    }

    public void methodC() {
        lock.lock();

        try {
            //判断
            if (number != 4) {
                conditionC.await();
            }
            //打印
            System.out.println(Thread.currentThread().getName());
            //唤醒
            number = 5;
            conditionE.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();

        }
    }

    public void methodD() {
        lock.lock();

        try {
            //判断
            if (number != 7) {
                conditionD.await();
            }
            //打印
            System.out.println(Thread.currentThread().getName());
            //唤醒
            number = 8;
            conditionF.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();

        }
    }

    public void methodE() {
        lock.lock();

        try {
            //判断
            if (number != 5) {
                conditionE.await();
            }
            //打印
            System.out.println(Thread.currentThread().getName());
            //唤醒
            number = 6;
            conditionA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();

        }
    }

    public void methodF() {
        lock.lock();

        try {
            //判断
            if (number != 8) {
                conditionF.await();
            }
            //打印
            System.out.println(Thread.currentThread().getName());
            //唤醒
            number = 1;
            conditionH.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();

        }
    }

    public void methodG() {
        lock.lock();

        try {
            //判断
            if (number != 3) {
                conditionG.await();
            }
            //打印
            System.out.println(Thread.currentThread().getName());

            //唤醒
            number = 4;
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();

        }
    }

    public void methodH() {
        lock.lock();

        try {
            //判断
            if (number != 1) {
                conditionH.await();
            }
            //打印
            System.out.println(Thread.currentThread().getName());
            //唤醒
            number = 2;
            conditionB.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();

        }
    }
}
