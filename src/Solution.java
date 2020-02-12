import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;

class Solution {

  public static void main(String[] args) {
    Graph graph = new Graph(new In(args[0]));
    System.out.println(graph.toString());
  }

}