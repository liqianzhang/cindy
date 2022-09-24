package com.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class UserThreadFactory implements ThreadFactory {

    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger(1);

    public UserThreadFactory(String whatFeatureOfGroup) {
        namePrefix = "UserThreadFactory's " + whatFeatureOfGroup + "-Worker-";
    }

    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(null, task, name, 0);
        System.out.println(thread.getName());
        return thread;
    }
}
//任务执行体
class Task implements Runnable {
    private final AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        System.out.println("running_" +count.getAndIncrement());
    }
}
