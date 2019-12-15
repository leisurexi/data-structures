package com.leisurexi.datastructures.algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * @author: leisurexi
 * @date: 2019-12-15 9:11 下午
 * @description:
 * @since JDK 1.8
 */
@Slf4j
public class LRUCache {

    private Node head;
    private Node tail;

    /**
     * 缓存存储上限
     */
    private int limit;

    private HashMap<String, Node> hashMap;

    public LRUCache(int limit) {
        this.limit = limit;
        hashMap = new HashMap<>();
    }

    public String get(String key) {
        Node node = hashMap.get(key);
        if (node == null) {
            return null;
        }
        refreshNode(node);
        return node.value;
    }

    public void put(String key, String value) {
        Node node = hashMap.get(key);
        if (node == null) {
            //如果key不存在，则插入key-value
            if (hashMap.size() >= limit) {
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);
            }
            node = new Node(key, value);
            addNode(node);
            hashMap.put(key, node);
        } else {
            //如果key存在，则刷新key-value
            node.value = value;
            refreshNode(node);
        }
    }

    public void remove(String key) {
        Node node = hashMap.get(key);
        removeNode(node);
        hashMap.remove(key);
    }

    /**
     * 刷新被访问的节点位置
     *
     * @param node 被访问的节点
     */
    private void refreshNode(Node node) {
        //如果访问的是尾节点，则无需移动节点
        if (node == tail) {
            return;
        }
        removeNode(node);
        addNode(node);
    }

    /**
     * 删除节点
     *
     * @param node 要删除的节点
     * @return
     */
    private String removeNode(Node node) {
        if (node == head && node == tail) {
            //移除位移节点
            head = null;
            tail = null;
        } else if (node == head) {
            //移除头节点
            head = head.next;
        } else if (node == tail) {
            //移除尾节点
            tail = tail.pre;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }

    /**
     * 尾部插入节点
     *
     * @param node 要插入的节点
     */
    private void addNode(Node node) {
        if (tail != null) {
            tail.next = node;
            node.pre = tail;
            node.next = null;
        }
        tail = node;
        if (head == null) {
            head = node;
        }
    }

    private static class Node {
        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public Node pre;
        public Node next;
        public String key;
        public String value;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        cache.put("001", "用户1信息");
        cache.put("002", "用户2信息");
        cache.put("003", "用户3信息");
        cache.put("004", "用户4信息");
        cache.put("005", "用户5信息");
        cache.get("002");
        cache.put("004", "用户4信息更新");
        cache.put("006", "用户6信息");
        log.info(cache.get("001"));
        log.info(cache.get("006"));
    }

}
