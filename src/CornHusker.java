import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CornHusker {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int sum = Integer.parseInt(line[0]) * Integer.parseInt(line[1])
                + Integer.parseInt(line[2]) * Integer.parseInt(line[3])
                + Integer.parseInt(line[4]) * Integer.parseInt(line[5])
                + Integer.parseInt(line[6]) * Integer.parseInt(line[7])
                + Integer.parseInt(line[8]) * Integer.parseInt(line[9]);
        line = br.readLine().split(" ");
        sum /= 5;
        sum *= Integer.parseInt(line[0]);
        sum /= Integer.parseInt(line[1]);
        System.out.println(sum);
    }
}
