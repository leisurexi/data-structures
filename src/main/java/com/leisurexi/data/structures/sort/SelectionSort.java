package com.leisurexi.data.structures.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 1.原地排序算法：不需要额外存储空间。
 * 2.不稳定的排序算法：每次需要找出未排序中元素的最小值，并和前面的元素交换位置；
 * 比如 5,8,5,2,9 这样一组数据，当第一次找到2位最小元素时，与第一个5交换位置，、
 * 那第一个5和中间位置的5位置就变了，所有不是稳定的排序算法。
 *
 * @author: leisurexi
 * @date: 2020-11-23 22:55
 */
public class SelectionSort {

    public static void selectionSort(int[] array) {
        // 初始化已排序的下标
        int sortedIndex = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = sortedIndex;
            for (int j = sortedIndex + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
            sortedIndex++;
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 6, 1, 3, 2};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

}
