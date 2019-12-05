package com.leisurexi.datastructures.tree;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: leisurexi
 * @date: 2019-12-05 8:24 下午
 * @description: 二叉树示例代码
 * @since JDK 1.8
 */
@Slf4j
public class BinaryTree {

    /**
     * 构建二叉树
     *
     * @param inputList 输入序列
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        //这里的判空很关键: 如果元素是空，则不再进一步递归
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 二叉树前序遍历
     *
     * @param node 二叉树节点
     */
    public static void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        log.info(String.valueOf(node.data));
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    /**
     * 二叉树非递归前序遍历
     *
     * @param root 二叉树根节点
     */
    public static void preOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            //迭代访问节点的左孩子，并入栈
            while (treeNode != null) {
                log.info(String.valueOf(treeNode.data));
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 二叉树中序遍历
     *
     * @param node 二叉树节点
     */
    public static void inOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraveral(node.leftChild);
        log.info(String.valueOf(node.data));
        inOrderTraveral(node.rightChild);
    }

    /**
     * 二叉树后序遍历
     *
     * @param node 二叉树节点
     */
    public static void postOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraveral(node.leftChild);
        postOrderTraveral(node.rightChild);
        log.info(String.valueOf(node.data));
    }

    /**
     * 二叉树节点
     */
    @ToString
    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList =
                new LinkedList<>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode treeNode = createBinaryTree(inputList);
        log.info("前序遍历:");
        preOrderTraveral(treeNode);
        log.info("中序遍历:");
        inOrderTraveral(treeNode);
        log.info("后序遍历:");
        postOrderTraveral(treeNode);
        log.info("TreeNode: {}", treeNode);

        log.info("非递归前序遍历:");
        preOrderTraveralWithStack(treeNode);
    }

}
