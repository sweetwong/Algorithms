package leet_code;

import java.util.PriorityQueue;

class Item179_最大数 {

  public static void main(String[] args) {
    Item179_最大数 a = new Item179_最大数();
    System.out.println(a.largestNumber(new int[]{1, 1, 1}));
  }

    public String largestNumber(int[] nums) {
      PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> (b + a).compareTo(a + b));

      for (int num : nums) {
        pq.offer(String.valueOf(num));
      }

      StringBuilder sb = new StringBuilder();
      while (!pq.isEmpty()) {
        sb.append(pq.poll());
      }

      String s = sb.toString();

      if (s.charAt(0) == '0') {
        return "0";
      }

      return s;
    }

}
