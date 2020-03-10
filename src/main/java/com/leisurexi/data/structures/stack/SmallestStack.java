package com.leisurexi.data.structures.stack;

import lombok.extern.slf4j.Slf4j;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author: leisurexi
 * @date: 2019-12-12 9:17 下午
 * @description: 最小栈示例
 * 详细解法步骤:
 * 1.设原有的栈叫作栈A，此时创建一个额外的"备胎"栈B，用于辅助栈A。
 * 2.当第1个元素进入栈A时，让新元素也进入栈B。这个唯一的元素是栈A的当前最小值。
 * 3.之后，每当新元素进入栈A时，比较新元素和栈A当前最小值的大小，如果小于栈A当前
 * 最小值，则让新元素进入栈B，此时栈B的栈顶元素就是栈A当前最小值。
 * 4.每当栈A有元素出栈时，如果出栈元素时栈A当前最小值，则让栈B的栈顶元素也出栈。
 * 此时栈B余下的栈顶元素所指向的，是栈A当中原本第2小的元素，代替刚才的出栈元素
 * 成为栈A的当前最小值。（备胎转正。）
 * 5.当调用getMin方法时，返回栈B的栈顶所存储的值，这也是栈A的最小值。
 * 显然，这个解法中进栈、出栈、取最小值的时间复杂度都是O(1)，最坏情况空间复杂度是O(n)。
 * @since JDK 1.8
 */
@Slf4j
public class SmallestStack {

    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    /**
     * 入栈操作
     *
     * @param element 入栈的元素
     */
    public void push(int element) {
        mainStack.push(element);
        if (minStack.empty() || element <= minStack.peek()) {
            minStack.push(element);
        }
    }

    /**
     * 出栈操作
     *
     * @return
     */
    public Integer pop() {
        Integer element = mainStack.pop();
        if (minStack.peek().equals(element)) {
            minStack.pop();
        }
        return element;
    }

    /**
     * 获取栈最小元素
     *
     * @return
     */
    public Integer getMin() {
        if (minStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        SmallestStack stack = new SmallestStack();
        stack.push(4);
        stack.push(9);
        stack.push(7);
        stack.push(3);
        stack.push(8);
        stack.push(5);
        log.info(String.valueOf(stack.getMin()));
        stack.pop();
        log.info(String.valueOf(stack.getMin()));
        stack.pop();
        log.info(String.valueOf(stack.getMin()));
        stack.pop();
        log.info(String.valueOf(stack.getMin()));
    }

}
