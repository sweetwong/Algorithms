package leet_code;

class Item26_删除排序数组中的重复项 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;

        int i = 0;
        for (int j = 1; j < len; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }

        return i + 1;
    }


}
