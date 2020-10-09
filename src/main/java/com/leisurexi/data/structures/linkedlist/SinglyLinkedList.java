package com.leisurexi.data.structures.linkedlist;

import java.util.LinkedList;

/**
 * 链表实现判断一个字符串是否是回文字符串
 *
 * @author: leisurexi
 * @date: 2020-10-09 11:03
 */
public class SinglyLinkedList {

    private Node head;

    public void addFirst(String value) {
        for (char c : value.toCharArray()) {
            Node newNode = new Node(c, head);
            head = newNode;
        }
    }

    /**
     * 判断是否是回文字符串
     *
     * @return {@code true} 是回文字符串 {@code false} 不是回文字符串
     * <p>
     * 1 -> 2 -> 3
     */
    public boolean isPalindrome() {
        Node fastPointer = this.head;
        Node slowPointer = this.head;
        while (fastPointer.next != null && slowPointer.next.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }

        if (fastPointer != null) {
            // 奇数个节点
            Node leftLink = null;
            Node rightLink = null;



        } else {
            // 偶数个节点


        }


        return false;
    }

    /**
     * 翻转链表
     * <p>
     * 1 -> 2 -> 3
     * 2
     */
    public Node reverseLinkedList(Node head) {

        return null;
    }


    private static class Node {
        private Character e;
        private Node next;

        public Node(Character e, Node next) {
            this.e = e;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();


    }

}
