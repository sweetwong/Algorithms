package leet_code;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.List;

class Item119_杨辉三角II {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex + 1);
        row.add(1);
        if (rowIndex == 0) return row;
        row.add(1);
        if (rowIndex == 1) return row;

        for (int i = 2; i <= rowIndex; i++) {
            int prev = 1;
            for (int j = 1; j < i - 1; j++) {
                int temp = row.get(j);
                row.set(j, prev + row.get(j));
                prev = temp;
            }
            row.add(i - 1, prev + row.get(i - 1));
        }

        return row;
    }

}
