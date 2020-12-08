package classical;

import data_structure.entity.Person;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 实现LRU缓存(Least Recently Used Cache)
 *
 * 方法:
 * 1. 继承LinkedHashMap, 重写removeEldestEntry
 * 2. 组合LinkedHashMap, 代理相应的方法
 * 3. TODO 利用HashMap + 双链表手动实现
 */
public class LRUCache1<K, V> extends LinkedHashMap<K, V> {

    private int capacity;

    public LRUCache1(int capacity) {
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

        LRUCache1<Integer, Person> cache = new LRUCache1<>(3);
        for (Person person : people) {
            cache.put(person.getId(), person);
            System.out.println(cache);
            System.out.println();
        }
    }

}
