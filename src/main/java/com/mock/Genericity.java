package com.mock;

import java.awt.datatransfer.FlavorListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $泛型1
 * @Author: zhangliqian
 * @Date: $
 */
public class Genericity {

    public static void main(String[] args) {
//        Genericity genericity = new Genericity();
//        Integer[] arr = new Integer[]{1, 2, 3, 4};
//        List<Integer> list = genericity.copyFrom(arr);
//        System.out.println(list);

        String[] ss = new String[] { "Orange", "Apple", "Pear" };
        Arrays.sort(ss);
        System.out.println(Arrays.toString(ss));

        Person[] ps = new Person[] {
                new Person("Bob", 61),
                new Person("Alice", 88),
                new Person("Lily", 75),
        };
        Arrays.sort(ps);
        System.out.println(Arrays.toString(ps));




    }

    static class Person implements Comparable<Person>{
        String name;
        int score;
        Person(String name, int score) {
            this.name = name;
            this.score = score;
        }
        public String toString() {
            return this.name + "," + this.score;
        }

        @Override
        public int compareTo(Person o) {
            return this.name.compareTo(o.name);
        }
    }
    public <T> T exeucte() {
        return null;
    }

    public <T> List<T> f(T a){
        return null;
    }

    public <E> List<E> copyFrom(E[] array) {
        List<E> list = new ArrayList<>();
        for (E e : array) {
            list.add(e);
        }
        return list;
    }
/*
    <T> T可以传入任何类型的list
    关于参数T的说明：
        第一个T表示<T>是一个泛型
        第二个T表示方法返回的是T类型的数据
        第三个T表示集合List传入的数据是T类型
*/

    private <T> T getStudent(List<T> list) {
        return null;
    }

    public class Pair<T>{
        private T first;
        private T second;

        public Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public T getSecond() {
            return second;
        }
    }



}
