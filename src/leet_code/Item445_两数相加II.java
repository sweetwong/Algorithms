package leet_code;

import data_structure.linked_list.LinkedLists;
import data_structure.linked_list.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

class Item445_两数相加II {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 这种需要反转的, 要立刻想到栈
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode head = null;
        int carry = 0;
        int sum;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry == 1) {
            int val1 = stack1.isEmpty() ? 0 : stack1.pop();
            int val2 = stack2.isEmpty() ? 0 : stack2.pop();
            sum = val1 + val2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            // 这是反向链接链表, 学会这一招
            ListNode node = new ListNode(sum);
            node.next = head;
            head = node;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = LinkedLists.create(7, 2, 4, 3);
        ListNode l2 = LinkedLists.create(5, 6, 4);
        LinkedLists.print(addTwoNumbers(l1, l2));
    }

}
