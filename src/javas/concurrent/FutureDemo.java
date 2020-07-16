package javas.concurrent;

import java.util.concurrent.*;

class FutureDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception{
                return null;
            }
        });
        Future<?> future = executor.submit(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("future执行完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("future被打断");
            }
        });
        System.out.println("future.get() = " + future.get());
        Thread.sleep(1000);
        System.out.println("代码执行完成");
    }
}
