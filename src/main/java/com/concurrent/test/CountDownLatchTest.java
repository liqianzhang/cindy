package com.concurrent.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(3);
        Thread thread1 = new TranslateThread("1st content" ,count);
        Thread thread2 = new TranslateThread("2st content" ,count);
        Thread thread3 = new TranslateThread("3st content" ,count);

        thread1.start();
        thread2.start();
        thread3.start();

        count.await(10, TimeUnit.SECONDS);
        System.out.println("所有线程执行完成");
    }
}
