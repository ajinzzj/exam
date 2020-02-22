package com.exam.naver.three;

/**
 * description: 自定义队列
 * author:zzj
 * create:2020/2/22 11:23
 */
public class OwnQueue {
    private int size;
    private int[] arr;
    private int rear;

    public OwnQueue(int size) {
        if (size < 0) {
            System.out.println("队列容量不能小于0");
        } else {
            this.size = size;
            arr = new int[size];
            rear = -1;
        }
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public boolean isFull() {
        return rear == size - 1;
    }

    public boolean push(int data) {
        if (isFull()) {
            try {
                throw new RuntimeException("队列已满，不能添加");
            } catch (Exception e) {
                return false;
            }
        } else {
            arr[++rear] = data;
            return true;
        }
    }

    public int pop() {
        return arr[rear];
    }

    public Object peek() {
        if (rear == -1) {
            return null;
        } else {
            return arr[0];
        }
    }
}
