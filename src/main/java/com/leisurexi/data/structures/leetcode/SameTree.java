package com.leisurexi.data.structures.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 100.相同的树
 * 题目地址: https://leetcode-cn.com/problems/same-tree/
 *
 * @author: leisurexi
 * @date: 2020-04-03 22:42
 * @since JDK 1.8
 */
@Slf4j
public class SameTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> list1 = new ArrayList<>();
        frontTraversal(p, list1);
        log.info(String.valueOf(list1));
        List<Integer> list2 = new ArrayList<>();
        frontTraversal(q, list2);
        log.info(String.valueOf(list2));
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 二叉树前序遍历
     *
     * @param node 当前节点
     * @param list 存放节点值的集合
     */
    private void frontTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            // 如果节点为空给默认值
            list.add(0);
            return;
        }
        list.add(node.val);
        frontTraversal(node.left, list);
        frontTraversal(node.right, list);
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        node2.left = new TreeNode(2);
        node2.right = new TreeNode(3);
        log.info(String.valueOf(isSameTree(node1, node2)));
    }

}
