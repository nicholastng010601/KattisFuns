import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Dominos {

    public static void dfs(int domino, boolean[] visited, List<Integer>[] adjList, Stack<Integer> orderOfDominos) {
        visited[domino] = true;
        int pointer = 0;
        while (pointer < adjList[domino].size()) {
            int nextDomino = adjList[domino].get(pointer);
            if (!visited[nextDomino]) {
                dfs(nextDomino, visited, adjList, orderOfDominos);
            }
            pointer++;
        }
        if (orderOfDominos != null) {
            orderOfDominos.add(domino);
        }
    }

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line;
        int cases = Integer.parseInt(br.readLine());
        for (int i = 0; i < cases; i++) {
            line = br.readLine().split(" ");
            int tiles = Integer.parseInt(line[0]);
            int numberOfLinesToFollow = Integer.parseInt(line[1]);

            ArrayList<Integer>[] adjList = new ArrayList[tiles + 1];
            Stack<Integer> orderOfTraversal = new Stack<>();
            boolean[] visited = new boolean[tiles + 1];

            for (int j = 1; j < tiles + 1; j++) {
                adjList[j] = new ArrayList<>();
            }

            for (int j = 0; j < numberOfLinesToFollow; j++) {
                line = br.readLine().split(" ");
                int first = Integer.parseInt(line[0]);
                int sec = Integer.parseInt(line[1]);
                adjList[first].add(sec);
            }

            for (int k = 1; k < tiles + 1; k++) {
                if (!visited[k]) {
                    dfs(k, visited, adjList, orderOfTraversal);
                }
            }
            visited = new boolean[tiles + 1];
            int ans = 0;
            while (!orderOfTraversal.isEmpty()) {
                int currentDomino = orderOfTraversal.pop();
                if (!visited[currentDomino]) {
                    ans++;
                    dfs(currentDomino, visited, adjList, null);
                }
            }
            pw.println(ans);
        }
        pw.flush();
    }
}
