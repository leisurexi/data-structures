package com.leisurexi.datastructures.algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: leisurexi
 * @date: 2019-12-12 10:05 下午
 * @description: 获取两个数中的最大公约数示例
 * @since JDK 1.8
 */
@Slf4j
public class GreatestCommonDivisor {

    /**
     * 辗转相除法，有名欧几里得算法，该算法的目的是求出两个正整数的最大公约数。
     * 这条算法基于一个定理: 两个正整数a和b（a > b）,它们的最大公约数等于a除以b的余数c和b之间的最大公约数。
     * 有了这条定理，求最大公约数就变得简单了。我们可以使用递归的方法把问题逐步简化。
     * 首先，计算出a除以b的余数c，把问题转化成求b和c的最大公约数；然后计算出b除以c的余数d，
     * 把问题转化为求c和d的最大公约数；在计算出c除以d的余数e，把问题转化为d和e的最大公约数......
     * 以此类推，逐渐把两个较大整数之间的运算简化成两个较小整数之间的运算，直到两个数可以整除，
     * 或者其中一个数减小到1为止。
     *
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisor(int a, int b) {
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        if (big % small == 0) {
            return small;
        }
        return getGreatestCommonDivisor(big % small, small);
    }

    /**
     * 更相减损术，出自中国古代的《九章算术》，也是一种求最大公约数的算法。
     * 它的原理更加简单: 两个正整数a和b（a > b），它们的最大公约数等于a-b的差值
     * 和较小数b的最大公约数。例如10和25，25减10的差是15，那么10和25的最大公约数，
     * 等同于10和15的最大公约数。
     * 由此，我们同样可以通过递归来简化问题。首先，计算出a和b的差值c（假设a>b），
     * 把问题转化成b和c的最大公约数；然后计算出c和d的差值d（假设c>d），把问题转
     * 化成求b和d的最大公约数；再计算出b和d的差值e（假设b<d），把问题转化成求
     * d和e的最大公约数......
     * 以此类推，逐渐把两个较大整数之间的运算简化成两个较小整数之间的运算，直到
     * 两个数可以相等为止，最大公约数就是最终相等的这两个数的值。
     *
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisor_2(int a, int b) {
        if (a == b) {
            return a;
        }
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        return getGreatestCommonDivisor_2(big - small, small);
    }

    /**
     * 众所周知，移位运算的性能非常好。对于给出的正整数a和b，不难得到如下的结论。
     * 下面的getGreatestCommonDivisor_3 简写成 gcd
     * 当a和b均为偶数时，gcd(a, b) = 2 * gcd(a/2, b/2) = 2 * gcd(a>>1,b>>1)
     * 当a为偶数时，b为奇数时，gcd(a,b) = gcd(a/2,b) = gcd(a>>1,b)
     * 当a为奇数，b为偶数时，gcd(a,b) = gcd(a,b/2) = gcd(a,b>>1)
     * 当a和b均为奇数时，先利用更相减损术运算一次，gcd(a,b) = gcd(b,a-b)，此时a-b
     * 必然是偶数，然后又可以继续进行移位运算。
     * 例如计算10和25的最大公约数的步骤如下。
     * 1.整数10通过位移，可以转换成求5和25的最大公约数。
     * 2.利用更相减损术，计算出25-5=20，转换成5和20的最大公约数。
     * 3.整数20通过位移，可以转换成求5和10的最大公约数。
     * 4.整数10通过位移，可以转换成求5和5的最大公约数。
     * 5.利用更相减损术，因为两术相等，所以最大公约数是5。
     * 这种方式在两数都比较小时，可能看不出计算次数的优势；当两数越大时，计算次数的减少就会越明显。
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisor_3(int a, int b) {
        if (a == b) {
            return a;
        }
        if ((a & 1) == 0 && (b & 1) == 0) {
            return getGreatestCommonDivisor_3(a >> 1, b >> 1) << 1;
        } else if ((a & 1) == 0 && (b & 1) != 0) {
            return getGreatestCommonDivisor_3(a >> 1, b);
        } else if ((a & 1) != 0 && (b & 1) == 0) {
            return getGreatestCommonDivisor_3(a, b >> 1);
        } else {
            int big = a > b ? a : b;
            int small = a < b ? a : b;
            return getGreatestCommonDivisor_3(big - small, small);
        }
    }

    public static void main(String[] args) {
        log.info(String.valueOf(getGreatestCommonDivisor(25, 5)));
        log.info(String.valueOf(getGreatestCommonDivisor(100, 80)));

        log.info(String.valueOf(getGreatestCommonDivisor_2(25, 5)));
        log.info(String.valueOf(getGreatestCommonDivisor_2(100, 80)));
        log.info(String.valueOf(getGreatestCommonDivisor_2(27, 14)));

        log.info(String.valueOf(getGreatestCommonDivisor_3(25, 5)));
        log.info(String.valueOf(getGreatestCommonDivisor_3(100, 80)));
        log.info(String.valueOf(getGreatestCommonDivisor_3(27, 14)));
    }

}
