## 公众号(纯洁编程说：chunjie_tech)

## 文章地址(列表for循环)

https://mp.weixin.qq.com/s/A8Izwja_ZKwngu2XnMmXlg

## 文章内容

**Java列表应该如何遍历效率更好？**

**Java有三种遍历的方式：**

- **普通for循环遍历(for)**

- **增强型for循环遍历(foreach)**

- **迭代器循环遍历(iterator)**

**这三种遍历方式是有差别的。**

**下面先用一个程序来对比不同的列表用不同的遍历方式所花的时间差别：**

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
```

**来看运行结果：**
![运行结果](https://upload-images.jianshu.io/upload_images/4362697-1d5513181120c889.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

我们可以发现，对于顺序式列表ArrayList，普通for循环、增强型for循环、迭代器循环三者差别不大，遍历10万次都是花费2ms。

但是对于链式列表LinkedList，普通for循环和增强型for循环、迭代器循环的差别非常大，普通for循环遍历10万次花费4390ms，而增强型for循环、迭代器循环遍历10万次仅花费3ms、1ms。

**为什么会这样？**

因为顺序式列表用三种遍历的任意一种，时间复杂度都是O(n)。而链式列表用普通for循环遍历，时间复杂度是O(n^2)，但是如果链式列表用增强型for循环、迭代器循环的时间复杂度是O(n)，相差了一个数量级的时间，所以链式列表用普通for循环遍历会很慢。

**首先，对于列表的增强型for循环，其实是等同于迭代器循环的。**

**如何看出的？**

可以看编译后的class文件，通过反编译可以看到列表的增强型for循环转换为迭代器循环。不过这里要说一下，对于基本类型的数组使用增强型for循环，编译后是转换为普通for循环的，不是转换为迭代器循环，因为基本类型的数组没有定义迭代器循环的方法，所以就转换为了普通for循环。

上面运行程序的testForeachTransform方法，有做了列表的增强型for循环和基本类型数组的增强型for循环的转换对比测试，运行程序后查看编译后的class文件，可以看到转换成了什么代码，后面的分析会具体展开说。

**因为对于列表，增强型for循环转换为迭代器循环，而列表分为顺序式和链式，所以从四个方面去分析：**

- **顺序式列表的普通for循环**
- **顺序式列表的增强型for循环**
- **链式列表的普通for循环**
- **链式列表的增强型for循环**

**为什么链式列表用了迭代器循环会比普通for循环少一个指数数量级的时间？我们可以通过看源码找到答案。**

**下面手把手地教大家如何看源码，如何从源码中找到遍历效率的答案：**

#### 准备

这里以jdk1.8作为测试，从GitHub找到测试源码，地址：https://github.com/zjhpure/sourceStudy/blob/master/src/main/java/org/pure/sourceStudy/listForeach/Main.java，用idea打开，打开如图所示的地方。

![测试代码](https://upload-images.jianshu.io/upload_images/4362697-f2105e908c9d7f13.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

#### 顺序式列表的普通for循环

找到arrayListForTime方法，如下图：

![arrayListForTime方法](https://upload-images.jianshu.io/upload_images/4362697-4e116a22ca7caf4e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

从代码可以看出，记录开始时间和记录结束时间之间的代码就是for循环消耗的时间，遍历的每一次都是调用get方法，所以只要知道get方法消耗的时间是多少，就能知道for循环一共消耗多少时间。我们先通过idea的跳转功能，看看get方法的源码，但是跳转后显示的是一个接口，如下图：

![get方法接口](https://upload-images.jianshu.io/upload_images/4362697-a600e0d022552523.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

**怎么办？应该怎样才能找到get方法的源码？**

这时候需要通过打断点来调试，才能找到get方法的源码。在get方法处打一个断点，点击调试按钮，程序运行后会跳到get方法处停着，调试时执行Force Step Into，跳入到get方法的源码中，就可以看到get方法的源码，如下图：

![断点调试](https://upload-images.jianshu.io/upload_images/4362697-d7b9e87bbc04b24b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

我们可以看到get方法源码是长这样的，如下图：

![get方法源码](https://upload-images.jianshu.io/upload_images/4362697-df6bf8b6ac2fd489.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

如果在调试看get方法的源码时又遇到接口，继续执行Force Step Into，跳进方法内部，就可以看到方法的源码。后面还会有很多看源码的操作，就不会再细写怎么找到源码的方法了，同样按照上面的操作就能找到。

回到源码，这里由两部分组成，首先执行rangeCheck方法，再执行elementData方法。第一步的rangeCheck方法，其实就是检查输入的下标是否超过了数组的长度size，源码如下：

```
    /**
     * Checks if the given index is in range.  If not, throws an appropriate
     * runtime exception.  This method does *not* check if the index is
     * negative: It is always used immediately prior to an array access,
     * which throws an ArrayIndexOutOfBoundsException if index is negative.
     */
    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
```

第二步的elementData方法，源码如下：

```
    // Positional Access Operations

    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) elementData[index];
    }
```

这里直接就是从elementData数组中取元素，因为是顺序式列表，底层是用数组保存元素的，通过idea点击跳转elementData可以看到elementData是一个数组，如下图：

![ArrayList定义](https://upload-images.jianshu.io/upload_images/4362697-19c78f117a74febf.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

**所以综上所述可以看到，对于顺序式列表的普通for循环，每次get方法的时间复杂度是O(1)，遍历n个元素的时间复杂度是O(n)。**

#### 顺序式列表的增强型for循环

对于列表，增强型for循环会转换为迭代器循环，可以从Java运行后编译的class文件找到答案，我们先找到testForeachTransform方法，如下图：

![testForeachTransform方法](https://upload-images.jianshu.io/upload_images/4362697-71e552a67312775b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

点击运行程序，查看编译生成的class文件，我们可以看到，对于基本类型数组，增强型for循环转换为普通for循环，而对于列表，增强型for循环转换为迭代器循环，如下图：

![testForeachTransform方法的class编译](https://upload-images.jianshu.io/upload_images/4362697-29169e2e713b0958.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

**所以分析列表的增强型for循环，其实就是分析列表的迭代器循环，下面分析顺序式列表的迭代器循环**

我们找到arrayListIteratorTime方法，如下图：

![arrayListIteratorTime方法](https://upload-images.jianshu.io/upload_images/4362697-0f64ff4599b395aa.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

遍历的每一次都是调用next方法，所以只要知道next方法消耗的时间是多少，就能知道迭代器循环一共消耗多少时间。列表arrayList先调用iterator方法获取迭代器iterator，然后每次遍历调用迭代器iterator的next方法，我们先看iterator方法的源码，如下：

```
    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * <p>The returned iterator is <a href="#fail-fast"><i>fail-fast</i></a>.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    public Iterator<E> iterator() {
        return new Itr();
    }
```

在iterator方法里，创建一个Itr对象，Itr类是一个内部类，我们再看Itr类的源码，如下：

```
    /**
     * An optimized version of AbstractList.Itr
     */
    private class Itr implements Iterator<E> {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        int expectedModCount = modCount;

        Itr() {}

        public boolean hasNext() {
            return cursor != size;
        }

        @SuppressWarnings("unchecked")
        public E next() {
            checkForComodification();
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData = ArrayList.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return (E) elementData[lastRet = i];
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                ArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        @SuppressWarnings("unchecked")
        public void forEachRemaining(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            final int size = ArrayList.this.size;
            int i = cursor;
            if (i >= size) {
                return;
            }
            final Object[] elementData = ArrayList.this.elementData;
            if (i >= elementData.length) {
                throw new ConcurrentModificationException();
            }
            while (i != size && modCount == expectedModCount) {
                consumer.accept((E) elementData[i++]);
            }
            // update once at end of iteration to reduce heap write traffic
            cursor = i;
            lastRet = i - 1;
            checkForComodification();
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }
```
正好可以看到Itr类有一个next方法和hasNext方法，在while循环的条件里调用的就是hasNext方法，从源码可以看到，hasNext方法就是判断游标cursor是否等于列表的长度size，一旦等于，while循环结束。

我们来分析next方法，next方法的源码只有三句是关键，如下图：

![next方法关键语句](https://upload-images.jianshu.io/upload_images/4362697-574ae3fed4a99207.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

ArrayList.this.elementData就是获取列表的数组，然后cursor=i + 1，就是游标加1，最后从数组elementData中取元素，返回元素。

**所以综上所述可以看到，对于顺序式列表的增强型for循环(迭代器循环)，每次next方法的时间复杂度是O(1)，遍历n个元素的时间复杂度是O(n)。**

#### 链式列表的普通for循环

找到linkedListForTime方法，如下图：

![linkedListForTime方法](https://upload-images.jianshu.io/upload_images/4362697-73233b2eebfaafa5.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

用同样的方法去阅读源码，我们可以发现遍历的每一次都是调用get方法，所以只要知道get方法消耗的时间是多少，就能知道for循环一共消耗多少时间。找到get方法的源码，如下：

```
    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }
```

先调用checkElementIndex方法，再返回node(index).item。我们来看checkElementIndex方法的源码，如下：

```
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
```

这里调用了isElementIndex方法，再看isElementIndex方法的源码，如下：

```
    /**
     * Tells if the argument is the index of an existing element.
     */
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }
```

从源码可以看到，这个方法的意思就是判断是否是元素的下标，其实和顺序式列表的rangeCheck方法差不多，都是判断下标的合法性。那么再看前面get方法的node(index).item，源码如下：

```
    /**
     * Returns the (non-null) Node at the specified element index.
     */
    Node<E> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
```

因为是链式列表，底层用链表保存元素。从node方法的源码可以看出整个过程，先判断下标位置是在中间靠右还是中间靠左，如果中间靠左，那就从开始节点往后面一个一个地寻找，如果是中间靠右，那就从结束节点往前面一个一个地寻找，所以链式列表寻找一个元素的时间复杂度是O(n)。

**从这里就可以看出，链式列表寻找一个元素的效率就比顺序式列表寻找一个元素的效率要低很多了，因为顺序式列表寻找一个元素的时间复杂度是O(1)，链式列表寻找一个元素的时间复杂度是O(n)。**

**因为要有n个元素需要遍历，所以链式列表遍历n个元素的时间复杂度是O(n^2)，链式列表的普通for循环很慢，比顺序式列表的普通for循环慢了一个数量级。**

**但是链式列表寻找一个元素并不是每一个都要n次才能找到的，根据这里的源码可以发现，会根据下标在中间靠右还是靠左来判断是从开始节点往后还是从结束节点往前，综合起来，寻找的时间是1，2，3，4...n/2，n/2...4，3，2，1。**

**总次数：(1+n/2)n/2=3/4n^2，四分之三n的平方，同样也是n的平方的数量级。**

**所以综上所述可以看到，对于链式列表的普通for循环，每次get方法的时间复杂度是O(n)，遍历n个元素的时间复杂度是O(n^2)。**

#### 链式列表的增强型for循环

对于链式列表，增强型for循环同样也会转换为迭代器循环。

**所以分析列表的增强型for循环，其实就是分析列表的迭代器循环，下面分析链式列表的迭代器循环**

我们找到linkedListIteratorTime方法，如下图：

![linkedListIteratorTime方法](https://upload-images.jianshu.io/upload_images/4362697-4742236006dd3e20.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

遍历的每一次都是调用next方法，所以只要知道next方法消耗的时间是多少，就能知道迭代器循环一共消耗多少时间。列表linkedList先调用iterator方法获取迭代器iterator，然后每次遍历调用迭代器iterator的next方法，我们先看iterator方法的源码，如下：

```
    /**
     * Returns an iterator over the elements in this list (in proper
     * sequence).<p>
     *
     * This implementation merely returns a list iterator over the list.
     *
     * @return an iterator over the elements in this list (in proper sequence)
     */
    public Iterator<E> iterator() {
        return listIterator();
    }
```

在iterator方法里，调用listIterator方法，源码如下：

```
    /**
     * {@inheritDoc}
     *
     * <p>This implementation returns {@code listIterator(0)}.
     *
     * @see #listIterator(int)
     */
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }
```

在listIterator方法里，调动方法listIterator(0)，这里的意思是从链表的第一个元素开始，源码如下：

```
    /**
     * Returns a list-iterator of the elements in this list (in proper
     * sequence), starting at the specified position in the list.
     * Obeys the general contract of {@code List.listIterator(int)}.<p>
     *
     * The list-iterator is <i>fail-fast</i>: if the list is structurally
     * modified at any time after the Iterator is created, in any way except
     * through the list-iterator's own {@code remove} or {@code add}
     * methods, the list-iterator will throw a
     * {@code ConcurrentModificationException}.  Thus, in the face of
     * concurrent modification, the iterator fails quickly and cleanly, rather
     * than risking arbitrary, non-deterministic behavior at an undetermined
     * time in the future.
     *
     * @param index index of the first element to be returned from the
     *              list-iterator (by a call to {@code next})
     * @return a ListIterator of the elements in this list (in proper
     *         sequence), starting at the specified position in the list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     * @see List#listIterator(int)
     */
    public ListIterator<E> listIterator(int index) {
        checkPositionIndex(index);
        return new ListItr(index);
    }
```

在另一个listIterator方法里，调用checkPositionIndex方法，然后创建一个ListItr对象，ListItr类是一个内部类，我们先看checkPositionIndex方法，源码如下：

```
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
```

在checkPositionIndex方法里，调用isPositionIndex方法，源码如下：

```
    /**
     * Tells if the argument is the index of a valid position for an
     * iterator or an add operation.
     */
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }
```

从源码可以看到，isPositionIndex方法的意思就是判断是否是元素的下标，和顺序式列表的rangeCheck方法差不多，都是判断下标的合法性。我们再看ListItr类的源码，如下：

```
    private class ListItr implements ListIterator<E> {
        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;
        private int expectedModCount = modCount;

        ListItr(int index) {
            // assert isPositionIndex(index);
            next = (index == size) ? null : node(index);
            nextIndex = index;
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public E next() {
            checkForComodification();
            if (!hasNext())
                throw new NoSuchElementException();

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }

        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        public E previous() {
            checkForComodification();
            if (!hasPrevious())
                throw new NoSuchElementException();

            lastReturned = next = (next == null) ? last : next.prev;
            nextIndex--;
            return lastReturned.item;
        }

        public int nextIndex() {
            return nextIndex;
        }

        public int previousIndex() {
            return nextIndex - 1;
        }

        public void remove() {
            checkForComodification();
            if (lastReturned == null)
                throw new IllegalStateException();

            Node<E> lastNext = lastReturned.next;
            unlink(lastReturned);
            if (next == lastReturned)
                next = lastNext;
            else
                nextIndex--;
            lastReturned = null;
            expectedModCount++;
        }

        public void set(E e) {
            if (lastReturned == null)
                throw new IllegalStateException();
            checkForComodification();
            lastReturned.item = e;
        }

        public void add(E e) {
            checkForComodification();
            lastReturned = null;
            if (next == null)
                linkLast(e);
            else
                linkBefore(e, next);
            nextIndex++;
            expectedModCount++;
        }

        public void forEachRemaining(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            while (modCount == expectedModCount && nextIndex < size) {
                action.accept(next.item);
                lastReturned = next;
                next = next.next;
                nextIndex++;
            }
            checkForComodification();
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }
```

正好可以看到ListItr类有一个next方法和hasNext方法，在while循环的条件里调用的就是hasNext方法，从源码可以看到，hasNext方法就是判断游标nextIndex是否等于列表的长度size，一旦等于，while循环结束。

我们来分析next方法，从next方法的源码可以发现，它在沿着链表不断往后遍历，如下图：

![next方法关键地方](https://upload-images.jianshu.io/upload_images/4362697-3750394ff7820bd5.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

所以迭代器循环遍历n个元素的时间复杂度是O(n)，比普通for循环遍历n个元素的O(n^2)快了一个数量级。

**为什么突然就降低一个数量级了？**

我们仔细对比上面的源码就可以看出，其实迭代器循环的遍历只是改变了一下思路，对于链式列表的普通for循环，每次查找一个元素都要从链表的开始节点或结束节点往中间一个一个地找，这样找一个元素，那就要O(n)的时间复杂度了。但是我们想一下，本来就是要遍历全部元素的，能不能不要每次都重新寻找一次元素？当然可以，因为每一个元素都保存有下一个节点的地址，所以就可以换一个思路了，从开始节点开始遍历，通过节点找到下一个节点，再通过下一个节点找到下下一个节点，直到结束节点，就不需要每次寻找一个元素都要重新寻找一次了。

**迭代器循环的遍历就是上面的思路。一个思路的简单改变，就能把时间降低一个数量级。**

**对于链式列表，使用普通for循环遍历，每次get方法的时间复杂度是O(n)，但是使用迭代器循环遍历，每次next方法的时间复杂度是O(1)，所以能够大幅减低时间。而链式列表之所以每次next方法的时间复杂度是O(1)，是因为每次next方法都是将指针向后移动一位，而不是像普通for循环的get方法那样从头到尾寻找一次。**

**所以综上所述可以看到，对于链式列表的增强型for循环(迭代器循环)，每次next方法的时间复杂度是O(1)，遍历n个元素的时间复杂度是O(n)。**

#### 总结

**根据测试结果：**
- **ArrayList通过普通for循环遍历10万条数据，花费2ms，时间复杂度O(n)。**
- **ArrayList通过增强型for循环遍历10万条数据，花费2ms，时间复杂度O(n)。**
- **ArrayList通过迭代器循环遍历10万条数据，花费2ms，时间复杂度O(n)。**
- **LinkedList通过普通for循环遍历10万条数据，花费4390ms，时间复杂度O(n^2)，明显慢很多。**
- **LinkedList通过增强型for循环遍历10万条数据，花费3ms，时间复杂度O(n)。**
- **LinkedList通过迭代器循环遍历10万条数据，花费1ms，时间复杂度O(n)。**

**结论：**
- **对于顺序式列表，使用普通for循环遍历数据**
- **对于链式列表，使用增强型for循环遍历数据**

**公众号：纯洁编程说(chunjie_tech)**

**原文链接：https://mp.weixin.qq.com/s/A8Izwja_ZKwngu2XnMmXlg**
