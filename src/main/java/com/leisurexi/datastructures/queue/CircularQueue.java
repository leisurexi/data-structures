package com.leisurexi.datastructures.queue;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author: leisurexi
 * @date: 2019-12-03 9:54 下午
 * @description: 循环队列示例
 * @since JDK 1.8
 */
@Slf4j
public class CircularQueue {

    private int[] array;
    /**
     * 队头下标
     */
    private int front;
    /**
     * 队尾下标
     */
    private int rear;

    public CircularQueue(int capacity) {
        this.array = new int[capacity];
    }

    /**
     * 入队
     *
     * @param element 入队的元素
     */
    public void enQueue(int element) {
        if (getIndex(rear) == front) {
            throw new IllegalStateException("queue is full");
        }
        array[rear] = element;
        rear = getIndex(rear);
    }

    /**
     * 出队
     *
     * @return
     */
    public int deQueue() {
        if (rear == front) {
            throw new IllegalStateException("queue is empty");
        }
        int deQueueElement = array[front];
        front = getIndex(front);
        return deQueueElement;
    }

    /**
     * 输出队列
     */
    public void output() {
//        for (int i = front; i != rear; i = getIndex(i)) {
//            log.info(String.valueOf(i));
//        }
        log.info(Arrays.toString(array));
        log.info("队头下标: {}", front);
        log.info("队尾下标: {}", rear);
    }

    private int getIndex(int index) {
        return (index + 1) % array.length;
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(6);
        queue.enQueue(3);
        queue.enQueue(5);
        queue.enQueue(6);
        queue.enQueue(8);
        queue.enQueue(1);
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.enQueue(2);
        queue.enQueue(4);
        queue.enQueue(9);
        queue.output();
    }

}
