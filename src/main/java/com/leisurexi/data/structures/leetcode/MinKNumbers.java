package com.leisurexi.data.structures.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * leetcode面试题 40.最小的k个数
 *
 * @author: leisurexi
 * @date: 2020-03-20 22:26
 * @since JDK 1.8
 */
@Slf4j
public class MinKNumbers {

    /**
     * 题目描述:
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr = [3,2,1], k = 2
     * 输出：[1,2] 或者 [2,1]
     * 示例 2：
     * <p>
     * 输入：arr = [0,1,2,1], k = 1
     * 输出：[0]
     * <p>
     * <p>
     * 限制：
     * <p>
     * 0 <= k <= arr.length <= 10000
     * 0 <= arr[i] <= 10000
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/submissions/
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 冒泡排序版
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 1 && k == 1) {
            return arr;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        log.info(Arrays.toString(arr));
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    /**
     * 快速排序版
     */
    public static int[] getLeastNumbers_2(int[] arr, int k) {
        if (arr.length == 1 && k == 1) {
            return arr;
        }
        quickSort(arr, 0, arr.length - 1);
        log.info("排序好后的数组: {}", Arrays.toString(arr));
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    private static void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = partition(array, startIndex, endIndex);
        quickSort(array, startIndex, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, endIndex);
    }

    /**
     * 分治(单边循环法)
     *
     * @param array      带交换数组
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     * @return
     */
    private static int partition(int[] array, int startIndex, int endIndex) {
        // 取第1个位置(也可以是随机位置)的元素作为基准元素
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
        int[] arr = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        int k = 8;
        log.info(Arrays.toString(getLeastNumbers_2(arr, k)));
    }

}
