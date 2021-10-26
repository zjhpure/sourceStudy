package org.pure.sourceStudy.test;

/**
 * @author zhangjianhua
 * @date 2021-10-20 14:43
 * @description 面试题测试
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    private static void test1() {
        String str = "ABCDEFGH";
        String str1 = str.substring(3, 5);
        System.out.println(str1);
    }

    private static void test2() {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
    }

    private static void test3() {
        int a = 5, b = 3;
        if ((a == b) && (a == 1 + b++)) {

        }
        System.out.println(a + "," + b);
    }

    private static void test4() {
        new Apple();
    }

    private static void test5() throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.print("1");
                    try {
                        lock.wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("2");
                    lock.notify();
                    System.out.print("3");
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.print("4");
                    lock.notify();
                    System.out.print("5");
                    try {
                        lock.wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("6");
                }
            }
        });
        t2.start();
        t1.start();

        t1.join();
        t2.join();
        System.out.print("7");
    }

}

class Fruit {
    static {
        System.out.println("1");
    }

    public Fruit() {
        System.out.println("2");
    }
}

class Apple extends Fruit {
    static {
        System.out.println("3");
    }

    public Apple() {
        System.out.println("4");
    }
}