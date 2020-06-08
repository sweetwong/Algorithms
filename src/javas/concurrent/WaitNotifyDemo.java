package javas.concurrent;

import static javas.concurrent.ThreadUtils.print;

class WaitNotifyDemo {

    void run() {
        Thread t1 = new Thread(() -> {
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                print("结束");
            }
        });
        t1.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this) {
            print(t1.getState());
            notify();
            print(t1.getState());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new WaitNotifyDemo().run();
    }
}
