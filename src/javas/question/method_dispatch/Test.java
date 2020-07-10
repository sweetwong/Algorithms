package javas.question.method_dispatch;

class Test {

    public static void main(String[] args) {
        Parent object = new Child();
        Child.print(object);
    }

}
