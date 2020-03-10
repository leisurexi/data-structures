package com.leisurexi.data.structures.stack;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: leisurexi
 * @Description: 基于链表实现的栈
 * 像数组那样在尾部插入删除。大家都知道链表效率低在查询。而查询到尾部效率很低。而我们就算使用了尾指针，
 * 可以解决尾部插入效率。但是依然无法解决删除效率（删除需要找到前节点）。
 * 所以我们采用带头结点的单链表在头部插入删除，把头部当做栈顶。插入直接在头结点后插入。而删除也直接删除有机诶单后第一个元素即可。
 * @Date: 2019/10/31
 * @Time: 16:28
 */
@Slf4j
public class LinkedStack<E> {

    private Node<E> head;
    private int size;

    static class Node<E> {
        E e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
    }

    public void push(E e) {
        if (isEmpty()) {
            head = new Node<>(e, null);
        } else {
            Node<E> old = head;
            Node<E> node = new Node<>(e, old);
            head = node;
        }
        size++;
    }

    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        Node<E> old = head;
        head = old.next;
        size--;
        return old.e;
    }

    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        return head.e;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        int capacity = 5;
        LinkedStack<Integer> stack = new LinkedStack<>();
        for (int i = 0; i < capacity; i++) {
            stack.push(i);
        }
        log.info("栈内元素个数: {}", stack.size());
        for (int i = 0; i < capacity; i++) {
            log.info(String.valueOf(stack.peek()));
        }
        for (int i = 0; i < capacity; i++) {
            log.info(String.valueOf(stack.pop()));
        }
        switch (1){
            case 'a':

        }
    }

}
