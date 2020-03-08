package java.reflect.bean;

public class Student extends Person {

  private int grade;

  public Student(String name, int age, float height) {
    super(name, age, height);
  }

  public int getGrade() {
    return grade;
  }

  public void setGrade(int grade) {
    this.grade = grade;
  }

  @Override
  public String getName() {
    return super.getName();
  }

  @Override
  public void setName(String name) {
    super.setName(name);
  }
}
