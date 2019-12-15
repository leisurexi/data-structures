package com.leisurexi.datastructures.algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: leisurexi
 * @date: 2019-12-15 1:31 下午
 * @description: 贪心算法示例。给出一个整数，从该整数中去掉k个数字，要求剩下的
 * 数字形成的新整数尽可能小。
 * @since JDK 1.8
 */
@Slf4j
public class Greedy {

    /**
     * 删除整数的k个数字，获得删除后的最小值。
     * 把原整数的所有数字从左到右进行比较，如果发现某一位数字大于它右面的数字，那么在删除该数字后，
     * 必然会使该数位的值降低，因为右面比它小的数字顶替了它的位置。
     *
     * @param num
     * @param k
     * @return
     */
    public static String removeKDigits(String num, int k) {
        for (int i = 0; i < k; i++) {
            boolean hasCut = false;
            //从左向右遍历，找到比自己右侧数字大的数字并删除
            for (int j = 0; j < num.length() - 1; j++) {
                if (num.charAt(j) > num.charAt(j + 1)) {
                    num = num.substring(0, j) + num.substring(j + 1);
                    hasCut = true;
                    break;
                }
            }
            //如果没有找到要删除的数组，则删除最后一个数字
            if (!hasCut) {
                num = num.substring(0, num.length() - 1);
            }
        }
        //清除整数左侧的数字0
        int start = 0;
        for (int j = 0; j < num.length() - 1; j++) {
            if (num.charAt(j) != '0') {
                break;
            }
            start++;
        }
        num = num.substring(start);
        //如果整数的所有数字都被删除了，直接返回0
        if (num.length() == 0) {
            return "0";
        }
        return num;
    }

    /**
     * 下面代码非常巧妙的运用了栈的特性，在遍历原整数的数字时，让所有数字一个一个入栈，当某个数字需要删除时，
     * 让该数字出栈。最后，程序把栈中的元素转化为字符串类型的结果。
     */
    public static String removeKDigits_2(String num, int k) {
        //新整数的最终长度 = 原整数程度 - k
        int newLength = num.length() - k;
        //创建一个栈，用于接收所有的数字
        char[] stack = new char[num.length()];
        int top = 0;
        for (int i = 0; i < num.length(); i++) {
            //遍历当前数字
            char c = num.charAt(i);
            //当栈顶数字大于遍历到的当前数字时，栈顶数字出栈（相当于删除数字）
            while (top > 0 && stack[top - 1] > c && k > 0) {
                top -= 1;
                k -= 1;
            }
            //遍历到的当前数组入栈
            stack[top++] = c;
        }
        //找到栈中第1个非零数字的位置，以此构建新的整数字符串
        int offset = 0;
        while (offset < newLength && stack[offset] == '0') {
            offset++;
        }
        return offset == newLength ? "0" : new String(stack, offset, newLength - offset);
    }

    public static void main(String[] args) {
        log.info(removeKDigits("1593212", 3));
        log.info(removeKDigits("30200", 1));
        log.info(removeKDigits("10", 2));
        log.info(removeKDigits("541270936", 3));

        log.info(removeKDigits_2("1593212", 3));
        log.info(removeKDigits_2("30200", 1));
        log.info(removeKDigits_2("10", 2));
        log.info(removeKDigits_2("541270936", 3));
    }

}
