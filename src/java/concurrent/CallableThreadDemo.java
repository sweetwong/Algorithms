package java.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableThreadDemo implements Callable<Integer> {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableThreadDemo a = new CallableThreadDemo();
        FutureTask<Integer> task = new FutureTask<>(a);
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
            if (i == 20) {
                new Thread(task, "子线程").start();
            }
        }
        System.out.println(Thread.currentThread().getName() + " " + "子线程的返回值：" + task.get());
        System.out.println("不错哟");
    }

    @Override
    public Integer call() {
        int i = 0;
        for (; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return i;
    }

}