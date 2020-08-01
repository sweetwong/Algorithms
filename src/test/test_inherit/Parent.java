package test.test_inherit;

public class Parent {

    {
        System.out.println("Parent non-static block");
    }

    static {
        System.out.println("Parent static block");
    }

    public Parent() {
        System.out.println("Parent constructor");
    }

    public void memberMethod() {
        System.out.println("Parent non-static method");
    }

    public static void go() {
        System.out.println("Parent static method");
    }

}
