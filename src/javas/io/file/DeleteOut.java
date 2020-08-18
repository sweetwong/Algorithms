package javas.io.file;

import javas.io.IOUtils;

public class DeleteOut {

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        IOUtils.deleteFile("src/javas/io/out");
    }


}
