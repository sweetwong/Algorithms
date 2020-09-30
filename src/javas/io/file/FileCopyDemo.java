package javas.io.file;

import data_structure.other.Time;

import java.io.*;

public class FileCopyDemo {

    public static void main(String[] args) {
        Time.watch(FileCopyDemo::copyFile);
    }

    public static void copyFile() {
        File outFile = new File("src/javas/case/out/copy.mp4");
        File outParentFile = outFile.getParentFile();
        if (!outParentFile.exists()) {
            outParentFile.mkdirs();
        }

        try (InputStream is = new FileInputStream("src/javas/case/video.mp4");
             OutputStream os = new FileOutputStream(outFile)) {
            byte[] buffer = new byte[8192];
            int n;
            while ((n = is.read(buffer)) != -1) {
                os.write(buffer, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
