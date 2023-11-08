import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SecretMessage {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int lines = Integer.parseInt(br.readLine());
        for (int i = 0; i < lines; i++) {
            String line = br.readLine();
            int r = (int) Math.floor(Math.sqrt(line.length())) + 1;
            if (Math.floor(Math.sqrt(line.length())) == Math.sqrt(line.length())) {
                r--;
            }
            Character[][] res = new Character[r][r];
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < r; k++) {
                    if (j * r + k >= line.length()) {
                        break;
                    }
                    res[j][k] = line.charAt(j * r + k);
                }
            }
            StringBuilder x = new StringBuilder();
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < r; k++) {
                    if (res[r -k-1][j] == null) {
                        continue;
                    }
                    x.append(res[r - k - 1][j]);
                }
            }
            pw.println(x);
        }
        pw.flush();
    }
}
