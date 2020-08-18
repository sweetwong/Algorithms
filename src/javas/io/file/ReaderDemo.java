package javas.io.file;

import data_structure.other.Time;
import javas.utils.Utils;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.instrument.Instrumentation;

class ReaderDemo {

    public static void main(String[] args) {
        String s = readText();
        System.out.println(s.length());
    }

    public static String readText() {
        return readText("src/javas/io/out/big.txt");
    }

    public static String readText(String path) {
        if (path == null || path.isEmpty()) {
            return null;
        }

        File file = new File(path);
        if (!file.exists()) {
            return null;
        }

        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            String text;
            while ((text = reader.readLine()) != null) {
                builder.append(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return builder.toString();
    }


}
