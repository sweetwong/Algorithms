package javas.io.file;

import javas.concurrent.ThreadUtils;

import java.io.*;
import java.util.UUID;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class QueueDemo {

    private static ReentrantLock sLock = new ReentrantLock();
    private static Condition sCondition = sLock.newCondition();
    private static int sCount = 0;


    public static void main(String[] args) {
        File file = new File("src/javas/io/out/big.txt");
        if (file.exists()) {
            file.delete();
        }

        Thread writeThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                writeText();
                ThreadUtils.sleep(3000);
                sLock.lock();
                try {
                    System.out.println("通知开始");
                    sCondition.signal();
                    System.out.println("通知结束");
                } finally {
                    sLock.unlock();
                }
            }
        });

        Thread readThread = new Thread(() -> {
            readText();
        });

        readThread.start();
        ThreadUtils.sleep(1000);
        writeThread.start();
    }

    public static void readText() {
        BufferedReader reader = null;
        sLock.lock();
        try {
            for (; ; ) {
                try {
                    reader = new BufferedReader(new FileReader("src/javas/io/out/big.txt"));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                if (reader == null) {
                    System.out.println("reader == null，等待开始");
                    sCondition.await();
                    System.out.println("reader == null，等待结束");
                } else {
                    break;
                }
            }
            String line;
            for (; ; ) {
                while ((line = reader.readLine()) == null) {
                    System.out.println("等待开始");
                    sCondition.await();
                    System.out.println("等待结束");
                }
                System.out.println(line + " " + ++sCount);

                if (sCount == 10) {
                    break;
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            sLock.unlock();
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeText() {
        File file = new File("src/javas/io/out/big.txt");
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            if (!parentFile.mkdirs()) {
                return;
            }
        }
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(UUID.randomUUID().toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
