package com.leisurexi.data.structures.stack;

import java.util.Arrays;

/**
 * 动态数组实现栈，当数组长度不够时会自动扩容
 *
 * @author: leisurexi
 * @date: 2020-10-15 14:09
 */
public class DynamicArrayStack<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] data;
    private int size;
    private int capacity;

    public DynamicArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public DynamicArrayStack(int initialCapacity) {
        this.data = new Object[initialCapacity];
        this.capacity = initialCapacity;
    }

    public boolean push(E e) {
        ensureCapacityInternal(size + 1);
        data[size++] = e;
        return true;
    }

    public E pop() {
        if (size == 0) {
            return null;
        }
        int index = --size;
        E e = (E) data[index];
        data[index] = null;
        return e;
    }

    public E peer() {
        if (size == 0) {
            return null;
        }
        return (E) data[size - 1];
    }

    public void clear() {
        size = 0;
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
    }

    private void ensureCapacityInternal(int size) {
        if (size > capacity) {
            int newCapacity = capacity << 1;
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = data.length - 1; i >= 0; i--) {
            Object e = data[i];
            if (e != null) {
                sb.append(e);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DynamicArrayStack<String> stack = new DynamicArrayStack<>(3);
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        System.out.println(stack);
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack);
    }

}
