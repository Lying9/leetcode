package test;

import sun.rmi.server.LoaderHandler;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ying on 2019/4/25.
 */
public class StaticCountTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //System.out.println(Static.class.getClassLoader());

        /*ClassLoader myLoader = new ClassLoader(){
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                InputStream is = getClass().getResourceAsStream(fileName);
                if(is == null)
                    return super.loadClass(name);
                byte[] b = new byte[0];
                try {
                    b = new byte[is.available()];
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    is.read(b);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return defineClass(name,b,0,b.length);

            }

        };*/
       /* MyLoder myLoader = new MyLoder();

        System.out.println(myLoader);
        Object obj = myLoader.loadClass("test.Static");*/
        //System.out.println();
       // Static s = new Static("a");

        ClassLoader cl = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                InputStream is = getClass().getResourceAsStream(fileName);
                if(is == null)
                    return super.loadClass(name);
                byte[] b = new byte[0];
                try {
                    b = new byte[is.available()];
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    is.read(b);
                } catch (IOException e) {
                    e.printStackTrace();
                }
               // System.out.println("加载完成");
                return defineClass(name,b,0,b.length);

            }
        };
        Class clazz =  cl.loadClass("test.Static");
        Object o = clazz.newInstance();
       // System.out.println(o.newInstance() instanceof  test.Static);
        Static s = new Static();

    }

}

/*class Static {
    String name;

    static {
        System.out.println(Static.class.getClassLoader() +  "  Static::static");
    }

    public Static(String name) {
        this.name = name;
    }
    public Static() {

    }

    public void print() {
        System.out.println("print");
    }
}*/

class MyLoder extends ClassLoader{
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
        InputStream is = getClass().getResourceAsStream(fileName);
        if(is == null)
            return super.loadClass(name);
        byte[] b = new byte[0];
        try {
            b = new byte[is.available()];
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            is.read(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("加载完成");
        return defineClass(name,b,0,b.length);

    }
}

