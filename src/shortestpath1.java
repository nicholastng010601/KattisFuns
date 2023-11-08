import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class shortestpath1 {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] input = br.readLine().split(" ");
            int nodes = Integer.parseInt(input[0]);
            int edges = Integer.parseInt(input[1]);
            int queries = Integer.parseInt(input[2]);
            int start = Integer.parseInt(input[3]);
            if (nodes ==  edges  && edges == queries  && queries == start && nodes == 0) {
                break;
            }
            ArrayList<intPair>[] adjList = new ArrayList[nodes];
            for (int i = 0; i < nodes; i++) {
                adjList[i] = new ArrayList<>();
            }
            int[] shortestDistance = new int[nodes];

            Arrays.fill(shortestDistance, -1);
            shortestDistance[start] = 0;

            // store the edges in the adjlist
            for (int i = 0; i < edges; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                adjList[from].add(new intPair(weight, to));
            }

            PriorityQueue<intPair> pq = new PriorityQueue<>((x,y) -> x.dist - y.dist);

            for (intPair x : adjList[start]) {
                pq.add(x);
            }

            while (!pq.isEmpty()) {
                intPair curr = pq.poll();
                if (shortestDistance[curr.node] == -1) {
                    shortestDistance[curr.node] = curr.dist;
                } else {
                    continue;
                }
                for (intPair x : adjList[curr.node]) {
                    if (shortestDistance[x.node] == -1){
                        x.dist += curr.dist;
                        pq.add(x);
                    }
                }
            }
            for (int i = 0; i < queries; i++) {
                int query = Integer.parseInt(br.readLine());
                if (shortestDistance[query] == -1) {
                    pw.println("Impossible");
                } else {
                    pw.println(shortestDistance[query]);
                }
            }
            pw.println();
        }
        pw.flush();
    }
}

class intPair {
    int dist;
    int node;
    public intPair(int dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}
