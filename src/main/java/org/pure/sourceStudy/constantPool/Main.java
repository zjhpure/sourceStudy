package org.pure.sourceStudy.constantPool;

/**
 * @author zhangjianhua
 * @date 2021-05-09 16:09
 * @description 常量池
 */
public class Main {

    public static void main(String[] args) {
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150, f5 = 127, f6 = 127, f7 = 128, f8 = 128, f9 = -128, f10 = -128, f11 = -129, f12 = -129;

        System.out.println(f1 == f2); // true，因为f1的值保存在整数常量池中并且指向整数常量池，f2也指向了整数常量池
        System.out.println(f3 == f4); // false，因为f3和f4的指向不同

        System.out.println(f5 == f6); // true，因为f5和f6都指向了整数常量池，整数常量池范围是-128-127
        System.out.println(f7 == f8); // false，因为f7和f8的指向不同

        System.out.println(f9 == f10); // true，因为f9和f10都指向了整数常量池，整数常量池范围是-128-127
        System.out.println(f11 == f12); // false，因为f11和f12的指向不同

        String s1 = "a", s2 = "a";
        System.out.println(s1 == s2); // true，因为s1和s2都指向了字符串常量池

        String s3 = "hello", s4 = "he" + "llo";
        System.out.println(s3 == s4); // true，因为s3和s4都指向了字符串常量池，"he" + "llo"会被编译器优化为一个String a = "hello"直接放入字符串常量池中

        String s5 = "hello", s6 = "he" + new String("llo");
        System.out.println(s5 == s6); // false，因为s5和s6的指向不同，字符串常量池中不存在"hello"，因为后面的new String("llo")不会在字符串常量池中产生"llo"
    }

}
