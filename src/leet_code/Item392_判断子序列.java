package leet_code;

import java.util.HashMap;
import java.util.Map;

class Item392_判断子序列 {

    public boolean isSubsequence(String s, String t) {
        int len = s.length();
        int index = -1;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            index = t.indexOf(c, index + 1);
            if (index == -1) return false;
        }
        return true;
    }

}
