import java.io.*;
import java.util.*;

public class almostunionfind {
    int[] root;
    int[] count;
    long[] sum;
    int[] next;

    public almostunionfind(int n) {
        count = new int[n + 1];
        sum = new long[n + 1];
        next = new int[n + 1];
        root = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            root[i] = i;
            count[i] = 1;
            sum[i] = i;
            next[i] = i;
        }
    }

    public int findRoot(int set) {
        int pointer = next[set];
        while (pointer != root[pointer]) {
            pointer = root[pointer];
        }
        next[set] = pointer;
        return pointer;
    }

    public long findSum(int set) {
        return sum[findRoot(set)];
    }

    public int findCount(int set) {
        return count[findRoot(set)];
    }

    public void union(int set1, int set2) {
        int root1 = findRoot(set1);
        int root2 = findRoot(set2);
        if (root1 != root2) {
            sum[root2] += sum[root1];
            count[root2] += count[root1];
            next[set1] = root2;
            root[root1] = root2;
        }
    }

    public void move(int set1, int set2) {
        int root1 = findRoot(set1);
        int root2 = findRoot(set2);
        if (root1 != root2) {
            sum[root1] -= set1;
            count[root1] -= 1;
            next[set1] = root2;
            sum[root2] += set1;
            count[root2] += 1;
        }
    }


    public static void main(String[] args) throws IOException{
        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String entireline;

        while ((entireline = br.readLine()) != null) {
            String[] line =entireline.split(" ");
            int sets = Integer.parseInt(line[0]);
            int commands = Integer.parseInt(line[1]);
            almostunionfind dataset = new almostunionfind(sets);

            for (int i = 0; i < commands; i++) {
                String[] tempLine = br.readLine().split(" ");
                int command = Integer.parseInt(tempLine[0]);
                int firstSet;
                int secondSet;
                if (command == 1) {
                    firstSet = Integer.parseInt(tempLine[1]);
                    secondSet = Integer.parseInt(tempLine[2]);
                    dataset.union(firstSet, secondSet);
                } else if (command == 2) {
                    firstSet = Integer.parseInt(tempLine[1]);
                    secondSet = Integer.parseInt(tempLine[2]);
                    dataset.move(firstSet, secondSet);
                } else {
                    firstSet = Integer.parseInt(tempLine[1]);
                    pw.println(dataset.findCount(firstSet) + " " +dataset.findSum(firstSet));
                }

            }
        }
        pw.close();
    }
}
