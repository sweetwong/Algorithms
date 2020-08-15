package javas.io.file;

import data_structure.other.Time;
import javas.utils.IOUtils;

import java.io.*;

public class FileCopyDemo {

    public static void main(String[] args) {
        Time.watch(FileCopyDemo::start);
    }

    public static void start() {
        File outFile = new File("src/javas/io/file/out/copy.mp4");
        File parentFile = outFile.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream("src/javas/io/file/case/video.mp4");
            os = new FileOutputStream(outFile);
            byte[] buffer = new byte[1024 * 8];
            int n;
            while ((n = is.read(buffer)) != -1) {
                os.write(buffer, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("异常A");
        } finally {
            IOUtils.close(is);
            IOUtils.close(os);
        }
    }
}
