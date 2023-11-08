import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Conformity {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int students = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < students; i++) {
            String[] line = br.readLine().split(" ");
            
            Integer[] courses = new Integer[5];
            for (int j = 0; j < 5; j++) {
                courses[j] = Integer.valueOf(line[j]);
            }
            Arrays.sort(courses);

            int code = Arrays.hashCode(courses);

            if (map.containsKey(code)) {
                map.replace(code, map.get(code) + 1);
            } else {
                map.put(code, 1);
            }
        }

        int max = 0;
        int count = 0;
        for (Integer entry : map.keySet()) {
            if (map.get(entry) > max) {
                count = map.get(entry);
                max = map.get(entry);
            } else if (map.get(entry) == max){
                count += map.get(entry);
            }
        }
        pw.println(count);
        pw.flush();
    }


}
