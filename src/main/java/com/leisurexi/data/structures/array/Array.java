package com.leisurexi.data.structures.array;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 精简版 ArrayList，提供添加、删除、自动扩容操作
 *
 * @author: leisurexi
 * @date: 2020-10-06 0:05
 */
@Slf4j
public class Array<T> {

    private static final int DEFAULT_SIZE = 10;

    private Object[] data;
    private int size;

    public Array() {
        this(DEFAULT_SIZE);
    }

    private Array(int initialCapacity) {
        this.data = new Object[initialCapacity];
    }

    public T get(int index) {
        return (T) data[index];
    }

    public boolean add(T e) {
        ensureCapacityInternal(size + 1);
        data[size++] = e;
        debugPrintData();
        return true;
    }

    public boolean add(int index, T e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index must be more than -1 and less than size");
        }
        ensureCapacityInternal(size + 1);
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = e;
        size++;
        debugPrintData();
        return true;
    }

    public boolean remove(T e) {
        for (int i = 0; i < data.length; i++) {
            if (e == data[i] || e.equals(data[i])) {
                return remove(i);
            }
        }
        debugPrintData();
        return false;
    }

    public boolean remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index must be more than -1 and less than size");
        }
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;
        debugPrintData();
        return true;
    }

    private void debugPrintData() {
        log.debug(Arrays.toString(data));
        log.debug(String.valueOf(size));
    }

    private void ensureCapacityInternal(int size) {
        if (size >= data.length) {
            int oldCapacity = data.length;
            int newCapacity = oldCapacity + (oldCapacity >> 2);
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        array.add(1);
        array.add(1, 2);
        array.add(2, 3);
        array.add(4);
        for (int i = 0; i < 10; i++) {
            array.add(i);
        }
        array.remove(2);
        array.remove(Integer.valueOf(2));
        System.out.println(array.get(0));
    }

}
