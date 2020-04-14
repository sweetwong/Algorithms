package leet_code;

class Item11_盛最多水的容器 {

    // todo 所以为什么这样就能得到最大而不错过最小呢?
    public int maxArea(int[] height) {
        int maxArea = 0, lo = 0, hi = height.length - 1;

        while (lo < hi) {
            int currArea = (hi - lo) * Math.min(height[hi], height[lo]);
            maxArea = Math.max(maxArea, currArea);

            if (height[lo] < height[hi]) {
                lo++;
            } else {
                hi--;
            }
        }

        return maxArea;
    }
}
