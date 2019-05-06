package test;

/**
 * Created by ying on 2019/4/26.
 */

//wait()   notify()  notifyAll()  方法调用必须在synchronized中，否则抛出java.lang.IllegalMonitorStateException异常
public class ThreadCrossPrint {
    static Object o = new Object();   //充当锁的角色
    static Boolean flag = false;     //标志哪个线程应该执行
    static int count = 0;            //输出的数

    public static void main(String[] args) {
        //thread打印奇数
        Thread thread1 = new Thread("thread1") {
            @Override
            public void run() {
                //这里是循环，因为这个线程要输出很多数
                while (count <= 100) {
                    synchronized (o) {
                        if (flag) {
                            System.out.println("thread1   " + count++);
                            flag = false;
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            o.notifyAll();
                        } else {
                            try {
                                o.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

            }
        };


        Thread thread2 = new Thread("thread2") {
            @Override
            public void run() {
                while (count <= 100) {
                    synchronized (o) {
                        if (!flag) {
                            System.out.println("thread2   " + count++);
                            flag = true;
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            o.notifyAll();
                        } else {
                            try {
                                o.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

            }
        };
        thread1.start();
        thread2.start();
    }
}



