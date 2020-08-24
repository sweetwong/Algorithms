package javas.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class IOUtils {

    public static String toString(InputStream is) throws IOException {
        char[] buffer = new char[1024];
        StringBuilder out = new StringBuilder();
        Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
        int n;
        while ((n = reader.read(buffer, 0, buffer.length)) != -1) {
            out.append(buffer, 0, n);
        }
        return out.toString();
    }


    public static boolean deleteFile(String path) {
        File dirFile = new File(path);

        // 如果dir对应的文件不存在，则退出
        if (!dirFile.exists()) {
            return false;
        }

        if (dirFile.isFile()) {
            return dirFile.delete();
        } else {

            for (File file : dirFile.listFiles()) {
                deleteFile(file);
            }
        }

        return dirFile.delete();
    }


    public static boolean deleteFile(File dirFile) {
        // 如果dir对应的文件不存在，则退出
        if (!dirFile.exists()) {
            return false;
        }

        if (dirFile.isFile()) {
            return dirFile.delete();
        } else {
            for (File file : dirFile.listFiles()) {
                deleteFile(file);
            }
        }

        return dirFile.delete();
    }

    public static String readText(String path) {
        if (path == null || path.isEmpty()) {
            return null;
        }

        File file = new File(path);
        if (!file.exists()) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String text;
            while ((text = reader.readLine()) != null) {
                builder.append(text);
                builder.append("\n");
            }
        } catch (IOException e) {
            return null;
        }
        
        return builder.toString();
    }

    public static void writeText(String path, String s) {
        if (path == null || path.isEmpty()) {
            return;
        }

        File file = new File(path);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            if (!parentFile.mkdirs()) {
                return;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
