package test;

import test.test_inherit.Child;

public class Test {

    public static void main(String[] args) {
        System.out.println(Child.class.getClassLoader());
    }

}
