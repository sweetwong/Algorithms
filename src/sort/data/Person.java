package sort.data;

import java.io.UnsupportedEncodingException;
import java.util.Random;

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

  public static Person[] createPeople(int n, int maxAge) {
    Person[] persons = new Person[n];
    for (int i = 0; i < n; i++) {
      persons[i] = new Person(i, (int) (Math.random() * maxAge), createRandomJianHan(3));
    }
    return persons;
  }

  public static void printPeople(Person[] people) {
    for (Person person : people) {
      System.out.println(person.toString());
    }
  }

  public static String createRandomJianHan(int len) {
    String ret = "";
    for (int i = 0; i < len; i++) {
      String str = null;
      int hightPos, lowPos; // 定义高低位
      Random random = new Random();
      hightPos = (176 + Math.abs(random.nextInt(39))); // 获取高位值
      lowPos = (161 + Math.abs(random.nextInt(93))); // 获取低位值
      byte[] b = new byte[2];
      b[0] = (new Integer(hightPos).byteValue());
      b[1] = (new Integer(lowPos).byteValue());
      try {
        str = new String(b, "GBK"); // 转成中文
      } catch (UnsupportedEncodingException ex) {
        ex.printStackTrace();
      }
      ret += str;
    }
    return ret;
  }
}