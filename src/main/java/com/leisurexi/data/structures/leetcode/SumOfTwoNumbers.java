package com.leisurexi.data.structures.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: leisurexi
 * @date: 2020-02-29 9:31 下午
 * @description: leetcode题号 1.两数之和
 * @since JDK 1.8
 */
@Slf4j
public class SumOfTwoNumbers {

    /**
     * 题目描述:
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * <p>
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */

    /**
     * 暴力解法
     */
    public static int[] twoSum(int[] nums, int target) {
        int index = 0;
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (temp + nums[j] == target) {
                    return new int[]{index, j};
                }
            }
            index = i;
            temp = nums[i];
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 利用HashMap减少时间复杂度，增加了空间复杂度
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int component = target - nums[i];
            if (map.containsKey(component)) {
                return new int[]{map.get(component), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
//        log.info(Arrays.toString(twoSum(array, 9)));
        log.info(Arrays.toString(twoSum2(array, 9)));
    }

}
