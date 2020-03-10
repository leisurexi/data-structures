package com.leisurexi.data.structures.algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: leisurexi
 * @date: 2019-12-15 7:48 下午
 * @description: 假设一个无序数组里有若干个正整数，范围是1~100，其中有98个整数出现了
 * 偶数次，只有2个整数出现了奇数次，如果找到这2个出现奇数次的整数？
 * @since JDK 1.8
 */
@Slf4j
public class LostNum {

    public static int[] findLostNum(int[] array) {
        //用于存储2个出现奇数次的整数
        int[] result = new int[2];
        //第1次进行整体异或运算
        int xorResult = 0;
        for (int i = 0; i < array.length; i++) {
            xorResult ^= array[i];
        }
        //如果进行异或运算的结果为0，则说明输入的数组不符合题目要求
        if (xorResult == 0) {
            return null;
        }
        //确定2个整数的不同位，以此来做分组
        int separator = 1;
        while (0 == (xorResult & separator)) {
            separator <<= 1;
        }
        //第2次分组进行异或运算
        for (int i = 0; i < array.length; i++) {
            if (0 == (array[i] & separator)) {
                result[0] ^= array[i];
            } else {
                result[1] ^= array[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {4, 1, 2, 2, 5, 1, 4, 3};
        int[] result = findLostNum(array);
        log.info(result[0] + "," + result[1]);
    }

}
