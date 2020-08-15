package javas.io.file;

import javas.utils.IOUtils;

public class DeleteOut {

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        IOUtils.deleteFile("src/javas/io/file/out");
    }


}
