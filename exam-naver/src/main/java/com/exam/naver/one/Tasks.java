package com.exam.naver.one;

/**
 * description: 任务顺序执行
 * author:zzj
 * create:2020/2/22 10:43
 */
public class Tasks {
    //Test output: Task H, Task B, Task G, Task C, Task E, Task A, Task D, Task F
    public static void main(String[] args) {
        Methods methods = new Methods();
        new Thread(methods::methodA, "TaskA").start();
        new Thread(methods::methodB, "TaskB").start();
        new Thread(methods::methodC, "TaskC").start();
        new Thread(methods::methodD, "TaskD").start();
        new Thread(methods::methodE, "TaskE").start();
        new Thread(methods::methodF, "TaskF").start();
        new Thread(methods::methodG, "TaskG").start();
        new Thread(methods::methodH, "TaskH").start();
    }
}
