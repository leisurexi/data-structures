package com.leisurexi.data.structures.algorithm;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: leisurexi
 * @date: 2019-12-16 8:59 下午
 * @description: 红包算法
 * @since JDK 1.8
 */
@Slf4j
public class DivideRedPackage {

    /**
     * 二倍均值法
     * 假设剩余红包金额为m元，剩余人数为n，那么有如下公式。
     * 每次抢到的金额 = 随机区间[0.01，m / n * 2 - 0.01]元
     * 这个公式，保证了每次随机金额的平均值是相等的，不会因为抢红包的先后顺序而造成不公平。
     * 举个例子如下。
     * 假设有5个人，红包总额100元。
     * 100 / 5 * 2 = 40，所以第1个人抢到的金额随机范围是[0.01，39.99]元，在正常情况下，
     * 还是平均可以抢到20元。
     * 假设第2个人随机抢到了20元，那么剩余金额是60元。
     * 60 / 3 * 2 = 40，所以第3个人抢到的金额的随机范围同样是[0.01，39.99]元，平均可以
     * 抢到20元。
     * 以此类推，每一次抢到金额随机范围的均值是相等的。
     *
     * @param totalAmount    总金额（以分为单位）
     * @param totalPeopleNum 总人数
     * @return
     */
    public static List<Integer> divideRedPackage(Integer totalAmount, Integer totalPeopleNum) {
        List<Integer> amountList = new ArrayList<>();
        Integer restAmount = totalAmount;
        Integer restPeopleNum = totalPeopleNum;
        Random random = new Random();
        for (int i = 0; i < totalPeopleNum - 1; i++) {
            //随机范围: [1, 剩余人均金额的2倍 - 1]分
            int amount = random.nextInt(restAmount / restPeopleNum * 2 - 1) + 1;
            restAmount -= amount;
            restPeopleNum--;
            amountList.add(amount);
        }
        amountList.add(restAmount);
        return amountList;
    }

    public static void main(String[] args) {
        List<Integer> amountList = divideRedPackage(1000, 10);
        for (Integer amount : amountList) {
            log.info("抢到金额: {}", new BigDecimal(amount).divide(new BigDecimal(100)));
        }
    }

}
