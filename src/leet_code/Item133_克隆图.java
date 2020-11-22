package leet_code;

import data_structure.graph.Node;

import java.util.ArrayList;
import java.util.HashMap;

class Item133_克隆图 {

    public static Node cloneGraph(Node node) {
        return cloneGraph(node, new HashMap<>());
    }

    private static Node cloneGraph(Node node, HashMap<Node, Node> visited) {
        if (node == null) {
            return null;
        }

        // 如果该节点已经访问过了，直接从Map中取出对应的克隆节点返回
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // 克隆节点
        Node cloneNode = new Node(node.val, new ArrayList());
        // 存储在哈希表
        visited.put(node, cloneNode);

        // 遍历该节点相邻的节点
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor, visited));
        }

        return cloneNode;
    }

}
