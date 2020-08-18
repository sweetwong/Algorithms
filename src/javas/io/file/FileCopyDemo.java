package javas.io.file;

import data_structure.other.Time;
import javas.utils.Utils;

import java.io.*;

public class FileCopyDemo {

    public static void main(String[] args) {
        Time.watch(FileCopyDemo::start);
    }

    public static void start() {
        File outFile = new File("src/javas/io/out/copy.mp4");
        File parentFile = outFile.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream("src/javas/io/case/video.mp4");
            os = new FileOutputStream(outFile);
            byte[] buffer = new byte[8192];
            int n;
            while ((n = is.read(buffer)) != -1) {
                os.write(buffer, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("异常A");
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("异常B");
            }
        }
    }
}
