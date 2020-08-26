package data_structure.graph.me.test;

import data_structure.graph.me.util.DirectedGraph;

public class TopologicalSortTest {

    public static void main(String[] args) {
        DirectedGraph<String> graph = new DirectedGraph<>();
        graph.putEdge("高等数学", "线性代数");
        graph.putEdge("高等数学", "概率论");
        graph.putEdge("线性代数", "复变函数");
        System.out.println(graph.topologicalSort());;
    }

}
