package com.leisurexi.data.structures.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author: leisurexi
 * @date: 2019-12-08 12:49 下午
 * @description: 冒泡排序
 * @since JDK 1.8
 */
@Slf4j
public class BubbleSort {

    /**
     * 冒泡排序第一版:
     * 使用双重循环进行排序。外部循环控制所有的回合，内部循环实现每一轮的冒泡处理，
     * 先进行元素比较，再进行元素交换
     *
     * @param array
     */
    public static void sort_1(int[] array) {
        int count = 1;
        //循环的轮数是数组长度 - 1
        for (int i = 0; i < array.length - 1; i++) {
            count++;
            //这里array.length - i是因为最后面的数已经排好序了，没必要再次进行判断大小
            for (int j = 0; j < array.length - i - 1; j++) {
                int temp;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        log.info("循环了{}轮", count);
    }

    /**
     * 冒泡排序第二版:
     * 与第一版代码相比，第二版代码做了小小的改动，利用布尔变量isSorted作为标记。
     * 如果在本轮排序中，元素有交换，则说明数组无序；如果没有元素交换，则说明数组
     * 依然有序，然后直接跳出大循环。
     *
     * @param array
     */
    public static void sort_2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            //有序标记，每一轮初始值都是true
            boolean isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                int temp;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //因为有元素交换，所以不是有序的，标记设为false
                    isSorted = false;
                }
            }
            if (isSorted) {
                log.info("循环了{}轮", i - 1);
                break;
            }
        }
    }

    /**
     * 冒泡排序第三版:
     * 在第三版的代码中，sortBorder就是无序数组的边界。在每一轮排序过程中，处于
     * sortBorder之后的元素就不需要再进行比较了，肯定是有序的。
     *
     * @param array
     */
    public static void sort_3(int[] array) {
        //记录最后一次交换的位置
        int lastExchangeIndex = 0;
        //无序数组的边界，每次比较只需要比到这里为止
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            //有序标记，每一轮初始值都是true
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                int temp;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //因为有元素交换，所以不是有序的，标记设为false
                    isSorted = false;
                    //更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                log.info("循环了{}轮", i - 1);
                break;
            }
        }
    }

    /**
     * 鸡尾酒排序
     * 代码外层的大循环控制着所有排序回合，大循环内包含2个小循环，从第1个小循环从
     * 左向右比较并交换元素，第2个小循环从右向左比较并交换元素。
     *
     * @param array
     */
    public static void cocktailSort(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length / 2; i++) {
            //有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            //奇数轮，从左向右比较和交换
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //有元素交换，所以不是有序的，标记为false
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
            //在偶数轮之前，将isSorted重新标记为true
            isSorted = true;
            //偶数轮，从右向左比较和交换
            for (int j = array.length - i - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    //有元素交换，所以不是有序的，标记为false
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
//        int[] array = {5, 8, 6, 3, 9, 2, 1, 7};
//        sort_1(array);
//        sort_2(array);
//        int[] array = {3, 4, 2, 1, 5, 6, 7, 8};
//        sort_3(array);
        int[] array = {2, 3, 4, 5, 6, 7, 8, 1};
        cocktailSort(array);
        log.info(Arrays.toString(array));
    }

}
