import java.util.*;

public class Main {

    static int V;

    static boolean bfs(int[][] capacity, int[][] flow, int source, int sink, int[] parent) {

        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < V; v++) {

                if (!visited[v] && capacity[u][v] - flow[u][v] > 0) {
                    parent[v] = u;
                    visited[v] = true;
                    queue.add(v);

                    if (v == sink) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    static int fordFulkerson(int[][] capacity, int source, int sink) {

        int[][] flow = new int[V][V];
        int[] parent = new int[V];

        int maxFlow = 0;

        while (bfs(capacity, flow, source, sink, parent)) {

            int pathFlow = Integer.MAX_VALUE;

            int v = sink;

            while (v != source) {
                int u = parent[v];

                pathFlow = Math.min(
                    pathFlow,
                    capacity[u][v] - flow[u][v]
                );

                v = u;
            }

            // Update flow along the path
            v = sink;

            while (v != source) {
                int u = parent[v];

                flow[u][v] += pathFlow;
                flow[v][u] -= pathFlow;

                v = u;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        int E = sc.nextInt();

        int[][] capacity = new int[V][V];

        for (int i = 0; i < E; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();
            int c = sc.nextInt();

            capacity[u][v] += c;
        }

        int source = 0;
        int sink = V - 1;

        System.out.println(
            fordFulkerson(capacity, source, sink)
        );

        sc.close();
    }
}
