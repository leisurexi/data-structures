package com.leisurexi.data.structures.skiplist;


/**
 * 跳表实现
 *
 * @author: leisurexi
 * @date: 2021-06-24 15:49
 */
public class SkipList<T> {

    /**
     * 头节点，标记层
     */
    static class HeadIndex<T> extends Index<T> {
        /**
         * 层级
         */
        int level;

        public HeadIndex(Node<T> node, Index<T> down, Index<T> right, int level) {
            super(node, down, right);
            this.level = level;
        }
    }

    /**
     * 索引节点，内部包含真实节点
     */
    static class Index<T> {
        /**
         * 真实节点
         */
        Node<T> node;
        /**
         * 下指针（第一层索引实际上是没有下指针的）
         */
        Index<T> down;
        /**
         * 右指针
         */
        Index<T> right;

        public Index(Node<T> node, Index<T> down, Index<T> right) {
            this.node = node;
            this.down = down;
            this.right = right;
        }
    }

    /**
     * 链表中的节点，真正存数据的节点
     */
    static class Node<T> {
        /**
         * 节点元素值
         */
        T value;
        /**
         * 下一个节点
         */
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return (value == null ? "h0" : value.toString()) + "->" + (next == null ? "null" : next.toString());
        }
    }


}
