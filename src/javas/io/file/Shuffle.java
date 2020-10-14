package javas.io.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Shuffle {

    public static void main(String[] args) throws Exception {
        File in = new File("C:\\Users\\wangsw\\Desktop\\其他\\Android-Interview-QA\\README-alphabetical-order.md");
        File out = new File("C:\\Users\\wangsw\\Desktop\\其他\\Android-Interview-QA\\README.md");

        BufferedReader reader = new BufferedReader(new FileReader(in));
        PrintWriter writer = new PrintWriter(out);
        writer.write("");

        List<String> list = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("##")) {
                Collections.shuffle(list);
                for (String l : list) {
                    writer.append(l)
                            .append(System.lineSeparator())
                            .append(System.lineSeparator());
                }
                if (!line.equals("## ")) {
                    writer.append(line)
                            .append(System.lineSeparator())
                            .append(System.lineSeparator());
                }
                list.clear();
            } else {
                if (!line.isEmpty()) {
                    list.add(line);
                }
            }
        }
        writer.flush();
    }

}