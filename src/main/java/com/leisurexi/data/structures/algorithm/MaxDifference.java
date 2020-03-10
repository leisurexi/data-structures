package com.leisurexi.data.structures.algorithm;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author: leisurexi
 * @date: 2019-12-14 7:47 下午
 * @description: 给出一个无序数组，找出最任意两个相邻元素的最大差值
 * @since JDK 1.8
 */
@Slf4j
public class MaxDifference {

    /**
     * 1.利用技术排序的思想，先求出原数组的最大值max和最小值min的区间长度k(k=max-min+1)，
     * 以及偏移量d=min。
     * 2.创建一个长度为k的新数组Array。
     * 3.遍历原数组，每遍历一个元素，就把新数组Array对应下标的值加1。例如原数组元素值为n，
     * 则将Array[n-min]的值加1。遍历结束后，Array的一部分元素值变成了1或更高的数值，一
     * 部分元素值仍然是0。
     * 4.遍历新数组Array，统计出Array中最大连续出现0值得次数加1，即为相邻元素最大差值。
     *
     * @param array
     * @return
     */
    public static int maxDifference_1(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        int k = max - min + 1;
        int[] countArray = new int[k];
        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
        }
        List<Integer> zeroCountList = new ArrayList<>();
        int x = 0;
        int count = 0;
        log.info("countArray: {}", Arrays.toString(countArray));
        for (int i = 0; i < countArray.length; i++) {
            if (x + 1 != i) {
                zeroCountList.add(count);
                count = 0;
            }
            if (countArray[i] == 0) {
                count++;
                x = i;
            }
        }
        int maxDifference = 0;
        for (Integer integer : zeroCountList) {
            if (integer > maxDifference) {
                maxDifference = integer;
            }
        }
        return maxDifference + 1;
    }

    /**
     * 1.利用桶排序的思想，根据原数组的长度n，创建出n个桶，每一个桶代表一个区间范围。
     * 其中第1个桶从原数组的最小值min开始，区间跨度是(max-min)/(n-1)。
     * 2.遍历原数组，把原数组每一个元素插入到对应的桶中，记录每一个桶的最大值和最小值。
     * 3.遍历所有的桶，统计出每一个桶的最大值，和这个桶右侧空桶的最小值的差，数值最大
     * 的差即为原数组排序后的相邻最大值。
     *
     * @param array
     * @return
     */
    public static int maxDifference_2(int[] array) {
        //1.得到数列的最大值和最小值
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        int d = max - min;
        //如果max和min相等，说明数组所有元素都相等，返回0
        if (d == 0) {
            return 0;
        }
        //2.初始化桶
        int bucketNum = array.length;
        Bucket[] buckets = new Bucket[bucketNum];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();

        }
        //3.遍历原始数组，确定每个桶的最大最小值
        for (int i = 0; i < array.length; i++) {
            //确定数组元素所归属的桶下标
            int index = ((array[i] - min) * (bucketNum - 1) / d);
            if (buckets[index].getMin() == null || buckets[index].getMin() > array[i]) {
                buckets[index].setMin(array[i]);
            }
            if (buckets[index].getMax() == null || buckets[index].getMax() < array[i]) {
                buckets[index].setMax(array[i]);
            }
        }
        //4.遍历桶，找到最大值
        int leftMax = buckets[0].getMax();
        int maxDistance = 0;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i].getMin() == null) {
                continue;
            }
            if (buckets[i].getMin() - leftMax > maxDistance) {
                maxDistance = buckets[i].getMin() - leftMax;
            }
            leftMax = buckets[i].getMax();
        }
        return maxDistance;
    }

    /**
     * 桶
     */
    @Data
    private static class Bucket {
        Integer min;
        Integer max;
    }

    public static void main(String[] args) {
        int[] array = {2, 6, 3, 4, 5, 10, 9};
        log.info("最大相差数: {}", maxDifference_1(array));
        log.info("最大相差数: {}", maxDifference_2(array));
    }

}
