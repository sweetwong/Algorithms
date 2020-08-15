package javas.io.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class ReaderDemo {

    public static String readText() {
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader("src/javas/io/file/out/big.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
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

    public static void main(String[] args) {
        System.out.println(readText());
    }


}
