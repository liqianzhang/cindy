package com.threadpool;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        int COUNT_BITS = Integer.SIZE - 3;
        System.out.println(COUNT_BITS);
        int COUNT_MUSK = (1 << COUNT_BITS) - 1;
        System.out.println(Integer.toBinaryString(COUNT_MUSK));
    }
}
