package leet_code;

import data_structure.linked_list.ListNode;

class Item237_删除链表中的节点 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
