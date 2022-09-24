package com.concurrent.test;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class VolatileNotAtomic {
    private static volatile long count = 0L;
    private static final int NUMBER = 6000;

    public static void main(String[] args) {
        Thread subtractThread = new SubtractThread();
        subtractThread.start();

        for (int i = 0; i < NUMBER; i++) {
            count++;
//            System.out.println("count++ : " + count);
        }

        while (subtractThread.isAlive()) {}

        System.out.println("count最后的值为 ： " + count);
    }

    private static class SubtractThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < NUMBER; i++) {
                count--;
            }
        }
    }
}
