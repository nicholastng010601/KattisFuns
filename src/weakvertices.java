import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class weakvertices {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String introLine = br.readLine();
            int points = Integer.parseInt(introLine);
            if (points == -1) {
                break;
            }
            int[][] adjMatrix = new int[points][points];
            String[] currentLine;
            for (int i = 0; i < points; i++) {
                currentLine = br.readLine().split(" ");
                for (int j = 0; j < points; j++) {
                    adjMatrix[i][j] = Integer.parseInt(currentLine[j]);
                }
            }

            boolean[] checked = new boolean[points];
            for (int i = 0; i < points; i++) {
                for (int j = i + 1; j < points; j++) {
                    if (adjMatrix[i][j] == 1) {
                        for (int k = 0; k < points; k++) {
                            if (k != i && k != j) {
                                if (adjMatrix[i][k] == 1 && adjMatrix[j][k] == 1) {
                                    checked[i] = true;
                                    checked[j] = true;
                                }
                            }
                        }
                    }
                }
            }
            StringBuilder a = new StringBuilder();
            for (int i = 0; i < points; i++) {
                if (checked[i] == false) {
                    a.append(i + " ");
                }
            }
            pw.println(a);
        }
        pw.flush();
    }
}
