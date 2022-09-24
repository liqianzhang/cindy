package com.jiayu;

import ch.qos.logback.core.html.IThrowableRenderer;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class LambdaTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //int thread = thread(10000, 20);
//        int i = ThreadPool(10000, 20);
//        int i = forkJoin(10000, 20);
//        int stream = stream(10000, 20);
        int i = completableFuture(10000, 20);
        System.out.println(i);


    }

    private static int completableFuture(int taskCount, int threadCount) throws ExecutionException, InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        ForkJoinPool forkJoinPool = new ForkJoinPool(threadCount);
        CompletableFuture.runAsync(() -> IntStream.rangeClosed(1, taskCount).parallel().forEach(i -> increment(atomicInteger)), forkJoinPool).get();
        return atomicInteger.get();
    }

    //并行执行这个方法，把这5种方法掌握了，那了不得了，解决不少问题，人家的技术怎么那么厉害
    private static void increment(AtomicInteger atomicInteger) {
        atomicInteger.incrementAndGet();
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int thread(int taskCount, int threadCount) throws InterruptedException {
        //总操作次数计数器
        AtomicInteger atomicInteger = new AtomicInteger();
        //使用countDownLunch来等待所有线程执行完成
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        //使用IntStream把数字直接转为Thread
        IntStream.rangeClosed(1, threadCount).mapToObj(i -> new Thread(() -> {
            //手动把taskCount分成threadCount份，每一份有一个线程执行
            IntStream.rangeClosed(1, taskCount / threadCount).forEach(j -> increment(atomicInteger));
            //每个线程处理完自己的那部分数据后countDown一次
            countDownLatch.countDown();
        })).forEach(Thread ::start);
        countDownLatch.await();
        return atomicInteger.get();
    }

    private static int ThreadPool(int taskCount, int threadCount) throws InterruptedException {
        //总操作次数计数器
        AtomicInteger atomicInteger = new AtomicInteger();
        //初始化一个threadCount数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        //所有任务提交到线程池处理
        IntStream.rangeClosed(1, taskCount).forEach(i -> executorService.execute(() -> increment(atomicInteger)));
        //提交关闭线程池申请，等到之前所有任务执行完成
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        return atomicInteger.get();
    }

    private static int forkJoin(int taskCount, int threadCount) throws InterruptedException {
        //总操作次数计数器
        AtomicInteger atomicInteger = new AtomicInteger();
        //自定义一个并行度为threadCount的ForkJoinPool
        ForkJoinPool forkJoinPool = new ForkJoinPool(threadCount);
        //所有任务直接提交到线程池处理
        forkJoinPool.execute(() -> IntStream.rangeClosed(1, taskCount).parallel().forEach(i -> increment(atomicInteger)));
        //提交关闭线程池申请，等待之前所有任务执行完成
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        return atomicInteger.get();
    }

    private static int stream(int taskCount, int threadCount) {
        //设置公共forkJoinPool的并行度
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", String.valueOf(threadCount));
        //总操作次数计数器
        AtomicInteger atomicInteger = new AtomicInteger();
        IntStream.rangeClosed(1, taskCount).parallel().forEach(i -> increment(atomicInteger));
        return atomicInteger.get();
    }
}
