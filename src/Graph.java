import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    public int vertices;
    public ArrayList<Integer>[] adjList;

    Graph(int v) {
        this.vertices = v;
        adjList = new ArrayList[v];

        for (int i = 0; i < v; i++)
            adjList[i] = new ArrayList<Integer>();
    }

    void addEdge(int v, int w) {
        adjList[v].add(w);
        adjList[w].add(v);
    }

    void BFS(int x) {
        boolean[] visited = new boolean[vertices];

        Queue<Integer> queue = new LinkedList();

        queue.offer(x);
        visited[x] = true;

        while (!queue.isEmpty()) {
            x = queue.poll();
            System.out.println(x);

            for (int i = 0; i < adjList[x].size(); i++) {
                int n = adjList[x].get(i);
                if (!visited[n]) {
                    visited[n] = true;
                    queue.offer(n);
                }
            }
        }
    }

    void DFSRecursive(int x, boolean[] visited) {
        visited[x] = true;
        System.out.println(x);

        for (int i = 0; i < adjList[x].size(); i++) {
            int n = adjList[x].get(i);
            if (!visited[n]) {
                DFSRecursive(n, visited);
            }
        }
    }

    void DFS(int x) {
        boolean[] visited = new boolean[vertices];

        Stack<Integer> stack = new Stack<Integer>();

        stack.push(x);

        while (!stack.isEmpty()) {
            x = stack.pop();

            if (!visited[x]) {
                visited[x] = true;
                System.out.println(x);
            }

            for (int i = 0; i < adjList[x].size(); i++) {
                int n = adjList[x].get(i);
                if (!visited[n]) {
                    stack.push(n);
                }
            }
        }
    }
}