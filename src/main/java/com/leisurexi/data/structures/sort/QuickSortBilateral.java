package com.leisurexi.data.structures.sort;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author: leisurexi
 * @date: 2019-12-08 8:21 下午
 * @description: 双边循环法的快速排序示例
 * @since JDK 1.8
 */
@Slf4j
public class QuickSortBilateral {

    /**
     * 该方法通过递归的方式，实现了分而治之的思想
     *
     * @param array
     * @param startIndex
     * @param endIndex
     */
    public static void quickSort(int[] array, int startIndex, int endIndex) {
        //递归结束条件: startIndex大于或等于endIndex时
        if (startIndex >= endIndex) {
            return;
        }
        //得到基准元素位置
        int pivotIndex = partition(array, startIndex, endIndex);
        //根据基准元素，分成两部分进行递归排序
        quickSort(array, startIndex, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, endIndex);
    }

    /**
     * 分治（双边循环法）
     * 该方法实现了元素的交换，让数列中的元素依据自身大小，分别交换到基准
     * 元素的左右两边。
     *
     * @param array      带交换的数组
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     * @return
     */
    private static int partition(int[] array, int startIndex, int endIndex) {
        //取第1个位置（也可以选择随机位置）的元素作为基准元素
        int pivot = array[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            //控制right指针比较并左移
            while (left < right && array[right] > pivot) {
                right--;
            }
            //控制left指针比较并右移
            while (left < right && array[left] <= pivot) {
                left++;
            }
            //交换left和right指针所指向的元素
            if (left < right) {
                int p = array[left];
                array[left] = array[right];
                array[right] = p;
            }
        }
        //pivot和指针重合点交换
        array[startIndex] = array[left];
        array[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] array = {4, 4, 6, 5, 3, 2, 8, 1};
        quickSort(array, 0, array.length - 1);
        log.info(Arrays.toString(array));
    }

}
