package javas.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                ThreadUtils.sleep(1000);
                ThreadUtils.print("future task");
                return "Sweet";
            }
        });
        new Thread(futureTask).start();
        String s = null;
        try {
            s = futureTask.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ThreadUtils.print(s);
    }

}
