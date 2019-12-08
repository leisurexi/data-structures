package com.leisurexi.datastructures.sortalgorithm.quick;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author: leisurexi
 * @date: 2019-12-08 8:58 下午
 * @description: 单边循环法的快速排序示例
 * @since JDK 1.8
 */
@Slf4j
public class QuickSortUnilateral {

    /**
     * 该方法通过递归的方式，实现了分而治之的思想
     *
     * @param array
     * @param startIndex
     * @param endIndex
     */
    public static void quickSort(int[] array, int startIndex, int endIndex) {
        //递归结束条件: startIndex大于或等于endIndex
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
     * 分治（单边循环法）
     *
     * @param array      待交换的数组
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     * @return
     */
    private static int partition(int[] array, int startIndex, int endIndex) {
        //取第1个位置（也可以选择随机位置）的元素作为基准元素
        int pivot = array[startIndex];
        int mark = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (array[i] < pivot) {
                mark++;
                int p = array[mark];
                array[mark] = array[i];
                array[i] = p;
            }
        }
        array[startIndex] = array[mark];
        array[mark] = pivot;
        return mark;
    }

    public static void main(String[] args) {
        int[] array = {4, 4, 6, 5, 3, 2, 8, 1};
        quickSort(array, 0, array.length - 1);
        log.info(Arrays.toString(array));
    }

}
