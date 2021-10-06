package org.pure.sourceStudy.testString;

/**
 * @author zhangjianhua
 * @date 2021-10-06 18:45
 * @description 测试字符串
 */
public class Main {

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1 == str2); // 输出true
        System.out.println(str1.equals(str2)); // 输出true
        // 常量池创建一个“abc”对象，产生一个内存地址
        // 然后把“abc”内存地址赋值给成员变量str1，这个时候str1根据内存地址，指向了常量池中的“abc”
        // 常量池有这个特点，如果发现已经存在，就不在创建重复的对象
        // 运行到代码String str2 =”abc”, 由于常量池存在“abc”，所以不会再创建，直接把“abc”内存地址赋值给了str2
        // 最后str1和str2都指向了内存中同一个地址，所以两者是完全相同的
    }

    private static void test2() {
        String str1 = new String("abc");
        String str2 = "abc";
        System.out.println(str1 == str2); // 输出false
        System.out.println(str1.equals(str2)); // 输出true
        // ==比较的str1和str2对象的内存地址，str1指向的是堆内存的地址
        // str2看到“abc”已经在常量池存在，就不会再新建，所以str2指向了常量池的内存地址
        // 所以==判断结果输出false，两者不相等
        // 第二个equals比较，比较是两个字符串序列是否相等，由于就一个“abc”，所以完全相等
    }

}
