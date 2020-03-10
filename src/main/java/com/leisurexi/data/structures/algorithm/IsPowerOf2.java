package com.leisurexi.data.structures.algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: leisurexi
 * @date: 2019-12-14 12:48 下午
 * @description: 判断一个数是否是2的整数次幂
 * @since JDK 1.8
 */
@Slf4j
public class IsPowerOf2 {

    /**
     * 创建一个中间变量temp，初始值是1。然后进入下一个循环，每次循环都让temp和目标
     * 整数相比较，如果相等，则说明目标整数是2的整数次幂；如果不相等，则让temp增大1
     * 倍，继续循环并进行比较。当temp的值大于目标整数时，说明目标整数不是2的整数次幂。
     * 如果目标帧数的大小是n，则此方法的时间复杂度是O(logn)。
     *
     * @param num
     * @return
     */
    public static boolean isPowerOf2_1(int num) {
        int temp = 1;
        while (temp <= num) {
            if (temp == num) {
                return true;
            }
            temp = temp * 2;
        }
        return false;
    }

    /**
     * 优化: 移位的性能比乘法高得多，所以将乘法改为移位，但时间复杂度依旧是O(logn)。
     *
     * @param num
     * @return
     */
    public static boolean isPowerOf2_2(int num) {
        int temp = 1;
        while (temp <= num) {
            if (temp == num) {
                return true;
            }
            temp = temp << 1;
        }
        return false;
    }

    /**
     * 如果一个整数是2的整数次幂，那么当它转化成二进制时，只有最高位是1，其他位是0。
     * 2的整数次幂一旦减1，它的二进制数字就全部变成了1！
     * 0和1按位与运算的结果时0，所以凡是2的整数次幂和它本身减1的结果进行与运算，
     * 结果都必定是0。反之，如果一个整数不是2的整数次幂，结果一定不是0！
     * 有上面的结论，可以得出，对于一个整数n，只需要计算 n & (n - 1) 的结果是不是0。
     * 这个方法的时间复杂度只有O(1)。
     *
     * @param num
     * @return
     */
    public static boolean isPowerOf2_3(int num) {
        return (num & num - 1) == 0;
    }

    public static void main(String[] args) {
        log.info(String.valueOf(isPowerOf2_1(32)));
        log.info(String.valueOf(isPowerOf2_1(19)));

        log.info(String.valueOf(isPowerOf2_2(32)));
        log.info(String.valueOf(isPowerOf2_2(19)));

        log.info(String.valueOf(isPowerOf2_3(32)));
        log.info(String.valueOf(isPowerOf2_3(19)));
    }

}
