package data_structure.graph.me.util;

import java.util.*;

/**
 * 这是有向图的一种实现，没有用List<List<Integer>>的形式，而是用了Map<N, List<N>>的形式，可以快速索引到Node对应的List
 *
 * 如果用List<List<Integer>>，我们可以通过Node（即是index）直接定位到对应的List
 * 但是如果用List<List<N>>，我们无法通过Node（不是index）定位到对应的List
 * 因此我们使用Map<N, Set<N>>的形式，来弥补List<List<N>>当N不为整型的情况
 * 为什么用Set，因为使用无向图的时候，会有重复添加的问题，而我们认为每个节点都是独一无二的
 */
public abstract class CommonGraph<N> implements Graph<N> {

    protected Map<N, Set<N>> adj = new HashMap<>();

    @Override
    public void putNode(N node) {
        if (!adj.containsKey(node)) {
            adj.put(node, new HashSet<>());
        }
    }

    @Override
    public Set<N> nodes() {
        return adj.keySet();
    }

    @Override
    public Set<N> adj(N node) {
        return adj.get(node);
    }

    @Override
    public int size() {
        return adj.size();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Set<Map.Entry<N, Set<N>>> entrySet = adj.entrySet();
        for (Map.Entry<N, Set<N>> entry : entrySet) {
            s.append(entry.getKey());
            s.append(": ");
            s.append(entry.getValue());
            s.append('\n');
        }
        return s.toString();
    }

}
