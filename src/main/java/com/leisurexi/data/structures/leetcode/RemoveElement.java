package com.leisurexi.data.structures.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * leetcode题号 27.移除元素
 *
 * @author: leisurexi
 * @date: 2020-03-18 22:14
 * @since JDK 1.8
 */
@Slf4j
public class RemoveElement {

    /**
     * 题目描述：
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * <p>
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 给定 nums = [3,2,2,3], val = 3,
     * <p>
     * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * 示例 2:
     * <p>
     * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
     * <p>
     * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
     * <p>
     * 注意这五个元素可为任意顺序。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * <p>
     * 说明:
     * <p>
     * 为什么返回数值是整数，但输出的答案是数组呢?
     * <p>
     * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     * <p>
     * 你可以想象内部操作如下:
     * <p>
     * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
     * int len = removeElement(nums, val);
     * <p>
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
     * for (int i = 0; i < len; i++) {
     * print(nums[i]);
     * }
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-element/
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static int removeElement(int[] nums, int val) {
        if (nums.length < 1) {
            return 0;
        }
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (index == -1 && nums[i] == val) {
                index = i;
            } else if (index != -1 && nums[i] != val) {
                int num = nums[index];
                nums[index] = nums[i];
                nums[i] = num;
                index++;
            }
        }
        return index == -1 ? nums.length : index;
    }

    public static int removeElement_2(int[] nums, int val) {
        if (nums.length < 1) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
               nums[j] = nums[i];
               j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 2, 3, 0, 4, 2};
        log.info(String.valueOf(removeElement(array, 2)));
        log.info(Arrays.toString(array));
    }

}
