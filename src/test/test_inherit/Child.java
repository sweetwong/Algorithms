package test.test_inherit;

public class Child extends Parent{

    {
        System.out.println("Child non-static block");
    }

    static {
        System.out.println("Child static block");
    }

    public Child() {
        System.out.println("Child constructor");
    }

    @Override
    public void memberMethod() {
        System.out.println("Child non-static method");
    }

    public static void staticMethod() {
        System.out.println("Child static method");
    }
}
