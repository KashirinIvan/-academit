import academit.kashirin.graph.Graph;

public class Main {
    public static void main(String[] args) {
        int[][] array = {
                {0, 1, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 1, 0}
        };

        Graph graph = new Graph(array);
    } 
}
