package LeetCode;

class TrappingRainWater {

  public int trap(int[] height) {
    if (height == null || height.length < 3) return 0;

    int i = 0, maxL = 0, maxLIndex = 0, maxR = 0, maxRIndex = 0, bottom = 0;
    while (i < height.length - 1) {
      // 向上
      if (height[i] < height[i + 1]) {
        maxR = Math.max(maxR, height[i + 1]);
        maxRIndex = i + 1;
        bottom = Math.min(bottom, height[i]);
      }
      // 持平
      else if (height[i] == height[i + 1]) {

      }
      // 向下
      else {
        maxL = Math.max(maxL, height[i]);
        maxLIndex = i;
        bottom = Math.min(bottom, height[i + 1]);
      }
      i++;
    }
    return 0;
  }


}