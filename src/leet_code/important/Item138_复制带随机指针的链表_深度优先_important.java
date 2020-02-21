package leet_code.important;

import java.util.HashMap;
import java.util.Map;

class Item138_复制带随机指针的链表_深度优先_important {

  // HashMap将旧节点作为键，将新节点作为其值
  HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();

  public Node copyRandomList(Node head) {

    if (head == null) return null;

    // 如果已经克隆了
    if (visitedHash.containsKey(head)) return visitedHash.get(head);

    Node copy = new Node(head.val);

    visitedHash.put(head, copy);

    copy.next = copyRandomList(head.next);
    copy.random = copyRandomList(head.random);

    return copy;
  }


  private static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }
}
