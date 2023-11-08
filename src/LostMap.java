import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class LostMap {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int villages = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[villages];
        int[][] adjMatrix = new int[villages][villages];
        PriorityQueue<vertex> pq = new PriorityQueue<>((x,y) -> x.dist - y.dist);
        visited[0] = true;
        int count = 1;

        for (int i = 0; i < villages; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            for (int j = 0; j < villages; j++) {
                adjMatrix[i][j] = Integer.parseInt(line.nextToken());
            }
        }

        for (int i = 1; i < villages; i++) {
            pq.add(new vertex(0, i, adjMatrix[0][i]));
        }

        while (count < villages) {
            vertex curr = pq.poll();
            if (!visited[curr.to]) {
                count++;
                visited[curr.to] = true;
                pw.println((curr.from + 1) + " " + (curr.to + 1));
                for (int j = 0; j < villages; j++) {
                    if (!visited[j]) {
                        pq.add(new vertex(curr.to, j, adjMatrix[curr.to][j]));
                    }
                }
            }
        }

        pw.flush();
    }
}

class vertex {
    int from, to, dist;
    public vertex(int from, int to, int dist) {
        this.from = from;
        this.to = to;
        this.dist = dist;
    }
}