package leet_code;

import util.linked_list.ListNode;

class Item2_两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            curr.next = new ListNode(sum);

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
            curr = curr.next;
        }

        if (carry == 1) {
            curr.next = new ListNode(1);
        }

        return dummy.next;
    }
}
