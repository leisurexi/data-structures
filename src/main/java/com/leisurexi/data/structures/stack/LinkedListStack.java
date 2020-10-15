package com.leisurexi.data.structures.stack;

/**
 * 用链表实现栈
 *
 * @author: leisurexi
 * @date: 2020-10-15 14:49
 */
public class LinkedListStack<E> {

    private Node<E> head;

    public boolean push(E e) {
        Node<E> node = new Node<>(e, head);
        head = node;
        return true;
    }

    public E pop() {
        if (head == null) {
            return null;
        }
        Node<E> node = head;
        head = head.next;
        return node.e;
    }

    private static class Node<E> {
        private E e;
        private Node<E> next;

        public Node(E e, Node<E> next) {
            this.e = e;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedListStack<String> stack = new LinkedListStack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push("f");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
