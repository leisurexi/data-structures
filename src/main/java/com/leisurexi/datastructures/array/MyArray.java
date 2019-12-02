package com.leisurexi.datastructures.array;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author: leisurexi
 * @date: 2019-12-02 9:25 下午
 * @description: 数组中间插入操作
 * @since JDK 1.8
 */
@Slf4j
public class MyArray {

    private int[] array;
    private int size;

    public MyArray(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
    }

    /**
     * 数组插入元素
     *
     * @param index   插入的下标
     * @param element 插入的元素
     */
    public void insert(int index, int element) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("index must be greater than or equal to zero and lower than array length");
        }
        if (size >= array.length) {
            resize();
        }
        //从右向左循环，将元素逐个向右挪1位
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        //腾出的位置放入新元素
        array[index] = element;
        size++;
    }

    /**
     * 删除元素
     *
     * @param index 删除的下标
     */
    public int delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index must be greater than or equal to zero and lower than size");
        }
        int deletedElement = array[index];
        //从左向右循环，将元素逐个向左挪1位
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        //恢复默认值
        array[size - 1] = 0;
        size--;
        return deletedElement;
    }

    /**
     * 数组扩容
     */
    public void resize() {
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    /**
     * 输出数组
     */
    public void output() {
        log.info(Arrays.toString(array));
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray(4);
        myArray.insert(0, 3);
        myArray.insert(1, 7);
        myArray.insert(2, 9);
        myArray.insert(3, 5);
        myArray.insert(1, 6);
        myArray.output();
        myArray.delete(3);
        myArray.output();
    }

}
