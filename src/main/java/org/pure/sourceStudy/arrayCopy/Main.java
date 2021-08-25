package org.pure.sourceStudy.arrayCopy;

/**
 * @author zhangjianhua
 * @date 2021-08-26 00:51
 * @description 测试原生的数组复制方法
 */
public class Main {

    public static void main(String[] args) {
        // 定义数组初始长度
        int size = 5000000;

        // 测试数组不同大小时arraycopy所花费的时间
        for (int i = 0; i < 5; ++i) {
            // 每次数组大小变成原来的两倍，验证不同数组大小的效果
            size = size * 2;

            // 定义长度为size的原数组
            int[] srcNums = new int[size];
            // 定义长度为size的轮询复制的数组
            int[] loopCopyNum = new int[size];
            // 定义长度为size的待复制数组
            int[] systemCopyNums = new int[size];

            // 定义开始时间和结束时间
            long start, end;

            // 计算轮询复制花费的时间
            // 开始时间
            start = System.currentTimeMillis();
            // 执行轮询，复制数组
            for (int j = 0; j < size; ++j) {
                loopCopyNum[j] = srcNums[j];
            }
            // 结束时间
            end = System.currentTimeMillis();
            // 打印时间
            System.out.println("loopCopy time:" + (end - start));

            // 计算arraycopy方法复制花费的时间
            // 开始时间
            start = System.currentTimeMillis();
            // 执行arraycopy方法，复制数组
            System.arraycopy(srcNums, 0, systemCopyNums, 0, size);
            // 结束时间
            end = System.currentTimeMillis();
            // 打印时间
            System.out.println("arraycopy time:" + (end - start));

            // 验证结果发现：轮询复制数组花费的时间和arraycopy方法复制数组花费的时间差不多

            // 猜测：arraycopy方法底层也是要轮询一次数组的元素才能完成复制的，随着数组长度的变大，执行一次arraycopy方法花费的时间会变长
            // 进一步：平时做算法时，不要轻易用列表，因为列表的每一次add都会伴随扩容，扩容都会调用arraycopy方法，数组越长花费的时间越长
            // 进一步猜测：猜测平均时间复杂度是O(n)，随着数组长度越长arraycopy方法要轮询的元素越多，总时间 = (1 + 2 + ... + n) * n / 2，平均时间 = 总时间 / n，去掉常数项和低阶项，时间复杂度的数量级还是n，即O(n)

            // 注意：arraycopy方法是native方法，是底层的java虚拟机实现的方法，目前我没有看过它的源码，上面的分析属于猜测
        }
    }

}
