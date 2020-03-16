package com.leisurexi.data.structures.leetcode;

import lombok.extern.slf4j.Slf4j;


/**
 * leetcode题号 14. 最长公共前缀
 *
 * @author: leisurexi
 * @date: 2020-03-12 22:15
 * @since JDK 1.8
 */
@Slf4j
public class LongestCommonPrefix {

    /**
     * 题目描述:
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * 示例 1:
     * <p>
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     * <p>
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     * <p>
     * 所有输入只包含小写字母 a-z 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-common-prefix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] array = {"flower","flow","flight"};
        log.info(longestCommonPrefix(array));

        String str1 = "flower";
        String str2 = "flow";
        System.out.println(str1.indexOf(str2));
    }

}
