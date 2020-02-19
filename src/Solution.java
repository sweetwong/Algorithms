import util.TimeWatcher;
import util.array.ArrayUtils;

class Solution {

  public static void main(String[] args) {
    int[] nums = ArrayUtils.createRandomArray(100000000, 10000000, false);

    for (int i = 0; i < 5; i++) {
      TimeWatcher.watchNS(() -> {
        int len = nums.length;
        for (int num : nums) {

        }
      });
    }

    System.out.println();

    for (int i = 0; i < 5; i++) {
      TimeWatcher.watchNS(() -> {
        int len = nums.length;
        for (int j = 0; j < len; j++) {

        }
      });
    }

    System.out.println();

    for (int i = 0; i < 5; i++) {
      TimeWatcher.watchNS(() -> {
        for (int j = 0; j < nums.length; j++) {

        }
      });
    }

  }

}