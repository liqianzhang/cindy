package com.easycode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class CoverageSampleMethods {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("log.api.impl");
    }
    public Boolean testMethod(int a, int b ,int c) {
        boolean result = false;
        if (a == 1 && b == 2 || c == 3) {
            result = true;
        }
        return result;
    }
}
