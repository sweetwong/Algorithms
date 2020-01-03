import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

class Solution {

  public static void main(String[] args) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(1, 2);
    map.put(3, 4);
    Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
    for (Map.Entry<Integer, Integer> entry: entries){
      System.out.println(entry.getKey() + " " + entry.getValue());
    }
  }

}