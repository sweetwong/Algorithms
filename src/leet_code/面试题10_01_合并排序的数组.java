package leet_code;

class 面试题10_01_合并排序的数组 {

    /**
     * 一遍过好开心, o(*￣▽￣*)ブ
     */
    public void merge(int[] A, int m, int[] B, int n) {
        for (int i = m - 1, j = n - 1, k = m + n - 1; k >= 0; k--) {
            if (i < 0) {
                A[k] = B[j--];
                continue;
            }
            if (j < 0) {
                A[k] = A[i--];
                continue;
            }
            if (A[i] <= B[j]) {
                A[k] = B[j--];
            } else {
                A[k] = A[i--];
            }
        }
    }

}
