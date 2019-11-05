package com.leisurexi.stack;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @Author: leisurexi
 * @Description: leetcode题号155 最小栈
 * @Date: 2019/11/1
 * @Time: 12:05
 */
@Slf4j
public class MinStack {

    /**
     * 题目描述:
     * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
     *
     * push(x) -- 将元素 x 推入栈中。
     * pop() -- 删除栈顶的元素。
     * top() -- 获取栈顶元素。
     * getMin() -- 检索栈中的最小元素。
     * 示例:
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     */

    int[] data;
    int size;
    int min;

    public MinStack() {
        data = new int[10];
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        grow();
        data[size++] = x;
        if (min > x) {
            min = x;
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int top = data[--size];
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (minValue > data[i]) {
                minValue = data[i];
            }
        }
        this.min = minValue;
        return top;
    }

    public int top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data[size - 1];
    }

    public int getMin() {
        return min;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void grow() {
        if (size == data.length) {
            int oldCapacity = data.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        log.info("栈内最小元素: {}", stack.getMin());
        log.info("弹出第一个元素");
        stack.pop();
        log.info("获取栈顶元素: {}", stack.top());
        stack.pop();
        log.info("栈内最小元素: {}", stack.getMin());
    }

}
