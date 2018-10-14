package test;


/**
 * Created by ying on 2018/8/22.
 */
public class Derivative {
    public static void main(String[] args) {
        DerivedFunction df = new DerivedFunction(new Function() {
            @Override
            public double f(double x) {
//                return 3*x*x*x+2*x*x+x+1;
                return Math.log(x);
            }
        });
//        求 3*x*x*x+2*x*x+x+1在2 的一阶导数
        System.out.println(df.f(2));
//        求二阶导数
        DerivedFunction df2 = new DerivedFunction(df);
        System.out.println(df2.f(2));
//        System.out.println(new DerivedFunction(new DerivedFunction(x -> 3 * x * x * x + 2 * x * x + x + 1)).apply(2.0));
    }
}

//第一种方法  缺点 ： 每改变一个函数就要改变f方法  违反开放封闭原则 解决方法：把Function抽象为接口
//                        不能求二阶导数
/*class Function{
    public double f(double x){
        return 3*x*x*x+2*x*x+x+1;
    }
}
class DerivedFunction{
    private Function function;
    public static  final double dx = 0.00000001;
    public DerivedFunction(Function function){
        this.function = function;
    }
    public double getDerivate(double x){
        return (function.f(x+dx)-function.f(x))/dx;
    }
}
*/
interface Function {
    double f(double x);
}

class DerivedFunction implements Function {
    private Function function;
    //    当 dx= 0.000001时，结果正确。但是当dx赋值为0.00000001时，二阶导数不正确。。。不知道为什么？？？？
    public static final double dx = 0.000001;

    public DerivedFunction(Function function) {
        this.function = function;
    }

    @Override
    public double f(double x) {
        return (function.f(x + dx) - function.f(x)) / dx;
    }
}

/* class DerivedFunction implements Function<Double, Double> {
    private static final double DELTA_X = 0.000001;
    private Function<Double, Double> function;

    public DerivedFunction(Function<Double, Double> function) {
        this.function = function;
    }

    @Override
    public Double apply(Double x) {
        return (function.apply(x + DELTA_X) - function.apply(x)) / DELTA_X;
    }
}*/
