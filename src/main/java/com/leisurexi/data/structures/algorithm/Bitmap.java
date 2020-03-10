package com.leisurexi.data.structures.algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: leisurexi
 * @date: 2019-12-15 8:47 下午
 * @description: 位图算法示例
 * @since JDK 1.8
 */
@Slf4j
public class Bitmap {

    /**
     * 每一个word是一个long类型酸雨，对应一个64位二进制数据
     */
    private long[] words;
    /**
     * Bitmap的位数大小
     */
    private int size;

    public Bitmap(int size) {
        this.size = size;
        this.words = new long[getWordIndex(size - 1) + 1];
    }

    /**
     * 判断Bitmap某一位的状态
     *
     * @param bitIndex 位图的第bitIndex位
     * @return
     */
    public boolean getBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex > size - 1) {
            throw new IndexOutOfBoundsException("超过Bitmap有效范围");
        }
        int wordIndex = getWordIndex(bitIndex);
        return (words[wordIndex] & (1L << bitIndex)) != 0;
    }

    /**
     * 把Bitmap某一位设置为true
     *
     * @param bitIndex 位图的第bitIndex位
     */
    public void setBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex > size - 1) {
            throw new IndexOutOfBoundsException("超过Bitmap有效范围");
        }
        int wordIndex = getWordIndex(bitIndex);
        words[wordIndex] |= (1L << bitIndex);
    }

    /**
     * 定位Bitmap某一位所对应的word
     *
     * @param bitIndex 位图的第bitIndex位
     * @return
     */
    private int getWordIndex(int bitIndex) {
        //右移6位，相当于除以64
        return bitIndex >> 6;
    }

    public static void main(String[] args) {
        Bitmap bitmap = new Bitmap(128);
        bitmap.setBit(126);
        bitmap.setBit(75);
        log.info(String.valueOf(bitmap.getBit(126)));
        log.info(String.valueOf(bitmap.getBit(78)));
    }

}
