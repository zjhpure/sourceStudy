package org.pure.sourceStudy.testBitCalculate;

/**
 * @author zhangjianhua
 * @date 2021-09-17 00:43
 * @description 测试位运算
 */
public class Main {

    public static void main(String[] args) {
        // 测试位运算交换两个数

        // 当两个数相同时，失效
        int a = 11;
        a ^= a;
        a ^= a;
        a ^= a;
        System.out.println("a:" + a);

        // 当两个数不同时，生效
        int b = 11;
        int c = 13;
        b ^= c;
        c ^= b;
        b ^= c;
        System.out.println("b:" + b);
        System.out.println("c:" + c);
    }

}
