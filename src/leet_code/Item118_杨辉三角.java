package leet_code;

import java.util.ArrayList;
import java.util.List;

public class Item118_杨辉三角 {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> currRow = new ArrayList<>();
            List<Integer> prevRow = res.get(i - 1);
            currRow.add(1);
            for (int j = 1; j < i; j++) {
                currRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            currRow.add(1);
            res.add(currRow);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

}
