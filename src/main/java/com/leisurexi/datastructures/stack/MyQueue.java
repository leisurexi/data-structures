package com.leisurexi.datastructures.stack;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * @Author: leisurexi
 * @Description: leetcode题号232 用栈实现队列
 * @Date: 2019/11/1
 * @Time: 15:33
 */
@Slf4j
public class MyQueue {

    /**
     * 题目描述:
     * 使用栈实现队列的下列操作：
     * <p>
     * push(x) -- 将一个元素放入队列的尾部。
     * pop() -- 从队列首部移除元素。
     * peek() -- 返回队列首部的元素。
     * empty() -- 返回队列是否为空。
     * 示例:
     * <p>
     * MyQueue queue = new MyQueue();
     * <p>
     * queue.push(1);
     * queue.push(2);
     * queue.peek();  // 返回 1
     * queue.pop();   // 返回 1
     * queue.empty(); // 返回 false
     * 说明:
     * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
     * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
     * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
     */

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private Integer front;

    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    /**
     * 算法1:
     * 入队（push）:
     * 一个队列是 FIFO 的，但一个栈是 LIFO 的。这就意味着最新压入的元素必须得放在栈底。为了实现这个目的，
     * 我们首先需要把 s1 中所有的元素移到 s2 中，接着把新元素压入 s2。最后把 s2 中所有的元素弹出，再把弹出的元素压入 s1。
     * 复杂度分析
     * 时间复杂度：O(n)
     * 对于除了新元素之外的所有元素，它们都会被压入两次，弹出两次。新元素只被压入一次，弹出一次。这个过程产生了 4n + 24n+2 次操作，
     * 其中 nn 是队列的大小。由于 压入 操作和 弹出 操作的时间复杂度为 O(1)， 所以时间复杂度为 O(n)。
     * 空间复杂度：O(n)
     * 需要额外的内存来存储队列中的元素。
     *
     * 出队（pop）:
     * 直接从 s1 弹出就可以了，因为 s1 的栈顶元素就是队列的队首元素。同时我们把弹出之后 s1 的栈顶元素赋值给代表队首元素的 front 变量。
     * 复杂度分析
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     */

//    public void push(int x) {
//        while (stack1.size() > 0) {
//            stack2.push(stack1.pop());
//        }
//        stack1.push(x);
//        while (stack2.size() > 0) {
//            stack1.push(stack2.pop());
//        }
//    }
//
//    public int pop() {
//        return stack1.pop();
//    }
//
//    public int peek() {
//        return stack1.peek();
//    }
//
//    public boolean empty() {
//        return stack1.empty();
//    }


    /**
     * 算法2:
     * 入队（push）:
     * 新元素总是压入 s1 的栈顶，同时我们会把 s1 中压入的第一个元素赋值给作为队首元素的 front 变量。
     * 复杂度分析:
     * 时间复杂度：O(1)
     * 向栈压入元素的时间复杂度为O(1)
     * 空间复杂度：O(n)O
     * 需要额外的内存来存储队列元素
     *
     * 出队（pop）:
     * 根据栈 LIFO 的特性，s1 中第一个压入的元素在栈底。为了弹出 s1 的栈底元素，我们得把 s1 中所有的元素全部弹出，
     * 再把它们压入到另一个栈 s2 中，这个操作会让元素的入栈顺序反转过来。通过这样的方式，s1 中栈底元素就变成了 s2 的栈顶元素，
     * 这样就可以直接从 s2 将它弹出了。一旦 s2 变空了，我们只需把 s1 中的元素再一次转移到 s2 就可以了。
     * 复杂度分析:
     * 时间复杂度： 摊还复杂度 O(1)，最坏情况下的时间复杂度 O(n)
     * 在最坏情况下，s2 为空，算法需要从 s1 中弹出 nn 个元素，然后再把这 nn 个元素压入 s2，在这里nn代表队列的大小。
     * 这个过程产生了 2n 步操作，时间复杂度为 O(n)。但当 s2 非空时，算法就只有 O(1)O(1) 的时间复杂度。所以为什么叫做摊还复杂度 O(1) 呢？ 读了下一章你就知道了。
     * 空间复杂度 ：O(1)
     *
     * 摊还分析:
     * 摊还分析给出了所有操作的平均性能。摊还分析的核心在于，最坏情况下的操作一旦发生了一次，那么在未来很长一段时间都不会再次发生，这样就会均摊每次操作的代价。
     * 来看下面这个例子，从一个空队列开始，依次执行下面这些操作：
     * push1,push2,…,pushn,pop1,pop2…,popn
     * 单次 出队 操作最坏情况下的时间复杂度为 O(n)。考虑到我们要做 n 次出队操作，如果我们用最坏情况下的时间复杂度来计算的话，那么所有操作的时间复杂度为 O(n^2)O(n2)。
     * 然而，在一系列的操作中，最坏情况不可能每次都发生，可能一些操作代价很小，另一些代价很高。因此，如果用传统的最坏情况分析，那么给出的时间复杂度是远远大于实际的复杂度的。
     * 例如，在一个动态数组里面只有一些插入操作需要花费线性的时间，而其余的一些插入操作只需花费常量的时间。
     * 在上面的例子中，出队 操作最多可以执行的次数跟它之前执行过 入队 操作的次数有关。虽然一次 出队 操作代价可能很大，但是每 n 次入队才能产生这么一次代价为 n 的出队操作。
     * 因此所有操作的总时间复杂度为：n(所有的入队操作产生） + 2 * n(第一次出队操作产生） + n - 1(剩下的出队操作产生）， 所以实际时间复杂度为 O(2*n)。
     * 于是我们可以得到每次操作的平均时间复杂度为 O(2n/2n)=O(1)。
     *
     */

    public void push(int x) {
        if (stack1.empty()) {
            front = x;
        }
        stack1.push(x);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (!stack2.empty()) {
            return stack2.peek();
        }
        return front;
    }

    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        log.info("队列第一个元素: {}", queue.peek());
        log.info("移除第一个元素: {}", queue.pop());
        log.info("队列第一个元素: {}", queue.peek());
        log.info("添加一个元素");
        queue.push(4);
        log.info("队列第一个元素: {}", queue.peek());
    }

}
