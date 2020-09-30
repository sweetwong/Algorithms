package data_structure.linked_list;

/**
 * @see sort.nlogn.MergeSort
 */
public class LinkedLists {

    /**
     * @param nums 输入任意数字
     * @return 生成对应链表
     */
    public static ListNode create(int... nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode curr = head;
        for (int i = 1; i < nums.length; i++) {
            curr.next = new ListNode(nums[i]);
            curr = curr.next;
        }
        return head;
    }

    /**
     * 打印链表成如 1 -> 3 -> 5 的格式
     *
     * @param head 输入的链表
     */
    public static void print(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        System.out.print(head.val);
        head = head.next;
        for (ListNode curr = head; curr != null; curr = curr.next) {
            System.out.print(" -> " + curr.val);
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
