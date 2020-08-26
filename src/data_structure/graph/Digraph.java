package data_structure.graph;

import java.util.ArrayList;
import java.util.List;

public class Digraph {

    private List<List<Integer>> adj;

    private int size;

    public Digraph(int size) {
        this.size = size;
        adj = new ArrayList<>(size);
        for (int i = 0; i < size; ++i) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    public int size() {
        return size;
    }

    public List<List<Integer>> getAdj() {
        return adj;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int v = 0; v < size; v++) {
            s.append(String.format("%d: ", v));
            for (int w : adj.get(v)) {
                s.append(String.format("%d ", w));
            }
            s.append("\n");
        }
        return s.toString();
    }

}
