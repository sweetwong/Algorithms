package data_structure.graph;

// A Java program to print topological
// sorting of a DAG

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// This class represents a directed graph
// using adjacency list representation
public class Graph {
    // No. of vertices
    private int v;

    // Adjacency List as ArrayList of ArrayList's
    private List<List<Integer>> adj;

    //Constructor
    public Graph(int v) {
        this.v = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i) {
            adj.add(new ArrayList<>());
        }
    }

    // Function to add an edge into the graph
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    // A recursive function used by topologicalSort
    private void topologicalSortUtil(int curr, boolean[] visited, Stack<Integer> stack) {
        // Mark the current node as visited.
        visited[curr] = true;

        // Recur for all the vertices adjacent
        // to this vertex
        for (int i : adj.get(curr)) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        // Push current vertex to stack
        // which stores result
        stack.push(curr);
    }

    // The function to do Topological Sort.
    // It uses recursive topologicalSortUtil()
    public void topologicalSort() {
        Stack<Integer> stack = new Stack<>();

        // Mark all the vertices as not visited
        boolean[] visited = new boolean[v];
        Arrays.fill(visited, false);

        // Call the recursive helper
        // function to store
        // Topological Sort starting
        // from all vertices one by one
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        // Print contents of stack
        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }

    public void print() {
        GraphUtils.printAdj(adj);
    }

    // Driver method
    public static void main(String[] args) {
        // Create a graph given in the above diagram
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        GraphUtils.printAdj(g.adj);

        g.topologicalSort();
    }
}
