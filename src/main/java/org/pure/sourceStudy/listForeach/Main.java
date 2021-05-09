package org.pure.sourceStudy.listForeach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangjianhua
 * @date 2021-05-09 16:08
 * @description 列表for循环
 */
public class Main {

    public static void main(String[] args) {
        long arrayListIndexedTime = arrayListIndexed();
        long arrayListIndexedTime2 = arrayListIndexed2();
        long arrayListIteratorTime = arrayListIterator();
        long linkedListIndexedTime = linkedListIndexed();
        long linkedListIteratorTime = linkedListIterator();
        System.out.println("测试ArrayList通过for遍历所消耗时间：" + arrayListIndexedTime);
        System.out.println("测试ArrayList通过foreach遍历所消耗时间：" + arrayListIndexedTime2);
        System.out.println("测试ArrayList通过iterator遍历所消耗时间：" + arrayListIteratorTime);
        System.out.println("测试LinkedList通过for遍历所消耗时间：" + linkedListIndexedTime);
        System.out.println("测试LinkedList通过iterator遍历所消耗时间：" + linkedListIteratorTime);

        // 我们来分析一下测试结果：
        // ArrayList通过for遍历比通过iterator遍历要稍快，
        // LinkedList通过iterator遍历比通过for遍历要快。

        // 所以说在我们的应用中，要考虑使用List接口的哪种实现类，可以更好更高效的满足实际场景需求。
        // 所以在这里通过实现RandomAccess接口来区分List的哪种实现类。

        // 实现RandomAccess接口的List可以通过for循环来遍历数据，比使用iterator遍历数据更高效，
        // 未实现RandomAccess接口的List可以通过iterator遍历数据，比使用for循环来遍历数据更高效。

        int[] tests = {1, 2, 3, 4, 5};

        for (int i = 0; i < tests.length; ++i) {
            System.out.println("tests element:" + tests[i]);
        }

        for (int test : tests) {
            System.out.println("tests element:" + test);
        }
    }

    // 测试ArrayList通过for遍历所消耗时间
    private static long arrayListIndexed() {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
        }
        // 记录开始时间
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }
        // 记录结束时间
        long endTime = System.currentTimeMillis();
        // 遍历消耗时间
        long resultTime = endTime - startTime;
        return resultTime;
    }

    // 测试ArrayList通过for遍历所消耗时间
    private static long arrayListIndexed2() {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
        }
        // 记录开始时间
        long startTime = System.currentTimeMillis();
        for (int array : arrayList) {
            arrayList.get(array);
        }
        // 记录结束时间
        long endTime = System.currentTimeMillis();
        // 遍历消耗时间
        long resultTime = endTime - startTime;
        return resultTime;
    }

    // 测试ArrayList通过iterator遍历所消耗时间
    private static long arrayListIterator() {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
        }
        // 记录开始时间
        long startTime = System.currentTimeMillis();
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        // 记录结束时间
        long endTime = System.currentTimeMillis();
        // 遍历消耗时间
        long resultTime = endTime - startTime;
        return resultTime;
    }

    // 测试LinkedList通过for遍历所消耗时间
    private static long linkedListIndexed() {
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(i);
        }
        // 记录开始时间
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.get(i);
        }
        // 记录结束时间
        long endTime = System.currentTimeMillis();
        // 遍历消耗时间
        long resultTime = endTime - startTime;
        return resultTime;
    }

    // 测试LinkedList通过iterator遍历所消耗时间
    private static long linkedListIterator() {
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(i);
        }
        // 记录开始时间
        long startTime = System.currentTimeMillis();
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        // 记录结束时间
        long endTime = System.currentTimeMillis();
        // 遍历消耗时间
        long resultTime = endTime - startTime;
        return resultTime;
    }

}
