package javas.concurrent;

public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setName("主线程");
        JoinDemo a = new JoinDemo();
        a.run();
    }

    void run() {
        System.out.println(Thread.currentThread().getName() + " A开始");
        Thread threadB = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " B开始");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " B结束");
        }, "B线程");
        threadB.start();
        try {
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " A结束");
    }

}
