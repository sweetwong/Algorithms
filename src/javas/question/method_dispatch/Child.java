package javas.question.method_dispatch;

class Child extends Parent {

    @Override
    public void getName() {
        System.out.println("Child");
    }

    public static void print(Child child) {
        System.out.println("Child");
    }

    public static void print(Parent parent) {
        System.out.println("Parent");
    }
}
