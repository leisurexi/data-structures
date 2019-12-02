package com.leisurexi.datastructures.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: leisurexi
 * @Description: leetcode题号496 下一个更大的元素
 * @Date: 2019/11/5
 * @Time: 11:48
 */
public class NextGreaterElement {

    /**
     * 题目地址: https://leetcode-cn.com/problems/next-greater-element-i/submissions/
     *
     * 题目描述:
     * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
     * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
     * 示例 1:
     * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
     * 输出: [-1,3,-1]
     * 解释:
     * 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
     * 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
     * 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
     * 示例 2:
     * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
     * 输出: [3,-1]
     * 解释:
     * 对于num1中的数字2，第二个数组中的下一个较大数字是3。
     * 对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
     * 注意:
     * nums1和nums2中所有元素是唯一的。
     * nums1和nums2 的数组大小都不超过1000。
     */

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] temp = helper(nums2);
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int j;
            for (j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    result[i] = j;
                    break;
                }
            }
            if (j == nums2.length) {
                result[i] = -1;
            }
        }

        for (int i = 0; i < result.length; i++) {
            if (result[i] != -1) {
                result[i] = temp[result[i]];
            }
        }
        return result;
    }

    private static int[] helper(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) { //倒着往栈里面放
            while (!stack.empty() && stack.peek() <= nums[i]) { //数组的末尾一定是 -1
                stack.pop(); //一直出栈，直到找到比nums[i] 小的数字
            }
            result[i] = stack.empty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

}
