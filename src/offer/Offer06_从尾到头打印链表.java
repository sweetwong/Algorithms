package offer;

import util.linked_list.ListNode;

class Offer06_从尾到头打印链表 {

    public int[] reversePrint(ListNode head) {
        int count = 0;
        for (ListNode curr = head; curr != null; curr = curr.next) {
            count++;
        }
        int[] nums = new int[count];
        int i = nums.length - 1;
        for (ListNode curr = head; curr != null; curr = curr.next, i--) {
            nums[i] = curr.val;
        }
        return nums;
    }


}
