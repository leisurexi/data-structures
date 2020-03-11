package com.leisurexi.data.structures.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * leetcode题号 9.回文数
 *
 * @author: leisurexi
 * @date: 2020-03-11 21:23
 * @since JDK 1.8
 */
@Slf4j
public class PalindromeNumber {

    /**
     * 题目描述：
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 121
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     * <p>
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int n = x;
        int k = 0;
        while (n > 0) {
            k = k * 10 + n % 10;
            n /= 10;
        }
        return k == x;
    }

    public static void main(String[] args) {
        log.info(String.valueOf(isPalindrome(-121)));
    }

}
