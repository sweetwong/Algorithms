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
            return node;
        }

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node cloneNode = new Node(node.val, new ArrayList());
        visited.put(node, cloneNode);

        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor, visited));
        }

        return cloneNode;
    }

}
