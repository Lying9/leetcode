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

//        测试final
         /*final FinalTest fs = new FinalTest(5);
         fs.print();
         fs.setValue(6);
         fs.print();*/



//        深浅拷贝  String 深拷贝
        /*String s = "123";
        String s1 = s;
        s1 =  s1.substring(1);
        System.out.println(s);
        System.out.println(s1);*/
        /*String s = "AQS";
        toLow(s);
        System.out.println(s);  //AQS*/

//        测试传值
        /*A a = new A(3);
        System.out.println(a.toString());
        compute(a);
        System.out.println(a.toString());
*/

        /*String s1 = new String("777");
        String s2 = "aaa777";
        String s3 =  "aaa"+s1;
        System.out.println(s3==s2);*/

      /*  String s1 = "abcd";
        char[] ch = {'a','b','c','d'};
        char[] cc = s1.toCharArray();
//        System.out.println(ch==cc);
        System.out.println(ch.equals(cc));*/

       /* int[] a = {1,2,3};
        int[] b = {1,2,3};
        System.out.println(a.equals(b));*/

      /*  A m = new A(1);
        A n = new A(1);
        System.out.println(m == n);
        System.out.println(m.equals(n));
        String a = "222";
        String b = "222";
        System.out.println(a==b);
        System.out.println(a.equals(b));*/


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

    //    测试方法传值
    public static void compute(A a) {
        a.value = a.value + 1;
    }

    public static void toLow(String s ){
        s = s.toLowerCase();
    }

    static class A {
        private int value;

        public A(int value) {
            this.value = value;
        }
        public String toString(){
            return String.valueOf(this.value);
        }

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

    static class FinalTest{
        int value;
        public FinalTest(int value){
            this.value = value;
        }
        public void setValue(int value){
            this.value = value;
        }
        public void print(){
            System.out.println(this.value);
        }
    }

}


