package sort;

import java.util.Arrays;

class MergeSort {

  public static void main(String[] args) {
    ListNode l = generateListNode(12, 24, 32, 55);
    ListNode r = generateListNode(31, 46);
    printListNode(mergeTwoSortedLists(l, r));
  }

  public static int[] mergeSort(int[] arr) {
    if (arr.length <= 1) return arr;
    int middle = arr.length / 2;
    int[] left = Arrays.copyOfRange(arr, 0, middle);
    int[] right = Arrays.copyOfRange(arr, middle, arr.length);
    return mergeTwoArray(mergeSort(left), mergeSort(right));
  }

  private static int[] mergeTwoArray(int[] left, int[] right) {
    int[] res = new int[left.length + right.length];
    int l = 0, r = 0;
    for (int i = 0; i < res.length; i++) {
      if (l >= left.length) {
        res[i] = right[r++];
      } else if (r >= right.length) {
        res[i] = left[l++];
      } else if (left[l] < right[r]) {
        res[i] = left[l++];
      } else {
        res[i] = right[r++];
      }
    }
    return res;
  }

  public static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    if (l1.val < l2.val) {
      l1.next = mergeTwoSortedLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoSortedLists(l1, l2.next);
      return l2;
    }
  }

  private static ListNode generateListNode(int... nums) {
    ListNode dummyHead = new ListNode(0);
    ListNode curr = dummyHead;
    for (int num : nums) {
      curr.next = new ListNode(num);
      curr = curr.next;
    }
    return dummyHead.next;
  }

  private static void printListNode(ListNode list) {
    System.out.print("[" + list.val);
    while (list.next != null) {
      list = list.next;
      System.out.print(", " + list.val);
    }
    System.out.print("]");
  }

  private static class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }
  }
}
