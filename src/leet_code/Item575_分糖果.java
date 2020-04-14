package leet_code;

import java.util.HashSet;
import java.util.Set;

class Item575_分糖果 {

    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }
        return Math.min(candies.length / 2, set.size());
    }

}
