package com.stream;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class Test {
    public static void main(String[] args) {
        Order order = new Order();
        order.setPlacedAt(LocalDateTime.now());
    }
}
