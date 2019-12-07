package com.leisurexi.datastructures.tree;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: leisurexi
 * @date: 2019-12-05 8:24 下午
 * @description: 二叉树查找树示例代码
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
    public static void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        log.info(String.valueOf(node.data));
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    /**
     * 二叉树非递归前序遍历
     *
     * @param root 二叉树根节点
     */
    public static void preOrderTraversalWithStack(TreeNode root) {
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
    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.leftChild);
        log.info(String.valueOf(node.data));
        inOrderTraversal(node.rightChild);
    }

    /**
     * 二叉树非递归后序遍历
     *
     * @param root 二叉树根节点
     */
    public static void inOrderTraversalWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            //迭代访问节点的左孩子，并入栈
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftChild;

            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                log.info(String.valueOf(treeNode.data));
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 二叉树后序遍历
     *
     * @param node 二叉树节点
     */
    public static void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        log.info(String.valueOf(node.data));
    }

    /**
     * 二叉树非递归后序遍历
     *
     * @param root 二叉树根节点
     */
    public static void postOrderTraversalWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        TreeNode lastVisit = root;
        while (treeNode != null || !stack.isEmpty()) {
            //迭代访问节点的左孩子，并入栈
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //查看当前栈顶元素
            treeNode = stack.peek();
            //如果其右子树为空，或者右子树已经访问
            //则可以直接输出当前节点的值
            if (treeNode.rightChild == null || treeNode.rightChild == lastVisit) {
                log.info(String.valueOf(treeNode.data));
                stack.pop();
                lastVisit = treeNode;
                treeNode = null;
            } else {
                //否则，继续遍历右子树
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 二叉树层序遍历
     *
     * @param root 二叉树根节点
     */
    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        int depth = depth(root);
        for (int i = 1; i <= depth; i++) {
             levelOrderTraversal(root, i);
        }
    }

    private static void levelOrderTraversal(TreeNode node, int level) {
        if (node == null || level < 1) {
            return;
        }
        if (level == 1) {
            log.info(String.valueOf(node.data));
            return;
        }
        //左子树
        levelOrderTraversal(node.leftChild, level - 1);
        //右子树
        levelOrderTraversal(node.rightChild, level - 1);
    }

    private static int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = depth(node.leftChild);
        int r = depth(node.rightChild);
        if (l > r) {
            return l + 1;
        }
        return r + 1;
    }


    /**
     * 非递归二叉树层序遍历
     *
     * @param root 二叉树根节点
     */
    public static void levelOrderTraversalWithQueue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            log.info(String.valueOf(node.data));
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
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
//        log.info("前序遍历:");
//        preOrderTraversal(treeNode);
//        log.info("中序遍历:");
//        inOrderTraversal(treeNode);
//        log.info("后序遍历:");
//        postOrderTraversal(treeNode);

//        log.info("非递归前序遍历:");
//        preOrderTraversalWithStack(treeNode);
//        log.info("非递归中序遍历:");
//        inOrderTraversalWithStack(treeNode);
//        log.info("非递归后序遍历:");
//        postOrderTraversalWithStack(treeNode);


        log.info("非递归层序遍历");
        levelOrderTraversalWithQueue(treeNode);
        log.info("层序遍历");
        levelOrderTraversal(treeNode);
    }

}
