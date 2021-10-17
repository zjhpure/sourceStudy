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

    // JDK1.7 中，由于多线程对HashMap进行扩容，调用了HashMap#transfer()。
    // 具体原因：某个线程执行过程中，被挂起，其他线程已经完成数据迁移，等CPU资源释放后被挂起的线程重新执行之前的逻辑，数据已经被改变，造成死循环、数据丢失。
    // JDK1.8 中，由于多线程对HashMap进行put操作，调用了HashMap#putVal()。
    // 具体原因：假设两个线程A、B都在进行put操作，并且hash函数计算出的插入下标是相同的，当线程A执行完第六行代码后由于时间片耗尽导致被挂起，而线程B得到时间片后在该下标处插入了元素，完成了正常的插入，然后线程A获得时间片，由于之前已经进行了hash碰撞的判断，所有此时不会再进行判断，而是直接进行插入，这就导致了线程B插入的数据被线程A覆盖了，从而线程不安全。
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
