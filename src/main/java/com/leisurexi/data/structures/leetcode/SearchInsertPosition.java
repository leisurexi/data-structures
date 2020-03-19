package com.leisurexi.data.structures.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * leetcode题号 35.搜索插入位置
 *
 * @author: leisurexi
 * @date: 2020-03-19 22:58
 * @since JDK 1.8
 */
@Slf4j
public class SearchInsertPosition {

    /**
     * 题目描述:
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 你可以假设数组中无重复元素。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: [1,3,5,6], 2
     * 输出: 1
     * 示例 3:
     * <p>
     * 输入: [1,3,5,6], 7
     * 输出: 4
     * 示例 4:
     * <p>
     * 输入: [1,3,5,6], 0
     * 输出: 0
     */

    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 6};
        int target = 0;
        log.info(String.valueOf(searchInsert(array, target)));
    }

}
