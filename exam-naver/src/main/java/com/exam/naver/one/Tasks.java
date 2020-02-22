package com.exam.naver.one;

/**
 * description: 任务顺序执行
 * author:zzj
 * create:2020/2/22 10:43
 */
public class Tasks {
    public static void main(String[] args) {
        Methods methods = new Methods();
        new Thread(methods::methodA, "taskA").start();
        new Thread(methods::methodB, "taskB").start();
        new Thread(methods::methodC, "taskC").start();
        new Thread(methods::methodD, "taskD").start();
        new Thread(methods::methodE, "taskE").start();
        new Thread(methods::methodF, "taskF").start();
        new Thread(methods::methodG, "taskG").start();
        new Thread(methods::methodH, "taskH").start();
    }
}
