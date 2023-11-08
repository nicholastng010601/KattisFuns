import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PhoneList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int iterations = Integer.parseInt(br.readLine());
        for (int i = 0; i < iterations; i++) {
            int lines = Integer.parseInt(br.readLine());

            prefixNode head = new prefixNode();
            boolean fail = false;
            for (int k = 0; k < lines; k++) {
                prefixNode current = head;
                String prefix = br.readLine();
                for (int j = 0; j < prefix.length(); j++) {
                    if (current.end == true) {
                        pw.println("NO");
                        fail = true;
                        break;
                    }
                    int currentLetter = prefix.charAt(j) - '0' ;
                    if (current.numbers[currentLetter] == null) {
                        current.numbers[currentLetter] = new prefixNode();
                    }
                    current = current.numbers[currentLetter];
                    if (j == prefix.length() - 1) {
                        current.end = true;
                    }
                }
                if (fail) {
                    break;
                }
            }
            if (!fail) {
                pw.println("YES");
            }
        }
        pw.flush();
    }
}

class prefixNode {
    prefixNode[] numbers = new prefixNode[10];
    boolean end = false;
}