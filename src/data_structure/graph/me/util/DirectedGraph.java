package data_structure.graph.me.util;

import java.util.*;

public class DirectedGraph<N> extends CommonGraph<N> {

    public void putEdge(N nodeU, N nodeV) {
        Set<N> setU = adj.get(nodeU);
        if (setU == null) {
            setU = new HashSet<>();
            adj.put(nodeU, setU);
        }
        setU.add(nodeV);

        if (!adj.containsKey(nodeV)) {
            adj.put(nodeV, new HashSet<>());
        }
    }

    public List<N> topologicalSort() {
        return TopologicalSort.sort(this);
    }

    @Override
    public boolean detectCycle() {
        return false;
    }
}
