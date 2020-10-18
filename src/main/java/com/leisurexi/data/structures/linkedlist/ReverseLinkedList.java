package com.leisurexi.data.structures.linkedlist;

/**
 * 206. 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author: leisurexi
 * @date: 2020-10-18 21:18
 */
public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 迭代解法
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        while (temp.next != null) {
            // 下一节点
            ListNode next = temp.next;
            temp.next = next.next;
            next.next = head;
            head = next;
        }
        return head;
    }

    /**
     * 递归解法
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public String toString(ListNode listNode) {
        StringBuffer sb = new StringBuffer();
        do {
            sb.append(listNode.val + "->");
        } while ((listNode = listNode.next) != null);
        return sb.toString();
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        ReverseLinkedList linkedList = new ReverseLinkedList();
//        System.out.println(linkedList.toString(linkedList.reverseList(listNode)));
        ListNode node = linkedList.reverseList2(listNode);
        System.out.println(linkedList.toString(node));
    }

}
