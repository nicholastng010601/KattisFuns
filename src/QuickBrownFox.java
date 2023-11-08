import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class QuickBrownFox {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int lines = Integer.parseInt(br.readLine());
        for (int i = 0; i < lines; i++) {
            int[] letters = new int[26];
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                int result = line.charAt(j);
                if (result < 65) {
                    continue;
                } else if (result < 97){
                    letters[line.charAt(j) - 'A']++;
                } else {
                    letters[line.charAt(j) - 'a']++;
                }
            }

            StringBuilder res = new StringBuilder("missing ");
            for (int j = 0; j < letters.length; j++) {
                if (letters[j] == 0) {
                    char curr = (char) (j + 97);
                    res.append(curr);
                }
            }
            if (res.length() == 8) {
                pw.println("pangram");
            } else {
                pw.println(res);
            }
        }
        pw.flush();
    }

}