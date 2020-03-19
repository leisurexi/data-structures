package com.leisurexi.data.structures.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * 未解决
 * leetcode题号 28.实现 strStr()
 *
 * @author: leisurexi
 * @date: 2020-03-19 22:09
 * @since JDK 1.8
 */
@Slf4j
public class ImplementStr {

    /**
     * 题目描述:
     * 实现 strStr() 函数。
     * <p>
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * <p>
     * 示例 1:
     * <p>
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * 说明:
     * <p>
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * <p>
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     */

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        int last = 0;
        int start = -1;
        int end = -1;
        char[] sources = haystack.toCharArray();
        char[] targets = needle.toCharArray();
        for (int i = last; i < targets.length; i++) {
            for (int j = 0; j < sources.length; j++) {
                if (targets[i] == sources[j]) {
                    if (start == -1) {
                        start = j;
                        break;
                    } else if(start != -1 && j != start) {
                        end = j;
                        break;
                    }
                }
            }
        }
        log.info("start: {}, end: {}", start, end);
        return (end - start + 1) == needle.length() ? start : -1;
    }



    public static void main(String[] args) {
        String haystack = "heloll";
        String needle = "ll";
        log.info(String.valueOf(strStr(haystack, needle)));
    }

}
