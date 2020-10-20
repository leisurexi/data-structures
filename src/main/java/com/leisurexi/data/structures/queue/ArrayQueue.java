package com.leisurexi.data.structures.queue;


import java.util.Arrays;

/**
 * 用数组实现队列
 *
 * @author: leisurexi
 * @date: 2020-10-20 23:22
 */
public class ArrayQueue<E> {

    private Object[] data;
    /**
     * 队列容量
     */
    private int n;
    /**
     * 队头下标
     */
    private int head;
    /**
     * 队尾下标
     */
    private int tail;

    public ArrayQueue(int capacity) {
        this.data = new Object[capacity];
        this.n = capacity;
    }

    public boolean enqueue(E e) {
        // 表示已经到队列末尾
        if (tail == n) {
            if (head == 0) {
                // 队列已满
                return false;
            }
            for (int i = head; i < tail; i++) {
                data[i - head] = data[i];
            }
            // 搬移完数据后更新 head 和 tail
            tail -= head;
            head = 0;
        }
        data[tail++] = e;
        return true;
    }

    public E dequeue() {
        // 如果 head == tail 表示队列为空
        if (head == tail) {
            return null;
        }
        Object ret = data[head++];
        return (E) ret;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue);
        queue.enqueue(4);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.enqueue(5);
        System.out.println(queue);
    }

}
