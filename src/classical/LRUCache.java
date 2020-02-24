package classical;

import util.data.Person;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

  private int capacity;

  public LRUCache(int capacity) {
    // The load factor used when none specified in constructor.
    // static final float DEFAULT_LOAD_FACTOR = 0.75f;
    super(capacity, 0.75f, true);
    this.capacity = capacity;
  }

  @Override
  protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
    return size() > capacity;
  }

  public static void main(String[] args) {
    Person[] people = Person.createPeople(10, 20);
    Person.printPeople(people);

    LRUCache<Integer, Person> cache = new LRUCache<>(3);
    for (Person person : people) {
      cache.put(person.getId(), person);
      System.out.println(cache);
      System.out.println();
    }
  }

}
