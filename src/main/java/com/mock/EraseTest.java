package com.mock;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * @MethodName: $
 * @Description: 擦除
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 *
 *    以下我们定义了两个ArrayList集合，一个是ArrayList<String>，
 *    一个是ArrayList<Integer>的泛型类型，最后我们通过获取他们
 *    类对象的getClass()的信息，结果为true。说明String和Integer
 *    都背擦除了，剩下的只是泛型类型。无论何时定义一个泛型，都自动
 *    提供一个相应的原始类型。原始类型的名字就是删去类型数后的泛型类型名。
 *    擦除类型变量，并替换成限定类型。

 */
public class EraseTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("abc");
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(123);

        /**
         *   在程序中定义了一个ArrayList泛型类型实例化为Integer对象，如果直接调用add()方法，
         *   那么只能存储整数数据，当我们利用反射调用的时候，却可以存储字符串，这说明Integer
         *   泛型实例在编译之后被擦除了，只保留了原始类型。
         *
         */
        list2.getClass().getMethod("add", Object.class).invoke(list2, "asd");


        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i));
        }
        System.out.println(list1.getClass() == list2.getClass());
    }
}
