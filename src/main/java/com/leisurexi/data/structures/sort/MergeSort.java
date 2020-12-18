package com.leisurexi.data.structures.sort;

import java.util.Arrays;

/**
 * 归并排序实现
 *
 * @author: leisurexi
 * @date: 2020-12-18 16:56
 */
public class MergeSort {


    /**
     * 合并排序
     *
     * @param array 需要排序的目标数组
     * @param p     开始下标
     * @param r     结束下标
     */
    public static void mergeSort(int[] array, int p, int r) {
        if (p >= r)
            return;

        // 取p到r之间的中间位置q
        int q = (p + r) / 2;
        // 分治递归
        mergeSort(array, p, q);
        mergeSort(array, q + 1, r);

        int[] temp = Arrays.copyOf(array, array.length);
//        merge();
    }

    public static void merge(int[] temp) {

    }


}
