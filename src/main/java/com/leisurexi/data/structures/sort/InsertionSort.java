package com.leisurexi.data.structures.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author: leisurexi
 * @date: 2020-11-22 22:40
 */
public class InsertionSort {

    public static void insertionSort(int[] array) {
        // 有序元素下标指针，代表该前面的元素都是有序的
        int orderedIndex = 1;
        while (orderedIndex != array.length) {
            boolean changed = false;
            int a = array[orderedIndex];
            for (int i = 0; i < orderedIndex; i++) {
                if (a < array[i]) {
                    for (int j = orderedIndex - 1; j >= i; j--) {
                        array[j + 1] = array[j];
                    }
                    array[i] = a;
                    orderedIndex++;
                    changed = true;
                    break;
                }
            }
            if (!changed) {
                orderedIndex++;
            }
        }
    }

    /**
     * 1. 遍历总元素个数减1次，因为第一个元素默认是有序的
     * 2. 倒序比较，先比较当前元素和它的前一个元素
     * 3. 如果前一个元素比当前元素大，就往后挪一位，再往前比较
     * 4. 比较到小于当前元素时或者比较完时，代表需要插入了
     */
    public static void insertionSort_2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int a = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > a) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = a;
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 6, 1, 3, 2};
        insertionSort_2(array);
        System.out.println(Arrays.toString(array));
    }

}
