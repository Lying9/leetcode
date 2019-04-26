package test;

/**
 * Created by ying on 2019/4/26.
 */
public class Static {

    String name;

    static {
        System.out.println(test.Static.class.getClassLoader() + "  Static::static");
    }

    public Static(String name) {
        this.name = name;
    }

    public Static() {

    }

    public void print() {
        System.out.println("print");
    }

}
