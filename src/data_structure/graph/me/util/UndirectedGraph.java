package data_structure.graph.me.util;

import java.util.HashSet;
import java.util.Set;

public class UndirectedGraph<N> extends CommonGraph<N> {

    public void putEdge(N nodeU, N nodeV) {
        Set<N> setU = adj.get(nodeU);
        if (setU == null) {
            setU = new HashSet<>();
            adj.put(nodeU, setU);
        }
        setU.add(nodeV);

        Set<N> setV = adj.get(nodeU);
        if (setV == null) {
            setV = new HashSet<>();
            adj.put(nodeU, setV);
        }
        setV.add(nodeV);
    }

    @Override
    public boolean detectCycle() {
        return false;
    }
}
