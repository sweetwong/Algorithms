import util.array.ArrayUtils;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        int[] nums = {2, 53, 12, 8, 79};

        ArrayUtils.printArray(nums);
        ArrayUtils.printArray(Arrays.copyOfRange(nums, nums.length - 1, nums.length));
    }

}