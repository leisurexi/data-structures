package com.leisurexi.data.structures.array;

/**
 * 数组实现 LRU（Least Recently UsedLeast Recently Used） 缓存淘汰算法
 *
 * @author: leisurexi
 * @date: 2020-10-07 19:22
 */
public class LRUBasedArray<E> {

    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 容量
     */
    private Object[] data;

    /**
     * 数量
     */
    private int size;

    public LRUBasedArray() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBasedArray(int capacity) {
        this.data = new Object[capacity];
    }

    public boolean add(E e) {
        if (size != data.length) {
            size++;
        }
        System.arraycopy(data, 0, data, 1, data.length - 1);
        data[0] = e;
        return true;
    }

    public boolean remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index must be more than -1 and less than size");
        }
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;
        return true;
    }

    public E get(int index) {
        E element = (E) data[index];
        remove(index);
        add(element);
        return element;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            Object obj = data[i];
            if (obj == null) {
                break;
            }
            sb.append(obj + ",");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        LRUBasedArray<String> lruBasedArray = new LRUBasedArray<>(3);
        lruBasedArray.add("1");
        lruBasedArray.add("2");
        lruBasedArray.add("3");
        System.out.println(lruBasedArray);
        lruBasedArray.get(2);
        System.out.println(lruBasedArray);
        lruBasedArray.get(1);
        System.out.println(lruBasedArray);
        lruBasedArray.get(2);
        System.out.println(lruBasedArray);
    }

}
