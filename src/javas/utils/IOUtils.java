package javas.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class IOUtils {

    public static String toString(final InputStream is, final int bufferSize) throws IOException {
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        try (Reader in = new InputStreamReader(is, StandardCharsets.UTF_8)) {
            for (;;) {
                int rsz = in.read(buffer, 0, buffer.length);
                if (rsz < 0)
                    break;
                out.append(buffer, 0, rsz);
            }
        }
        return out.toString();
    }
}
