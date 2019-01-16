package test;

/**
 * Created by Administrator on 2018/1/21.
 */
public class Foo {

    /* int x = 12;
    public static  void go(final int x){
        System.out.println(x);
    }*/
    public static void main(String[] args) {

        int[] a = {1,2,3,4,5};
        int[] b = a.clone();
        b[0] = 5;
        for(int i : a)
            System.out.print(i);
        System.out.println();
        for(int i : b)
            System.out.print(i);

    }
}
