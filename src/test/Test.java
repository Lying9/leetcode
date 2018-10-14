package test;

import array.medium.MyCalendar;
import sun.util.resources.ar.CalendarData_ar;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/10/27.
 */
public class Test {
    public static void main(String[] args) {
  /*      System.out.println(new A().getClass());
        A a = new B();
        System.out.println(a.getClass());
        System.out.println(new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        }.getClass());*/
/*    HashMap<Integer,Integer> map = new HashMap<>();
     map.put(1,2);
    //map.put(1,3);
        System.out.println(map.toString());*/
//测试lambda表达式
     /*   List<String> names = new ArrayList();
        names.add("zhangsan");
        names.add("lisi");
        names.add("wangwu");
//        names.forEach((person)-> System.out.println(person));
        names.forEach(System.out::println);*/
       /* List<String> collected = new ArrayList<>();
        collected.add("alpha");
        collected.add("beta");
        collected = collected.stream().map(string -> string.toUpperCase()).collect(Collectors.toList());

        System.out.println(collected);*/
       /* System.out.println(new Integer(12).byteValue());
        System.out.println(new Integer(21).byteValue());*/

    }

    static class A {

    }

    static class B extends A {

    }
       /* int[] a = new int[2];
        for (int i = 0; i <a.length ; i++) {
            a[i] = i;
        }
        System.out.println(Arrays.toString(a));*/
       /* List<Integer> list = new ArrayList<>();
        List<List<Integer>>  list1 = new ArrayList<>();
        list.add(1);
        list.add(2);
        list1.add(list);
        System.out.println(list1.size());
        aaa(list1);
        System.out.println(list1.size());*/

        /*int start = 47,end = 15;*/
       /* MyCalendar obj = new MyCalendar();
       *//*  boolean param_1 = obj.book(start,end);
        System.out.println(param_1);*//*
        System.out.println(obj.book(47,50));
        System.out.println(obj.book(33,41));
        System.out.println(obj.book(39,45));
        System.out.println(obj.book(33,42));
        System.out.println(obj.book(25,32));
        System.out.println(obj.book(26,35));
        System.out.println(obj.book(19,25));
        System.out.println(obj.book(3,8));
        System.out.println(obj.book(8,13));
        System.out.println(obj.book(18,27));*/


    public static void aaa(List<List<Integer>> list1) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list1.add(list);
    }

}


