package leet_code;

import util.LinkedList;
import util.LinkedList.ListNode;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *  
 *
 * Example:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 *
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

class MinStack {

  private TwoWayNode nodes;
  private int length = 0;

  private TwoWayNode minNode;

  public MinStack() {

  }

  public void push(int x) {
    if (nodes == null) nodes = new TwoWayNode(x, length, null);
    else {
      nodes.next = new TwoWayNode(x, length, nodes);
      nodes = nodes.next;
    }
    if (x <= minNode.val) {
      minNode = nodes;
    }
    length++;
  }

  public void pop() {
    if (nodes == null) return;
    else {
      nodes = nodes.prev;
      nodes.next = null;
      length--;
    }
  }

  public int top() {
    if (nodes == null) {
      throw new RuntimeException("栈为空");
    } else
      return nodes.val;
  }

  public int getMin() {
    if (nodes == null) {
      throw new RuntimeException("栈为空");
    }

    TwoWayNode temp = nodes;
    int min = temp.val;
    return min;
  }

  private static class TwoWayNode {

    int val;
    int index;
    TwoWayNode next;
    TwoWayNode prev;

    public TwoWayNode(int val, int index, TwoWayNode prev) {
      this.val = val;
      this.index = index;
      this.prev = prev;
    }
  }

}
