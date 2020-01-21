package leet_code;

class Item11 {

  public int maxArea(int[] height) {
    int max = 0, lo = 0, hi = height.length - 1;

    while (lo < hi) {
      max = Math.max(max, (hi - lo) * Math.min(height[hi], height[lo]));

      if (height[lo] < height[hi]) {
        lo++;
      } else {
        hi--;
      }
    }

    return max;
  }
}
