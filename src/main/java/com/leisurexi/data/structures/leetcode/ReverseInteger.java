package com.leisurexi.data.structures.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * leetcode题号 7.整数反转
 *
 * @author: leisurexi
 * @date: 2020-03-11 20:54
 * @since JDK 1.8
 */
@Slf4j
public class ReverseInteger {

    /**
     * 题目描述:
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 123
     * 输出: 321
     *  示例 2:
     * <p>
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * <p>
     * 输入: 120
     * 输出: 21
     * 注意:
     * <p>
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 自己解法
     */
    public static int reverse(int x) {
        boolean negative = false;
        String number = String.valueOf(x);
        if (number.contains("-")) {
            negative = true;
            number = number.replace("-", "");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = number.length() - 1; i >= 0; i--) {
            stringBuilder.append(number.charAt(i));
        }
        Long result = negative ? Long.valueOf("-" + stringBuilder.toString()) : Long.valueOf(stringBuilder.toString());
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return result.intValue();
    }

    /***
     * 大神解法：
     * 每次用 x % 10 拿到数字的最后一位，x / 10 删掉数字的最后一位
     */
    public static int reverse_2(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }

    public static void main(String[] args) {
        int number = 1534236469;
        log.info(String.valueOf(reverse(number)));
        log.info(String.valueOf(reverse_2(number)));
    }

}
