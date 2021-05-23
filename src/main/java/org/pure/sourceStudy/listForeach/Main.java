package org.pure.sourceStudy.listForeach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangjianhua
 * @date 2021-05-09 16:08
 * @description 从源码解读Java列表的遍历效率
 */
@SuppressWarnings("ALL")
public class Main {

    public static void main(String[] args) {
        testForeachTransform();

        long arrayListForTime = arrayListForTime();

        System.out.println("测试ArrayList通过for遍历消耗时间：" + arrayListForTime);

        long arrayListForeachTime = arrayListForeachTime();

        System.out.println("测试ArrayList通过foreach遍历消耗时间：" + arrayListForeachTime);

        long arrayListIteratorTime = arrayListIteratorTime();

        System.out.println("测试ArrayList通过iterator遍历消耗时间：" + arrayListIteratorTime);

        long linkedListForTime = linkedListForTime();

        System.out.println("测试LinkedList通过for遍历消耗时间：" + linkedListForTime);

        long linkedListForeachTime = linkedListForeachTime();

        System.out.println("测试LinkedList通过foreach遍历消耗时间：" + linkedListForeachTime);

        long linkedListIteratorTime = linkedListIteratorTime();

        System.out.println("测试LinkedList通过iterator遍历消耗时间：" + linkedListIteratorTime);

        // 根据测试结果：
        // ArrayList通过for遍历和通过iterator遍历差不多
        // LinkedList通过iterator遍历比通过for遍历要快很多

        // 在我们的应用中，要考虑使用List接口的哪种实现类，可以更好更高效的满足实际场景需求
        // 通过实现RandomAccess接口来区分List的哪种实现类

        // 实现RandomAccess接口的List通过for遍历数据，和通过iterator遍历数据差不多
        // 未实现RandomAccess接口的List通过iterator遍历数据，比通过for遍历数据高效很多
    }

    /**
     * 测试foreach转换成什么
     */
    private static void testForeachTransform() {
        System.out.println("测试foreach转换成什么");

        // 对于基本类型数组，foreach遍历会转为for遍历，因为没有实现iterator
        // 对于List，foreach遍历会转为iterator遍历，因为实现了iterator

        // 运行后查看编译后的class文件即可看到foreach转换成什么

        int[] arrays = {1, 2, 3, 4, 5};

        for (int i = 0; i < arrays.length; ++i) {
        }

        for (int array : arrays) {
        }

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        for (int i = 0; i < list.size(); ++i) {
        }

        for (int element : list) {
        }
    }

    /**
     * 测试ArrayList通过for遍历消耗时间
     *
     * @return 消耗时间
     */
    private static long arrayListForTime() {
        List<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }

        // 记录开始时间
        long startTime = System.currentTimeMillis();

        // 通过for遍历
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }

        // 记录结束时间
        long endTime = System.currentTimeMillis();

        // 返回消耗时间
        return endTime - startTime;
    }

    /**
     * 测试ArrayList通过foreach遍历消耗时间
     *
     * @return 消耗时间
     */
    private static long arrayListForeachTime() {
        List<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }

        // 记录开始时间
        long startTime = System.currentTimeMillis();

        // 通过foreach遍历
        for (int array : arrayList) {
        }

        // 记录结束时间
        long endTime = System.currentTimeMillis();

        // 返回消耗时间
        return endTime - startTime;
    }

    /**
     * 测试ArrayList通过iterator遍历消耗时间
     *
     * @return 消耗时间
     */
    private static long arrayListIteratorTime() {
        List<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }

        // 记录开始时间
        long startTime = System.currentTimeMillis();

        // 通过iterator遍历
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }

        // 记录结束时间
        long endTime = System.currentTimeMillis();

        // 返回消耗时间
        return endTime - startTime;
    }

    /**
     * 测试LinkedList通过for遍历所消耗时间
     *
     * @return 消耗时间
     */
    private static long linkedListForTime() {
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 100000; i++) {
            linkedList.add(i);
        }

        // 记录开始时间
        long startTime = System.currentTimeMillis();

        // 通过for遍历
        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.get(i);
        }

        // 记录结束时间
        long endTime = System.currentTimeMillis();

        // 返回消耗时间
        return endTime - startTime;
    }

    /**
     * 测试LinkedList通过for遍历所消耗时间
     *
     * @return 消耗时间
     */
    private static long linkedListForeachTime() {
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 100000; i++) {
            linkedList.add(i);
        }

        // 记录开始时间
        long startTime = System.currentTimeMillis();

        // 通过foreach遍历
        for (int array : linkedList) {
        }

        // 记录结束时间
        long endTime = System.currentTimeMillis();

        // 返回消耗时间
        return endTime - startTime;
    }

    /**
     * 测试LinkedList通过iterator遍历所消耗时间
     *
     * @return 消耗时间
     */
    private static long linkedListIteratorTime() {
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 100000; i++) {
            linkedList.add(i);
        }

        // 记录开始时间
        long startTime = System.currentTimeMillis();

        // 通过iterator遍历
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }

        // 记录结束时间
        long endTime = System.currentTimeMillis();

        // 返回消耗时间
        return endTime - startTime;
    }

}
