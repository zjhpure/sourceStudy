package org.pure.sourceStudy.stringBuilderAndBuffer;

/**
 * @author zhangjianhua
 * @date 2021-10-08 16:31
 * @description 测试StringBuilder和StringBuffer的线程安全
 */
public class Main {

    public static void main(String[] args) {
        testStringBuilderMulThread();
        testStringBufferMulThread();
    }

    // 测试StringBuilder多线程(线程不安全，因为append方法无synchronized关键字)
    private static void testStringBuilderMulThread() {
        StringBuilder stringBuilder = new StringBuilder();

        // 开启10个线程
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                // 每个线程添加1000个字符串a
                for (int j = 0; j < 1000; j++) {
                    stringBuilder.append("a");
                }
            }).start();
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 有线程安全问题，输出结果小于预期的10000，有时会抛出ArrayIndexOutOfBoundsException异常
        System.out.println("StringBuilder长度：" + stringBuilder.length());
    }

    // 测试StringBuffer多线程(线程安全，因为append方法有synchronized关键字)
    private static void testStringBufferMulThread() {
        StringBuffer stringBuffer = new StringBuffer();

        // 开启10个线程
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                // 每个线程添加1000个字符串a
                for (int j = 0; j < 1000; j++) {
                    stringBuffer.append("a");
                }
            }).start();
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 无线程安全问题，输出结果等于预期的10000，不会抛出ArrayIndexOutOfBoundsException异常
        System.out.println("StringBuffer长度：" + stringBuffer.length());
    }

}
