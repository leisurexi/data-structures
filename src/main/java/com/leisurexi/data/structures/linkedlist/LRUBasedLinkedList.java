package com.leisurexi.data.structures.linkedlist;

/**
 * 单链表实现 LRU（Least Recently UsedLeast Recently Used） 缓存淘汰算法
 *
 * @author: leisurexi
 * @date: 2020-10-06 23:52
 */
public class LRUBasedLinkedList<E> {

    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 头节点
     */
    private Node<E> head;

    /**
     * 容量
     */
    private int capacity;

    /**
     * 数量
     */
    private int size;

    public LRUBasedLinkedList() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBasedLinkedList(int capacity) {
        this.capacity = capacity;
    }

    public Node<E> getHeadNode() {
        return head;
    }

    public Node<E> getNext(Node<E> node) {
        Node<E> next = node.next;
        if (next != null) {
            node.next = next.next;
            if (next.next != null) {
                size--;
            }
            return add(next.e);
        }
        return null;
    }

    public Node<E> add(E e) {
        Node<E> newNode = new Node<>(e, head);
        if (head == null) {
            head = newNode;
        } else {
            // 新节点放在首部
            head = newNode;
            if (size == capacity) {
                // 容量已满，删除末尾的的节点
                removeLastNode();
            } else {

            }
        }
        size++;
        return newNode;
    }

    public void removeLastNode() {
        Node<E> node = this.head;
        if (node == null) {
            // 空链表
            return;
        }
        while (node.next.next != null) {
            node = node.next;
        }
        node.next = null;
        size--;
    }

    public int size() {
        return size;
    }

    private static class Node<E> {
        E e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> node = this.head;
        do {
            sb.append(node.e + "\n");
        } while ((node = node.next) != null);
        return sb.toString();
    }

    public static void main(String[] args) {
        LRUBasedLinkedList<String> lruBasedLinkedList = new LRUBasedLinkedList<>(3);
        lruBasedLinkedList.add("1");
        lruBasedLinkedList.add("2");
        lruBasedLinkedList.add("3");
        lruBasedLinkedList.add("4");
        System.out.println("size: " + lruBasedLinkedList.size());
        Node<String> headNode = lruBasedLinkedList.getHeadNode();
        System.out.println(lruBasedLinkedList);
        Node<String> next = lruBasedLinkedList.getNext(headNode);
        System.out.println("size: " + lruBasedLinkedList.size());
        System.out.println(lruBasedLinkedList);
        Node<String> next1 = lruBasedLinkedList.getNext(next);
        System.out.println("size: " + lruBasedLinkedList.size());
        System.out.println(lruBasedLinkedList);
        Node<String> next2 = lruBasedLinkedList.getNext(next1);
        System.out.println("size: " + lruBasedLinkedList.size());
        System.out.println(lruBasedLinkedList);
    }

}
