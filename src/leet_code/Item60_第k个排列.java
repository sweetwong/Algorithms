package leet_code;

import java.util.ArrayList;
import java.util.List;

class Item60_第k个排列 {

    private int count = 0;

    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        return backtrack(nums, k, n, new ArrayList<>(), new boolean[n], 0);
    }

    private String backtrack(int[] nums, int k, int len, List<Integer> path, boolean[] used, int depth) {
        if (depth == len) {
            if (++count == k) {
                StringBuilder builder = new StringBuilder(len);
                for (int num: path) {
                    builder.append(num);
                }
                return builder.toString();
            }
            return null;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                String res = backtrack(nums, k, len, path, used, depth + 1);
                if (res != null) {
                    return res;
                }

                used[i] = false;
                path.remove(path.size() - 1);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Item60_第k个排列 a = new Item60_第k个排列();
        System.out.println(a.getPermutation(3, 5));
    }

}
