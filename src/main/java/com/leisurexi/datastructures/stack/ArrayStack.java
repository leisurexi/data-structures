package com.leisurexi.datastructures.stack;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: leisurexi
 * @Description: 用数组实现的栈
 * 对于数组来说，模拟栈的过程很简单，因为栈是后进先出，很容易在数组的末尾进行插入和删除。所有选定末尾为栈顶。
 * 所以对于一个栈所需要的基础元素是 一个data数组和一个top(int)表示栈顶的位置。
 * @Date: 2019/10/31
 * @Time: 14:30
 */
@Slf4j
public class ArrayStack<E> {

    private E[] data;
    private int top;

    public ArrayStack() {
        this.data = (E[]) new Object[10];
        this.top = -1;
    }

    public ArrayStack(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.top = -1;
    }

    /**
     * 入栈，如果top==数组长度，栈满
     *
     * @param e
     * @return
     */
    public boolean push(E e) {
        if (top == data.length - 1) {
            throw new RuntimeException("栈已满");
        }
        data[++top] = e;
        return true;
    }

    /**
     * 出栈，如果top>=0栈不为空，可以弹出
     *
     * @return
     */
    public E pop() {
        if (!isEmpty()) {
            E element = data[top];
            data[top--] = null;
            return element;
        }
        throw new RuntimeException("栈为空");
    }

    /**
     * 返回栈顶元素，不弹出
     *
     * @return
     */
    public E peek() {
        if (!isEmpty()) {
            return data[top];
        }
        throw new RuntimeException("栈为空");
    }

    /**
     * 返回栈是否为空
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 返回元素个数
     * @return
     */
    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        int capacity = 5;
        ArrayStack<Integer> stack = new ArrayStack<>(capacity);
        for (int i = 0; i < capacity; i++) {
            stack.push(i);
        }
        log.info("栈内元素个数: {}", stack.size());
        for (int i = 0; i < capacity; i++) {
            log.info(String.valueOf(stack.peek()));
        }
        for (int i = 0; i < capacity; i++) {
            log.info(String.valueOf(stack.pop()));
        }
    }

}
