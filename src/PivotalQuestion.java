import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PivotalQuestion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] line = br .readLine().split(" ");
        int elements = Integer.parseInt(line[0]);
        int[] largestSoFar = new int[elements];
        int[] smallestSoLeft = new int[elements];
        int[] allValues = new int[elements];

        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int i = 1; i <= elements; i++) {
            allValues[i - 1] = Integer.parseInt(line[i]);
            largest = Math.max(largest, allValues[i - 1]);
            largestSoFar[i - 1] = largest;
        }

        for (int i = elements - 1; i >= 0; i--) {
            smallest = Math.min(smallest, allValues[i]);
            smallestSoLeft[i] = smallest;
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < elements; i++) {
            if (allValues[i] == largestSoFar[i] && allValues[i] == smallestSoLeft[i]) {
                if (i < elements - 1 && allValues[i] != allValues[i + 1]) {
                    if (count < 100) {
                        sb.append(" " + allValues[i]);
                    }
                    count++;

                } else if (i == elements - 1) {
                    if (count < 100) {
                        sb.append(" " + allValues[i]);
                    }
                    count++;
                }
            }
        }
        System.out.print(count);
        System.out.print(sb);
    }
}
