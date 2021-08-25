package org.pure.sourceStudy.autoAdd;

import java.util.Arrays;

/**
 * @author zhangjianhua
 * @date 2021-08-25 23:45
 * @description 测试自增
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("start");

        int i = 0;
        int[] nums = new int[10];

        // 加号在后面，先赋值给数组，再自增，这时nums[0] = 1，所以nums的结果是[1, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        nums[i++] = 1;

        System.out.println("i:" + i);
        System.out.println("nums:" + Arrays.toString(nums));

        int k = 0;
        int[] arrs = new int[10];

        // 加号在前面，先自增，再赋值给数组，这时nums[1] = 1，所以nums的结果是[0, 1, 0, 0, 0, 0, 0, 0, 0, 0]
        arrs[++k] = 1;
        System.out.println("k:" + i);
        System.out.println("arrs:" + Arrays.toString(arrs));

        System.out.println("end");
    }

}
