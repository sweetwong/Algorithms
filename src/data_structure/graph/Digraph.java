package data_structure.graph;

import java.util.ArrayList;
import java.util.List;

public class Digraph {

    private int V;

    private List<List<Integer>> adj;

    public Digraph(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    public int getV() {
        return V;
    }

    public List<List<Integer>> getAdj() {
        return adj;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int v = 0; v < V; v++) {
            s.append(String.format("%d: ", v));
            for (int w : adj.get(v)) {
                s.append(String.format("%d ", w));
            }
            s.append("\n");
        }
        return s.toString();
    }

}
