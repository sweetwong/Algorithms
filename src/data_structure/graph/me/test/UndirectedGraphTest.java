package data_structure.graph.me.test;

import data_structure.graph.me.util.Graph;
import data_structure.graph.me.util.UndirectedGraph;
import javas.utils.Utils;

public class UndirectedGraphTest {

    public static void main(String[] args) {
        Graph<String> graph = new UndirectedGraph<>();
        graph.putEdge("ShenZhen", "BeiJing");
        graph.putEdge("ShenZhen", "ShangHai");
        graph.putEdge("BeiJing", "ShangHai");
        graph.putNode("GuangZhou");
        System.out.println(graph);

        Utils.printObjectSize(graph);
    }

}
