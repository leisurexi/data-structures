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

    public SinglyLinkedList(String str) {
        for (char c : str.toCharArray()) {
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
        // 快指针
        Node fastPointer = this.head;
        // 慢指针
        Node slowPointer = this.head;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }

        Node reverseNode = reverse(slowPointer);
        Node headNode = this.head;
        boolean isPalin = true;
        while (headNode != null && reverseNode != null) {
            if (headNode.e.equals(reverseNode.e)) {
                headNode = headNode.next;
                reverseNode = reverseNode.next;
            } else {
                isPalin = false;
                break;
            }
        }
        return isPalin;
    }

    /**
     * 翻转链表
     * <p>
     * 1 -> 2 -> 3
     * next: 2->3
     * head: 1->null
     * reverseHead: 1->null
     * head: 2->3
     */
    private Node reverse(Node head) {
        Node reverseHead = null;
        while (head != null) {
            Node next = head.next;
            head.next = reverseHead;
            reverseHead = head;
            head = next;
        }
        return reverseHead;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = this.head;
        do {
            sb.append(node.e + "\n");
        } while ((node = node.next) != null);
        return sb.toString();
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
        String[] strs = {"aba", "abb", "abba", "qwerewq"};
        for (String str : strs) {
            SinglyLinkedList linkedList = new SinglyLinkedList(str);
            boolean isPalindrome = linkedList.isPalindrome();
            System.out.println(isPalindrome);
        }
    }

}
