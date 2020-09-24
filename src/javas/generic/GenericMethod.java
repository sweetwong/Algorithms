package javas.generic;

public class GenericMethod {

    public static <T> void staticPrint(T t) {
        System.out.println(t);
    }

    public <T> void print(T t) {
        System.out.println(t);
    }

}
