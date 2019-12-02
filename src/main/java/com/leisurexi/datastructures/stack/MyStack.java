package com.leisurexi.datastructures.stack;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;

/**
 * @Author: leisurexi
 * @Description: leetcode题号225 用队列实现栈
 * @Date: 2019/11/1
 * @Time: 15:34
 */
@Slf4j
public class MyStack {

    /**
     * 题目描述:
     * 使用队列实现栈的下列操作：
     * <p>
     * push(x) -- 元素 x 入栈
     * pop() -- 移除栈顶元素
     * top() -- 获取栈顶元素
     * empty() -- 返回栈是否为空
     * 注意:
     * <p>
     * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
     * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
     * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
     */


    /**
     * 思路:
     * 栈是一种 后进先出（last in - first out， LIFO）的数据结构，栈内元素从顶端压入（push），从顶端弹出（pop）。
     * 一般我们用数组或者链表来实现栈，但是这篇文章会来介绍如何用队列来实现栈。队列是一种与栈相反的 先进先出（first in - first out， FIFO）的数据结构，
     * 队列中元素只能从 后端（rear）入队（push），然后从 前端（front）端出队（pop）。为了满足栈的特性，我们需要维护两个队列 q1 和 q2。
     * 同时，我们用一个额外的变量来保存栈顶元素。
     * <p>
     * 算法:
     * 压入（push）:
     * 新元素永远从 q1 的后端入队，同时 q1 的后端也是栈的 栈顶（top）元素。
     * 复杂度分析:
     * 时间复杂度：O(1)O(1)
     * 队列是通过数组来实现的，入队（add）操作的时间复杂度为 O(1)O(1)。
     * 空间复杂度：O(1)O(1)
     * 弹出（pop）:
     * 我们需要把栈顶元素弹出，就是 q1 中最后入队的元素。
     * 考虑到队列是一种 FIFO 的数据结构，最后入队的元素应该在最后被出队。因此我们需要维护另外一个队列 q2，这个队列用作临时存储 q1 中出队的元素。
     * q2 中最后入队的元素将作为新的栈顶元素。接着将 q1 中最后剩下的元素出队。我们通过把 q1 和 q2 互相交换的方式来避免把 q2 中的元素往 q1 中拷贝。
     * 复杂度分析:
     * 时间复杂度：O(n)O(n)
     * 算法让 q1 中的 nn 个元素出队，让 n - 1n−1 个元素从 q2 入队，在这里 nn 是栈的大小。这个过程总共产生了 2n - 12n−1 次操作，时间复杂度为 O(n)O(n)。
     */

    private ArrayDeque<Integer> queue1;
    private ArrayDeque<Integer> queue2;
    private Integer top;

    public MyStack() {
        this.queue1 = new ArrayDeque<>();
        this.queue2 = new ArrayDeque<>();
    }

    public void push(int x) {
        queue1.offer(x);
        top = x;
    }

    public int pop() {
        while (queue1.size() > 1) {
            top = queue1.remove();
            queue2.add(top);
        }
        Integer tempTop = queue1.remove();
        ArrayDeque<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return tempTop;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        log.info("栈顶元素: {}", stack.top());
        log.info("弹出栈顶元素: {}", stack.pop());
        log.info("栈是否为空: {}", stack.empty());
    }

}
