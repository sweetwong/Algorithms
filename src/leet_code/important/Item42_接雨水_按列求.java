package leet_code.important;

class Item42_接雨水_按列求 {

    /**
     * 注意：做这种题的时候，一定要区分好，数组的索引和数组的值
     */
    public static int trap(int[] height) {
        int len = height.length;

        int sum = 0;

        for (int i = 1; i < len - 1; i++) {
            int maxLeft = 0;
            for (int l = i - 1; l >= 0; l--) {
                if (height[l] > maxLeft) {
                    maxLeft = height[l];
                }
            }

            int maxRight = 0;
            for (int r = i + 1; r < len; r++) {
                if (height[r] > maxRight) {
                    maxRight = height[r];
                }
            }

            int minHeight = Math.min(maxLeft, maxRight);

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
