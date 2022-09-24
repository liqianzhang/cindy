package com.concurrent.test;

import java.util.concurrent.CountDownLatch;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class TranslateThread extends Thread {
    private String content;
    private final CountDownLatch count;

    public TranslateThread(String content, CountDownLatch count) {
        this.content = content;
        this.count = count;
    }

    @Override
    public void run() {
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                //在某种情况下，执行翻译解析时，抛出异常
                double random = Math.random();
                System.out.println(random);
                if (random < 0.5) {
                    throw new RuntimeException("原文存在非法字符");
                }
            }
        });



        System.out.println(content + " 的翻译已完成，译文是。。。");
//        System.out.println("countDown前 count的值： "  + count);
        count.countDown();
//        System.out.println("countDown后 count的值： "  + count);

    }
}
