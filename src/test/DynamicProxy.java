package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by ying on 2019/4/10.
 */
public class DynamicProxy {

    public static void main(String[] args) {
        Animal dog = new Dog();
        Handler handler = new Handler(dog);
//        Animal dogProxy = (Animal)Proxy.newProxyInstance(DynamicProxy.class.getClassLoader(),dog.getClass().getInterfaces(),handler);
        Animal dogProxy = (Animal)Proxy.newProxyInstance(DynamicProxy.class.getClassLoader(),dog.getClass().getInterfaces(),handler);
        dogProxy.jiao();

    }

}
interface Animal{
    void jiao();
}
class Dog implements Animal{

    @Override
    public void jiao() {
        System.out.println("wang  wang wang ...");
    }
}

class Handler  implements InvocationHandler{
    private Object realObject;
    public Handler(Object realObject){
        this.realObject = realObject;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy ...");
        return  method.invoke(realObject,args);

    }
}