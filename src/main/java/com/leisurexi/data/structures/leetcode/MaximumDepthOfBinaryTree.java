package com.leisurexi.data.structures.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * leetcode题号 104.二叉树的最大深度
 * 题目地址：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * @author: leisurexi
 * @date: 2020-04-08 23:01
 * @since JDK 1.8
 */
@Slf4j
public class MaximumDepthOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return depth(root, 1);
    }

    public int depth(TreeNode root, int i) {
        if (root == null) {
            return 0;
        }
        if (root.left != null || root.right != null) {
            i++;
        }
        i += Math.max(depth(root.left, 0), depth(root.right, 0));
        return i;
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.left.left = new TreeNode(4);
        node1.right = new TreeNode(3);
        log.info(String.valueOf(maxDepth(node1)));
    }

}
