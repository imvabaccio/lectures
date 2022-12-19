import java.util.Stack;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class MatGraph {
    int n;
    int[][] graph;

    MatGraph(int size) {
        n = size;
        graph = new int[n][n];
    }

    void addEgde(int x, int y) {
        graph[x][y] = 1;
        graph[y][x] = 1;
    }

    void addEdgeDir(int x, int y) {
        graph[x][y] = 1;
    }

    void addEdge(int x, int y, int w) {
        graph[x][y] = w;
        graph[y][x] = w;
    }

    void addEdgeDir(int x, int y, int w) {
        graph[x][y] = w;
    }

    void DFS(int start) {
        boolean[] visited = new boolean[n];
        Stack<Integer> s = new Stack<Integer>();

        s.push(start);

        while (!s.isEmpty()) {
            int curr = s.pop();

            if (!visited[curr]) {
                visited[curr] = true;
                System.out.print(curr + " ");
            }

            int[] adj = graph[curr];

            for (int i = 0; i < adj.length; i++) {
                if (adj[i] == 1 && !visited[i]) {
                    s.push(curr);
                    s.push(i);
                    break;
                }
            }
        }
    }

    void DFS(int start, boolean[] visited) {
        if (!visited[start]) {
            visited[start] = true;
            System.out.print(start + " ");
        }

        int[] adj = graph[start];

        for (int i = 0; i < adj.length; i++) {
            if (adj[i] == 1 && !visited[i]) {
                DFS(i, visited);
            }
        }
    }

    void BFS(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] visited = new boolean[n];

        q.offer(start);

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (!visited[curr]) {
                visited[curr] = true;
                System.out.print(curr + " ");
            }

            int[] adj = graph[curr];

            for (int i = 0; i < adj.length; i++) {
                if (adj[i] == 1 && !visited[i]) {
                    q.offer(i);
                }
            }
        }
    }

    void djikstra(int start) {
        int[] minDist = new int[n];
        boolean[] fixed = new boolean[n];

        for (int i = 0; i < n; i++)
            minDist[i] = Integer.MAX_VALUE;

        minDist[start] = 0;

        for (int i = 0; i < n - 1; i++) {
            // find min val
            int minVal = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int j = 0; j < n; j++) {
                if (!fixed[j] && minDist[j] < minVal) {
                    minVal = minDist[j];
                    minIndex = j;
                }
            }

            fixed[minIndex] = true;

            for (int j = 0; j < n; j++) {
                if (!fixed[j] && graph[minIndex][j] > 0 && minDist[minIndex] != Integer.MAX_VALUE
                        && minDist[j] > minDist[minIndex] + graph[minIndex][j]) {
                    minDist[j] = minDist[minIndex] + graph[minIndex][j];
                }
            }
        }

        for (int x : minDist)
            System.out.print(x + " ");
    }

    void printGraph() {
        for (int[] x : graph) {
            for (int y : x)
                System.out.print(y + " ");
            System.out.println();
        }
    }
}
