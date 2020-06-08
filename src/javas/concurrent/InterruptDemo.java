package javas.concurrent;

import java.util.concurrent.TimeUnit;

import static javas.concurrent.ThreadUtils.*;

class InterruptDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                print("被打断");
            }
            print("结束");
        });
        thread.start();

        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}
