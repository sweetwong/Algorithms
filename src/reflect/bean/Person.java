package reflect.bean;

public class Person {

  private String name;

  private int age;

  private float height;

  public Person(String name, int age, float height) {
    this.name = name;
    this.age = age;
    this.height = height;
    System.out.println("Person的构造函数");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public float getHeight() {
    return height;
  }

  public void setHeight(float height) {
    this.height = height;
  }
}
