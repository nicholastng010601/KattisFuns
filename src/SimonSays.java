import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SimonSays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int lines = Integer.parseInt(br.readLine());
        for (int i = 0; i < lines; i++) {
            StringTokenizer curr = new StringTokenizer(br.readLine());
            if (curr.nextToken().equals("Simon") && curr.nextToken().equals("says")) {
                StringBuilder sb = new StringBuilder();
                while (curr.hasMoreTokens()) {
                    sb.append(curr.nextToken() + " ");
                }
                pw.println(sb.toString().trim());
            }
        }
        pw.flush();
    }

}
