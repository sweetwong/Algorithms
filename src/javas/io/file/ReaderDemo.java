package javas.io.file;

import javas.io.IOUtils;

class ReaderDemo {

    public static void main(String[] args) {
        String text = IOUtils.readText("E:\\F\\Project\\other\\Algorithms\\src\\javas\\io\\file\\QueueDemo.java");
        System.out.println(text);
    }

}
