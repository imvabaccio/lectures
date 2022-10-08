import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;
import java.util.Queue;

public class Graph {
    HashMap<Character, ArrayList<Character>> g;

    public Graph() {
        g = new HashMap<>();
    }

    public void addEgde(char x, char y) {
        ArrayList arr = g.getOrDefault(x, new ArrayList<>());
        arr.add(y);
        g.put(x, arr);

        arr = g.getOrDefault(y, new ArrayList<>());
        arr.add(x);
        g.put(y, arr);
    }

    public void DFS(char x) {
        HashMap<Character, Boolean> visited = new HashMap<>();

        for (Character key : g.keySet()) {
            visited.put(key, false);
        }

        Stack<Character> stack = new Stack<>();

        stack.push(x);
        visited.put(x, true);

        while (!stack.isEmpty()) { // while the stack is not empty
            char curr = stack.pop();

            System.out.print(curr + " ");
            // visited.put(curr, true);

            for (int j = 0; j < g.get(curr).size(); j++) {
                char tmp = g.get(curr).get(j);
                if (!visited.get(tmp)) {
                    stack.push(tmp);
                    visited.put(tmp, true);
                }
            }
        }
    }

    public void BFS(char x) {
        HashMap<Character, Boolean> visited = new HashMap<>();

        for (Character key : g.keySet()) {
            visited.put(key, false);
        }

        Queue<Character> q = new LinkedList();

        q.offer(x);
        visited.put(x, true);

        while (!q.isEmpty()) {
            char curr = q.poll();

            System.out.print(curr + " ");
            // visited.put(curr, true);

            for (int j = 0; j < g.get(curr).size(); j++) {
                char tmp = g.get(curr).get(j);
                if (!visited.get(tmp)) {
                    q.offer(tmp);
                    visited.put(tmp, true);
                }
            }
        }
    }

    public void DFS(char x, HashMap<Character, Boolean> visited) {
        if (visited == null) {
            visited = new HashMap<>();

            for (Character key : g.keySet()) {
                visited.put(key, false);
            }
        }

        System.out.print(x + " ");
        visited.put(x, true);

        for (int j = 0; j < g.get(x).size(); j++) {
            char tmp = g.get(x).get(j);
            if (!visited.get(tmp)) {
                DFS(tmp, visited); // stack.push(tmp);
            }
        }
    }

    public void printGraph() {
        for (Character key : g.keySet()) {
            System.out.print(key + ": ");
            for (int j = 0; j < g.get(key).size(); j++) {
                System.out.print(g.get(key).get(j) + " ");
            }
            System.out.println();
        }
    }
}
