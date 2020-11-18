package leet_code;

import java.util.ArrayList;
import java.util.List;

public class Item763_划分字母区间_官方答案 {

    public List<Integer> partitionLabels(String s) {
        // 记录下每个字母最后一次出现的位置，非常巧妙
        // 此处的用法类似 SparseArray，用字母的值当作 key
        int[] last = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }


}
