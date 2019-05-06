package test;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/10/27.
 */



public class Test {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {


        System.out.println(6*0.7*10/10);
      /*  ArrayList<Integer> list = new ArrayList<>();
        list.listIterator();
*/

        //反射  设置私有属性
   /*     Class clazz = Class.forName("test.Person");
        Person obj = (Person) clazz.newInstance();
//      clazz.getFields();    返回表示类或接口的public的属性
//      clazz.getDeclaredFields()  返回表示类或接口的所有属性
        Field[] fileds = clazz.getDeclaredFields();
        for (int i = 0; i < fileds.length; i++) {
//        fileds[i].setAccessible(true);  设置访问权限为true;
            fileds[i].setAccessible(true);
            fileds[i].set(obj, "1");
        }
        System.out.println(obj.toString());
*/

      /*  String str = "<p> this is a test ...</p>";
        String s ="\\w+";
        Pattern  p  = Pattern.compile("(?<=<("+s+")>)");
        Matcher m = p.matcher(str);
        if(m.find())

            System.out.println(m.group());*/


      /*Student s = new Student(1);
      Student ss = new Student(1);
        System.out.println(s.hashCode());
        System.out.println(ss.hashCode());//没有重写hashcode是不一样的,重写hashcode后是一样的*/

       /* boolean a= true;
       boolean b = true;
        System.out.println(a&b);*/



      /* Student p= new Student(1);
        System.out.println(p instanceof  Person);*/

      /*  TreeMap<Student,Integer> map = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.age - o2.age;
            }
        });*/
      /*HashMap<Student,Integer> map = new HashMap<>();
        Student st1 = new Student(1);
        Student st2 = new Student(2);
        Student st3 = new Student(3);
        map.put(st1,1);
        map.put(st2,2);
        map.put(st3,3);
      *//*  for(Student s:map.keySet()){
            System.out.println(s.toString() + map.get(s) );
        }*//*
        System.out.println(map);

        st1.age = 90;
       *//* for(Student s:map.keySet()){
            System.out.println(s.toString() + map.get(s) );
        }*//*
        System.out.println(map);*/
        /*ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        System.out.println(list);*/
    /*    Set<Integer>  set = new HashSet<>();
        set.add(1);
        set.add(2);
        System.out.println(set);*/


//        String s = "acv";
       /* String s = new String("avc");
        String  s1 = s.intern();
        String str  = "acv";
        String s2 = "acv";
        System.out.println(s1 == str);
        System.out.println(s2 == str);
        System.out.println(s2 == s1);*/


    /*    String s = "12,34,5";
        String[] c = s.split(",");
        for(String l:c){
            System.out.println(Integer.valueOf(l));
        }
*/


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
    /*public static void compute(A a) {
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

    }*/


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

    static class FinalTest {
        int value;

        public FinalTest(int value) {
            this.value = value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void print() {
            System.out.println(this.value);
        }
    }

}

class Person {

    public String getSex() {
        return sex;
    }

    public String getAge() {
        return age;
    }

    public String name;
    protected String sex;
    private String age;

    public String getName() {
        return this.name;
    }

    public String toString() {
        return (this.getName() + "  " + this.getSex() + "  " + this.getAge());
    }

}
/*class Student extends Person{
     int age;
    public Student(String name,int age){
        super(name);
        this.age = age;
    }
    public String toString(){

        return "Student [age ="+age+"]";
    }
    public int hashCode(){
        return Integer.hashCode(age);
    }
}*/



