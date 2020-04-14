package leet_code;

class Item155_最小栈 {

    public static class MinStack {

        private Node tail;

        public MinStack() {

        }

        public void push(int x) {
            if (tail == null) tail = new Node(x, null);
            else {
                tail.next = new Node(x, tail);
                tail = tail.next;
            }
        }

        public void pop() {
            if (tail == null) return;
            else {
                tail = tail.prev;
            }
        }

        public int top() {
            if (tail == null) {
                throw new RuntimeException("栈为空");
            } else
                return tail.val;
        }

        public int getMin() {
            if (tail == null) {
                throw new RuntimeException("栈为空");
            }

            Node temp = tail;
            int min = temp.val;
            while (temp != null) {
                min = Math.min(temp.val, min);
                temp = temp.prev;
            }
            return min;
        }

        private static class Node {

            int val;
            Node next;
            Node prev;

            public Node(int val, Node prev) {
                this.val = val;
                this.prev = prev;
            }
        }

    }
}
