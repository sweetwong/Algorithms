package javas.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class IOUtils {

    public static String toString(InputStream is) throws IOException {
        char[] buffer = new char[1024];
        StringBuilder out = new StringBuilder();
        Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
        for (; ; ) {
            int n = reader.read(buffer, 0, buffer.length);
            if (n == -1)
                break;
            out.append(buffer, 0, n);
        }
        return out.toString();
    }

}
