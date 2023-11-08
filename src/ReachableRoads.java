import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ReachableRoads {
    public static int findParent(int x, int[] parent) {
        int temp = x;
        while (parent[temp] != temp) {
            temp = parent[temp];
        }
        parent[x] = temp;
        return temp;
    }

    public static void setParent(int x, int set, int[] parent) {
        int temp = x;
        if (parent[temp] != temp) {
            temp = parent[temp];
        }
        parent[x] = set;
        parent[temp] = set;
    }

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int iterations = Integer.parseInt(br.readLine());
        for (int i = 0; i < iterations; i++) {
            int cities = Integer.parseInt(br.readLine());
            int[] parent = new int[cities];
            for (int j = 0; j < cities; j++) {
                parent[j] = j;
            }
            int lines = Integer.parseInt(br.readLine());
            for (int j = 0; j < lines; j++) {
                String[] nums = br.readLine().split(" ");
                int f = Integer.parseInt(nums[0]);
                int s = Integer.parseInt(nums[1]);
                if (findParent(f, parent) != findParent(s, parent)) {
                    setParent(s, parent[f], parent);
                }
            }
            HashSet<Integer> hs = new HashSet<>();
            for (int k = 0; k < cities; k++) {
                hs.add(findParent(k, parent));
            }
            pw.println(hs.size() - 1);
        }
        pw.flush();
    }
}
