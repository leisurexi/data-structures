package com.leisurexi.data.structures.queue;

import java.util.Arrays;

/**
 * 用数组实现循环队列
 *
 * @author: leisurexi
 * @date: 2020-10-22 16:25
 */
public class CircularQueue<E> {

    private Object[] data;
    /**
     * 容量
     */
    private int n;
    /**
     * 头指针
     */
    private int head;
    /**
     * 尾指针
     */
    private int tail;

    public CircularQueue(int capacity) {
        this.data = new Object[capacity];
        this.n = capacity;
    }

    public boolean enqueue(E e) {
        if ((tail + 1) % n == head) {
            return false;
        }
        data[tail] = e;
        tail = (tail + 1) % n;
        return true;
    }

    public E dequeue() {
        if (head == tail) {
            // 队列为空
            return null;
        }
        Object obj = data[head];
        head = (head + 1) % n;
        return (E) obj;
    }

    @Override
    public String toString() {
        return "head: " + head + ", tail: " + tail + ", data: " + Arrays.toString(data);
    }

    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<>(3);
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue);
        // 入队失败
        queue.enqueue(3);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.enqueue(4);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.enqueue(5);
        System.out.println(queue);
    }

}
