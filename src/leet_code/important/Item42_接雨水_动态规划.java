package leet_code.important;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
class Item42_接雨水_动态规划 {

    /**
     * 注意：做这种题的时候，一定要区分好，数组的索引和数组的值
     *
     * todo 完成这个动态规划
     */
    public static int trap(int[] height) {
        int len = height.length;

        int sum = 0;

        for (int i = 1; i < len - 1; i++) {
            int leftMaxIndex = i;
            for (int l = i - 1; l >= 0; l--) {
                if (height[l] > height[leftMaxIndex]) {
                    leftMaxIndex = l;
                }
            }

            int rightMaxIndex = i;
            for (int r = i + 1; r < len; r++) {
                if (height[r] > height[rightMaxIndex]) {
                    rightMaxIndex = r;
                }
            }

            int minHeight = Math.min(height[leftMaxIndex], height[rightMaxIndex]);
            if (minHeight > height[i]) {
                sum += minHeight - height[i];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }


}
