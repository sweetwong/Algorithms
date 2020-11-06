package javas.io.file;

import javas.io.IOUtils;
import javas.utils.Utils;

public class WriteJavaDemo {

    private static final String PATH = "E:\\F\\Project\\other\\Algorithms\\src\\javas\\io\\file\\Foo.java";
    private static final String CODE =
                    "package javas.io.file;\n" +
                    "\n" +
                    "import javas.io.IOUtils;\n" +
                    "\n" +
                    "public class Foo {\n" +
                    "\n" +
                    "    public static void main(String[] args) {\n" +
                    "        IOUtils.deleteFile(\"E:\\\\F\\\\Project\\\\other\\\\Algorithms\\\\src\\\\javas\\\\io\\\\file\\\\Foo.java\");\n" +
                    "    }\n" +
                    "\n" +
                    "}\n";

    public static void main(String[] args) {
        IOUtils.writeText(PATH, CODE);
        System.out.println(CODE.length());
        Utils.printObjectSize(CODE);
    }

}
