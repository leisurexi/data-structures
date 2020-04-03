package com.leisurexi.data.structures.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * leetcode面试题 17.16.按摩师
 *
 * @author: leisurexi
 * @date: 2020-03-24 22:15
 * @since JDK 1.8
 */
@Slf4j
public class TheMasseuseLcci {

    /**
     * 题目描述：
     * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
     * <p>
     * 注意：本题相对原题稍作改动
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入： [1,2,3,1]
     * 输出： 4
     * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
     * 示例 2：
     * <p>
     * 输入： [2,7,9,3,1]
     * 输出： 12
     * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
     * 示例 3：
     * <p>
     * 输入： [2,1,4,5,3,1,1,3]
     * 输出： 12
     * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            int c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        int arr[] = {2, 1, 4, 5, 3, 1, 1, 3};
        log.info(String.valueOf(massage(arr)));
    }

}
