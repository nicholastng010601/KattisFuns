import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class shortestpath2 {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodes = Integer.parseInt(st.nextToken());
            int edges = Integer.parseInt(st.nextToken());
            int queries = Integer.parseInt(st.nextToken());
            int startnode = Integer.parseInt(st.nextToken());

            if (nodes == edges && edges == queries && queries == startnode && startnode == 0) {
                break;
            }

            ArrayList<timeTableSlot>[] adjList = new ArrayList[nodes];
            for (int i = 0; i < nodes; i++) {
                adjList[i] = new ArrayList<>();
            }

            for (int i = 0; i < edges; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int startingTime = Integer.parseInt(st.nextToken());
                int timeInterval = Integer.parseInt(st.nextToken());
                int travelTime = Integer.parseInt(st.nextToken());
                adjList[from].add(new timeTableSlot(to, startingTime, timeInterval, travelTime));
            }

            PriorityQueue<intPair2> pq = new PriorityQueue<>((x,y) -> Long.compare(x.time, y.time));
            pq.add(new intPair2(0, startnode));
            long[] visited = new long[nodes];
            Arrays.fill(visited, -1);
            long nextTime;

            while(!pq.isEmpty()) {
                intPair2 curr = pq.poll();
                if (visited[curr.node] == -1) {
                    visited[curr.node] = curr.time;
                }

                for (timeTableSlot x : adjList[curr.node]) {
                    if (visited[x.to] == -1) {
                        long currentTime = curr.time;
                        if (x.timeInterval != 0) {
                            if (currentTime <= x.startTime) {
                                nextTime = x.startTime + x.travelTime;
                            } else {
                                long temp = ((currentTime - x.startTime) % x.timeInterval);
                                long temp2 = ((currentTime - x.startTime) / x.timeInterval);
                                if (temp == 0) {
                                    nextTime = (temp2 * x.timeInterval) + x.travelTime + x.startTime;
                                } else {
                                    nextTime = ((temp2 + 1) * x.timeInterval) + x.travelTime + x.startTime;
                                }
                            }
                        } else {
                            if (currentTime > x.startTime ) {
                                continue;
                            } else {
                                nextTime = x.startTime + x.travelTime;
                            }
                        }
                        pq.add(new intPair2(nextTime, x.to));
                    }
                }
            }
            for (int i = 0; i < queries; i++) {
                int query = Integer.parseInt(br.readLine());
                if (visited[query] == -1) {
                    pw.println("Impossible");
                } else {
                    pw.println(visited[query]);
                }
            }
        }
        pw.flush();
    }
}
class timeTableSlot {
    int to, timeInterval, travelTime;
    int startTime;
    public timeTableSlot(int to, int startTime, int timeInterval, int travelTime) {
        this.to = to;
        this.startTime = startTime;
        this.timeInterval = timeInterval;
        this.travelTime = travelTime;
    }
}

class intPair2 {
    long time;
    int node;
    public intPair2(long time, int node) {
        this.time = time;
        this.node = node;
    }
}