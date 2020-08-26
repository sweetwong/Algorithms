package data_structure.graph.me.util;

import java.util.Set;

public interface Graph<N> {

    void putEdge(N nodeU, N nodeV);

    void putNode(N node);

    Set<N> nodes();

    int size();

    boolean detectCycle();

    Set<N> adj(N node);

}
