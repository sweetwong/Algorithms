package javas.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class BufferReaderDemo {

    public static String readText() {
        String text;
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader("src/javas/io/demo.text"));
            while (!isEmpty(text = reader.readLine())) {
                builder.append(text);
            }
            if (isEmpty(builder.toString())) {
                System.out.println("demo.txt is not exist");
            } else {
                System.out.println(builder.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
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

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static void main(String[] args) {
        readText();
    }

}
