package com.leisurexi.data.structures.queue;

/**
 * 链表实现队列
 *
 * @author: leisurexi
 * @date: 2020-10-20 23:41
 */
public class LinkedListQueue<E> {

    /**
     * 容量
     */
    private int n;
    /**
     * 头节点
     */
    private Node<E> head;
    /**
     * 尾节点
     */
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        private E e;
        private Node<E> next;

        public Node(E e, Node<E> next) {
            this.e = e;
            this.next = next;
        }
    }

    public LinkedListQueue(int capacity) {
        this.n = capacity;
    }

    public boolean enqueue(E e) {
        if (size == n) {
            return false;
        }
        Node<E> newNode = new Node<>(e, null);
        if (head == null && tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    public E dequeue() {
        if (head == null) {
            // 空队列
            return null;
        }
        Node<E> node = head;
        head = head.next;
        size--;
        return node.e;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Node<E> node = head;
        do {
            sb.append(node.e + "->");
        } while ((node = node.next) != null);
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>(3);
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
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
    }

}
