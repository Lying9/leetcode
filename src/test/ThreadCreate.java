package test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by ying on 2019/4/11.
 */
public class ThreadCreate {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> oneCall = new someCallable();
        FutureTask<String> future = new FutureTask<>(oneCall);
        Thread t = new Thread(future);
        t.start();
        System.out.println(future.get());
    }

}

class  someCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        return "lalala...";
    }
}
