package leet_code;

// todo 现在是错的，完成这道题
class Item60_第k个排列 {

    private int count = 0;
    private String res = null;

    public String getPermutation(int n, int k) {
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = (char) (i + '1');
        }
        backtrack(chars, k, 0);
        return res;
    }

    private void backtrack(char[] chars, int k, int start) {
        if (start >= chars.length) {
            count++;
            if (count == k) {
                res = new String(chars);
            }
            System.out.println("count: " + count + ", ");
            return;
        }

        for (int i = start; i < chars.length; i++) {
            swap(chars, start, i);
            backtrack(chars, k, start + 1);
            swap(chars, start, i);
        }
    }

    private void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Item60_第k个排列 a = new Item60_第k个排列();
        System.out.println(a.getPermutation(3, 3));
    }

}
