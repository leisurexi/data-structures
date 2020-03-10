package com.leisurexi.data.structures.algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author: leisurexi
 * @date: 2019-12-15 12:46 下午
 * @description: 在一个整数所包含数字的全部组合中，找到一个大于且仅大于原数的新整数。字典序算法。
 * @since JDK 1.8
 */
@Slf4j
public class NearestNumber {

    /**
     * 如果是固定的几个数字，应该是在逆序排列的情况下最大，在顺序排列的情况下最小。为了
     * 和原数接近，我们需要尽量保持高位不变，低位在最小的范围内变换顺序。至于变换顺序
     * 的范围大小，则取决于当前整数的逆序区域。
     *
     * 获取全排列下一个数的3个步骤。
     * 1.从后向前查询逆序区域，找到逆序区域的前一位，也就是数字置换的边界。
     * 2.让逆序区域的前一位和逆序区域中大于它的最小的数组交换位置。
     * 3.把原来的逆序区域转为顺序状态。
     *
     * @param numbers
     * @return
     */
    public static int[] findNearestNumber(int[] numbers) {
        //1.从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界
        int index = findTransferPoint(numbers);
        //如果数字置换边界是0，说明整个数组已经逆序，无法得到更大的相同数
        //字组成的整数，返回null
        if (index == 0) {
            return null;
        }
        //2.把逆序区域的前一位和逆序区域中刚刚大于它的数字交换位置
        //复制并入参，避免直接修改入参
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        exchangeHead(numbersCopy, index);
        //3.把原来的逆序区域转为顺序
        reverse(numbersCopy, index);
        return numbersCopy;
    }

    private static int findTransferPoint(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] > numbers[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    private static int[] exchangeHead(int[] numbers, int index) {
        int head = numbers[index - 1];
        for (int i = numbers.length - 1; i > 0; i--) {
            if (head < numbers[i]) {
                numbers[index - 1] = numbers[i];
                numbers[i] = head;
                break;
            }
        }
        return numbers;
    }

    private static int[] reverse(int[] numbers, int index) {
        for (int i = index, j = numbers.length - 1; i < j; i++, j--) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        return numbers;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        //打印12345之后的10个全排列整数
        for (int i = 0; i < 10; i++) {
            numbers = findNearestNumber(numbers);
            log.info(Arrays.toString(numbers));
        }
    }

}
