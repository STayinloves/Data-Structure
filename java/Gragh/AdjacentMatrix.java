package Gragh;

/**
 * Created by STay on 17-5-11.
 */
public class AdjacentMatrix {
    private double[][] edges;
    private int maxsize;

    public AdjacentMatrix(int capacity) {
        edges = new double[capacity][capacity];
        maxsize = capacity;
        for (int i = 0; i < capacity; i++) {
            for (int j = 0; j < capacity; j++) {
                edges[i][j] = Double.MAX_VALUE;
            }
        }
    }

    public void addEdge(int from, int to, double weight) {
        edges[from][to] = edges[to][from] = weight;
    }

    public static void main(String[] args) {
        AdjacentMatrix adjacentMatrix = new AdjacentMatrix(10);
        adjacentMatrix.addEdge(1, 2, 3);
        System.out.println(adjacentMatrix.edges[1][2]);
    }
}
