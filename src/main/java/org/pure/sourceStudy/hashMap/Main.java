package org.pure.sourceStudy.hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangjianhua
 * @date 2021-08-14 21:25
 * @description 测试HashMap线程不安全
 */
public class Main {

    // 在jdk1.7多线程环境下HashMap容易出现死循环
    // 在jdk1.7中，下面代码开了多个线程不断进行put操作，并且HashMap与AtomicInteger都是全局共享的，在多运行几次该代码后，会出现死循环，还可能会出现数组越界的情况
    // 总结：HashMap是线程不安全的，主要体现如下：
    // 在jdk1.7中，在多线程环境下，扩容时会造成环形链或数据丢失。
    // 在jdk1.8中，在多线程环境下，会发生数据覆盖的情况。
    public static void main(String[] args) {
        HashMapThread thread0 = new HashMapThread();
        HashMapThread thread1 = new HashMapThread();
        HashMapThread thread2 = new HashMapThread();
        HashMapThread thread3 = new HashMapThread();
        HashMapThread thread4 = new HashMapThread();
        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

}

class HashMapThread extends Thread {

    private static AtomicInteger ai = new AtomicInteger();

    private static Map<Integer, Integer> map = new HashMap<>();

    @Override
    public void run() {
        while (ai.get() < 1000000) {
            map.put(ai.get(), ai.get());
            ai.incrementAndGet();
        }
        System.out.println("线程名：" + Thread.currentThread().getName() + "，运行");
    }

}
