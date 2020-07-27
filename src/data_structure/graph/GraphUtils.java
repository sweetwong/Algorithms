package data_structure.graph;

import java.util.List;

public class GraphUtils {

    /**
     * 打印邻接表
     *
     * @param adj 邻接表
     */
    public static void printAdj(List<List<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                if (j == 0) {
                    System.out.print(adj.get(i).get(j));
                    continue;
                }
                System.out.print(", " + adj.get(i).get(j));
            }
            System.out.println();
        }
        System.out.println();
    }
}
