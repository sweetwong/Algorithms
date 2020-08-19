package javas.io.file;

import data_structure.other.Time;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class WriterDemo {

    public static void main(String[] args) {
        Time.watch(WriterDemo::writeText);
    }

    public static void writeText() {
        File file = new File("src/javas/io/out/big.txt");
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            if (!parentFile.mkdirs()) {
                return;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < 10; i++) {
                writer.write(UUID.randomUUID().toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
