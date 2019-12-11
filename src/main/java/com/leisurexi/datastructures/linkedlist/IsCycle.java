package com.leisurexi.datastructures.linkedlist;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: leisurexi
 * @date: 2019-12-11 10:06 下午
 * @description: 判断链表是否有环
 * @since JDK 1.8
 */
@Slf4j
public class IsCycle {

    /**
     * 判断是否有环
     *
     * @param head 链表头节点
     * @return
     */
    public static boolean isCycle(Node head) {
        Node p1 = head;
        Node p2 = head;
        int count = 0;
        while (p2 != null && p2.next != null) {
            count++;
            p1 = p1.next;
            p2 = p2.next.next;
            /**
             * 当两个指针首次相遇，证明链表有环的时候，让两个指针从相遇点继续循环前进，
             * 并统计前进的循环次数，直到两个指针第2次相遇。此时，统计出来的前进次数就
             * 数环长。
             * 因为指针p1每次走1步，指针p2每次走2步，两者的速度查是1步。当两个指针再
             * 次相遇时，p2比p1多走了整整1圈。
             * 因此，环长 = 每一次速度 * 前进次数 = 前进次数。
             */
            if (p1 == p2) {
                log.info("环长: {}", 1 * count);

                /**
                 * 抽象图: http://ww1.sinaimg.cn/large/006Vpl27gy1g9t5xs3xlfj321k0yikjn.jpg
                 * 假设从链表头节点到入环点的距离是D，从入环点到两个指针首次相遇点的
                 * 距离是S1，从首次相遇点回到入环点的距离是S2。
                 * 那么，当两个指针首次相遇时，各自所走的距离是多少呢？
                 * 指针p1一次只走1步，所走的距离是D+S1。
                 * 指针p2一次走2步，多走了n(n>=1)整圈，所走的距离是D+S1+n(S1+S2)。
                 * 由于p2的速度是p1的2倍，所以所走距离也是p1的2倍，因此:
                 *              2(D+S1) = D+S1+n(S1+S2)
                 * 等式经过整理得出:
                 *             D = (n-1)(S1+S2)+S2
                 * 也就是说，从链表头节点到入环点的距离，等于从首次相遇点绕环n-1圈再
                 * 回到入环点的距离。
                 * 这样一来，只要把其中一个指针放回到头节点位置，另一个指针保持在首次
                 * 相遇点，两个指针都是每次向前走1步。那么，它们最终相遇的节点，就是
                 * 入环点。
                 */
                p1 = head;
                for (; ; ) {
                    p1 = p1.next;
                    p2 = p2.next;
                    if (p1 == p2) {
                        log.info("入环点: {}", p1);
                        break;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 链表节点
     */
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(2);
        Node node5 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;
        log.info("链表是否有环: {}", isCycle(node1));
    }

}
