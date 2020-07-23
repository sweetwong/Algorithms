package util.linked_list;

import sort.nlogn.QuickSort;
import util.array.ArrayUtils;

public class LinkedListUtils {

    public static void main(String[] args) {
        int[] nums = ArrayUtils.createRandomArray(10, 100, false);
        QuickSort.sort(nums);

        ListNode head = create(nums);
        print(head);

        ListNode rev = reverse(head);
        print(rev);
    }

    /**
     * @param nums 输入任意数字
     * @return 生成对应链表
     */
    public static ListNode create(int... nums) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int num : nums) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    /**
     * 打印链表成如 1 -> 3 -> 5 的格式
     *
     * @param node 输入的链表
     */
    public static void print(ListNode node) {
        if (node == null) {
            System.out.print("null");
        } else {
            System.out.print(node.val);
            node = node.next;
            while (node != null) {
                System.out.print(" -> " + node.val);
                node = node.next;
            }
        }
        System.out.println();
    }

    /**
     * 反转链表, 迭代法
     *
     * 利用三个变量, prev、curr、next
     * prev指向前一个数, curr指向当前的数, nextTemp指向后一个数(每次都会新生成, 用来暂存)
     *
     * 反转过程: 把nextTemp保存下来, curr接上prev
     * 向前推进: prev变成curr, curr变成next
     */
    public static ListNode reverse(ListNode root) {
        ListNode prev = null, curr = root;
        while (curr != null) {
            // 前两步是反转操作
            // 这个的作用是为了记录下一个节点, 用于后面的推进, 因为curr反转后就会丢失下一个节点
            ListNode next = curr.next;
            // 每一轮只反转一个节点
            curr.next = prev;

            // 后两步是推进操作
            // 先推进prev, 因为后面curr会改变
            prev = curr;
            // 后推进curr
            curr = next;
        }
        return prev;
    }

}
