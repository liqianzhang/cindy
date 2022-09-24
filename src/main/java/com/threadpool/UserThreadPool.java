package com.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class UserThreadPool {
    public static void main(String[] args) {
        //缓存队列设置固定长度为2， 为了快速触发rejectHandler
        LinkedBlockingQueue queue = new LinkedBlockingQueue(2);

        //假设外部任务线程的来源由机房1和机房2的混合调用
        UserThreadFactory f1 = new UserThreadFactory("第1机房");
        UserThreadFactory f2 = new UserThreadFactory("第2机房");

        UserRejectHandler handler = new UserRejectHandler();

        //核心线程为1， 最大线程为2，

        ThreadPoolExecutor threadPool1 = new ThreadPoolExecutor(1,
                2,
                60,
                TimeUnit.SECONDS,
                queue,
                f1,
                handler);

        ThreadPoolExecutor threadPool2 = new ThreadPoolExecutor(1,
                2,
                60,
                TimeUnit.SECONDS,
                queue,
                f2,
                handler);

        //创建400个线程

        Runnable task = new Task();
        for (int i = 0; i < 200; i++) {
            threadPool1.execute(task);
            threadPool2.execute(task);
        }

    }
}
