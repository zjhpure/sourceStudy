## 公众号(纯洁编程说：chunjie_tech)

## 文章地址(列表for循环)

https://mp.weixin.qq.com/s/fRikN30tRRPADWYXXVst2w

## 文章内容
Java的列表List如何遍历效率最好？

Java有三种遍历的方式，难道还有不同？没错，不同的List要用不同的遍历方式，List分为顺序式和链式，顺序式List用普通for循环效率最好，链式List用增强型for循环最好，因为对于List，增强型的for循环是等同于迭代器iterator循环。

我们可以来对比两种方式。

```
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangjianhua
 * @date 2021-05-09 16:08
 * @description 列表for循环
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
        // ArrayList通过for遍历比通过iterator遍历要稍快，
        // LinkedList通过iterator遍历比通过for遍历要快。

        // 在我们的应用中，要考虑使用List接口的哪种实现类，可以更好更高效的满足实际场景需求。
        // 通过实现RandomAccess接口来区分List的哪种实现类。

        // 实现RandomAccess接口的List可以通过for遍历数据，比使用iterator遍历数据更高效，
        // 未实现RandomAccess接口的List可以通过iterator遍历数据，比使用for遍历数据更高效。
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
```
我们可以发现对于顺序式List用普通for循环和增强型for循环差别不大，普通for循环只是比增强型for循环快一点点，这是因为增强型for循环做的事情多了一点点造成的。

但是对于链式List普通for循环和增强型for循环的差别非常大，如果链式List用普通for循环遍历，时间复杂度是O(n^2)，而链式List用增强型for循环的时间复杂度是O(n)，相差了一个数量级的时间。

为什么会这样？因为对于List的增强型for循环，其实是等同于迭代器iterator循环，怎么看出是？可以看编译后的class，通过反编译可以看到List的增强型for循环转换为迭代器iterator循环。不过这里要说一下，对于基本类型的数组使用增强型for循环，编译后是转换为普通for循环的，这里和List的不同，也是通过看编译后的class可以看到。

下面我们来分析下，为什么链式List用了迭代器iterator循环会比普通for循环少一个指数数量级的时间？我们可以通过看源码找到答案。我们分四种情况来看源码。

#### 顺序式List的普通for循环：
遍历的每一次都是调用get方法，我们看get方法的源码，因为是顺序式List，底层用数组保存元素，get方法直接从数组中取元素，这里的时间复杂度是O(1)，所以遍历的时间复杂度就是O(n)。

#### 顺序式List的增强型for循环：
遍历的每一次next方法，我们看next方法的源码，其实和普通for循环的差不多，因为底层用数组保存元素，也是直接从数组中取元素，这里的时间复杂度是O(1)，所以遍历的时间复杂度就是O(n)。

#### 链式List的普通for循环：
遍历的每一次都是调用get方法，我们看get方法的源码，因为是链式List，底层用链表保存元素，每一次get方法就是调用node(index).item，我们看node方法源码，判断下标位置是在中间靠右还是中间靠左，如果中间靠左，那就从开始节点往后面一个一个寻找，如果是中间靠右，那就从结束节点往前面一个一个寻找，这里寻找一个元素的效率就比顺序式寻找一个元素的效率要低很多了，链式List寻找一个元素的时间复杂度是O(n)，而顺序式List寻找一个元素的时间复杂度是O(1)，因为要遍历n次，所以遍历的时间复杂度就是O(n^2)，所以链式List普通for循环会很慢。

不过链式List寻找一个元素并不是每一个都是要n次才找到的，根据这里的源码可以发现，综合起来，寻找的时间就是1,2,3,4...n/2,n/2...4,3,2,1。

总次数：(1+n/2)*n/2=3/4*n^2，也是O(n的平方)数量级的时间，只是并不需要用满n的平方次。

#### 链式List的增强型for循环：
遍历的每一次next方法，我们先看iterator()方法，首先获取迭代器，然后进入while循环，每次执行iterator.hasNext()方法判断是否还有下一个节点，如果有，那就执行iterator.next()方法，我们看next()方法的源码，从链表的一个节点到下一个节点，那么综上所述，每次寻找一个元素，时间复杂度是O(1)，这比普通for循环每次寻找一个元素快很多了，普通for循环每次寻找一个元素的时间复杂度是O(n)，这里要遍历n次，所以遍历的时间复杂度就是O(n)，所以链式List用增强型for循环会比用普通for循环快很多，快一个数量级。

我们通过上面源码就会发现，其实这是一个策略的问题，对于链式List，因为是链式的，每次查找一个元素都要从链表的开头节点或结尾节点往中间一个一个找，本来遍历n个元素就要一共寻找n^2次的，但是因为遍历需要的是全部元素，而每一个元素都有一个特点，都会保存着下一个节点的地址，所以就可以换一个策略，从开始节点开始找，通过节点找到下一个节点，再通过下一个节点找到下下一个节点，直到结束节点，就不需要每次寻找一个元素都要重新从头节点开始重新寻找一次。一个简单思路的转换，就能把时间缩短一个数量级。
