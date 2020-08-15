package javas.io.file;

import java.io.*;

public class VideoCopyDemo {

    public static void main(String[] args) {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream("src/javas/io/file/video.mp4");
            File outFile = new File("src/javas/io/file/out/copy.mp4");
            File parentFile = outFile.getParentFile();
            if (!parentFile.exists()) {
                if (!parentFile.mkdirs()) {
                    return;
                }
            }
            os = new FileOutputStream(outFile);
            byte[] buffer = new byte[1024];
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
