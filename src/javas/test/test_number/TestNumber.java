package javas.test.test_number;

import data_structure.other.NumberUtils;

public class TestNumber {

    public static void main(String[] args) {
        int a = -11111;
        NumberUtils.printBinary(a);
        NumberUtils.printBinary(a >> 1);
        NumberUtils.printBinary(a >>> 1);
    }

}
