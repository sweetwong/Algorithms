package data_structure.graph.data;

import data_structure.graph.Graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphData {

    /**
     * Directed Acyclic Graph 有向无环图
     */
    public static List<List<Integer>> getDAG() {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(2).add(3);
        return adj;
    }

    /**
     * Directed Cyclic Graph 有向有环图
     */
    public static List<List<Integer>> getDCG() {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(3);
        adj.get(2).add(1);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(5);
        adj.get(5).add(7);
        adj.get(7).add(6);
        adj.get(6).add(4);

        return adj;
    }

    public static void main(String[] args) {
        List<List<Integer>> dag = getDAG();
        List<List<Integer>> dcg = getDCG();
        Graphs.print(dcg);
    }


}
