package util.data;

/**
 * 这个用来示例对象的比较
 */
public class Person implements Comparable<Person> {

  private int id;
  private int age;
  private String name;

  public Person(int id, int age, String name) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int compareTo(Person y) {
    return Integer.compare(age, y.age);
  }

  @Override
  public String toString() {
    return "id: " + id + ", age: " + age + ", name: " + name;
  }

  @Override
  protected Person clone() {
    Person person = null;
    try {
      person = (Person) super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return person;
  }

  public static Person[] createPeople(int n, int maxAge) {
    Person[] people = new Person[n];
    for (int i = 0; i < n; i++) {
      people[i] = new Person(i, (int) (Math.random() * maxAge), NameGenerator.getChineseName());
    }
    return people;
  }

  public static void printPeople(Person[] people) {
    for (Person person : people) {
      System.out.println(person);
    }
    System.out.println();
  }

}