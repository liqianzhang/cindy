package com.concurrent.test;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class CustomCheckWindow {
    public static void main(String[] args) {
        //设定3个信号量，即3个服务窗口
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 5; i++) {
            new SecurityCheckThread(i, semaphore).start();
        }

        Executors.newFixedThreadPool(10);
    }

    private static class SecurityCheckThread extends Thread {
        private int seq;
        private Semaphore semaphore;

        public SecurityCheckThread(int seq, Semaphore semaphore) {
            this.seq = seq;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("No." + seq + "乘客正在查验中 。。。");
                //假设号码整除2的人是可疑人员，需要花更长的时间安检
                if (seq % 2 == 0) {
                    Thread.sleep(1000);
                    System.out.println("No." + seq + "乘客身份可以，不能出。。。");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println("No." + seq + "乘客已完成服务。。。");
            }

        }
    }
}
