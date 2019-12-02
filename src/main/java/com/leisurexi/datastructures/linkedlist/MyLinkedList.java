package com.leisurexi.datastructures.linkedlist;


import lombok.extern.slf4j.Slf4j;

/**
 * @author: leisurexi
 * @date: 2019-12-02 10:19 下午
 * @description: 链表示例
 * @since JDK 1.8
 */
@Slf4j
public class MyLinkedList {

    /**
     * 头节点指针
     */
    private Node head;
    /**
     * 尾节点指针
     */
    private Node tail;
    /**
     * 链表实际长度
     */
    private int size;

    /**
     * 链表节点
     */
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 链表插入元素
     *
     * @param index 插入的下标
     * @param data  插入的元素
     */
    public void insert(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index must be greater than or equal to zero and lower than size");
        }
        Node node = new Node(data);
        if (size == 0) {
            //空链表
            head = node;
            tail = node;
        } else if (index == 0) {
            //插入首部插入节点
            node.next = head;
            head = node;
        } else if (index == size) {
            //链表尾部插入节点
            tail.next = node;
            tail = node;
        } else {
            //插入中间
            Node prev = get(index - 1);
            node.next = prev.next;
            prev.next = node;
        }
        size++;
    }

    /**
     * 链表删除元素
     *
     * @param index 删除元素的下标
     * @return
     */
    public Node remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index must be greater than or equal to zero and lower than size");
        }
        Node removeNode;
        if (index == 0) {
            //删除首节点
            removeNode = head;
            head = head.next;
        } else if (index == size) {
            //删除尾节点
            removeNode = tail;
            tail = get(size - 1);
        } else {
            //删除中间节点
            Node prev = get(index - 1);
            Node next = prev.next.next;
            removeNode = prev.next;
            prev.next = next;
        }
        size--;
        return removeNode;
    }

    /**
     * 根据位置获取节点
     *
     * @param index 位置
     * @return
     */
    private Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 输出链表
     */
    public void output() {
        Node temp = head;
        while (temp != null) {
            log.info(String.valueOf(temp.data));
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert(0, 3);
        myLinkedList.insert(1, 7);
        myLinkedList.insert(2, 9);
        myLinkedList.insert(3, 5);
        myLinkedList.insert(1, 6);
        myLinkedList.output();
        myLinkedList.remove(1);
        myLinkedList.output();
    }

}
