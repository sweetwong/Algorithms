import sort.MergeSort;
import sort.Person;
import sort.QuickSort;
import util.Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

  public static void main(String[] args) {
    Person[] people = Person.createPersons(5, 50);
    Person.printPeople(people);
    System.out.println();

    PriorityQueue<Person> pq = new PriorityQueue<>();
    for(Person person: people) {
      pq.offer(person);
    }
    System.out.println();
    System.out.println(pq.toString());

  }

}