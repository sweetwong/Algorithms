package javas.test.test_number;

import data_structure.other.Numbers;

public class TestNumber {

    public static void main(String[] args) {
        int a = -11111;
        Numbers.printBinary(a);
        Numbers.printBinary(a >> 1);
        Numbers.printBinary(a >>> 1);
    }

}
