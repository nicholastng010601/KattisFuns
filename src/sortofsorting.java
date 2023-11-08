import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.io.*;

public class sortofsorting {
    public static void main(String[] args){
        Instant start = Instant.now();
        Scanner sc = new Scanner(System.in);
        int students = -1;
        while (true) {
            students = sc.nextInt();
            if (students == 0) break;
            sc.nextLine();
            ArrayList<String> res = new ArrayList<>();
            for (int i = students; i > 0; i--) {
                res.add(sc.nextLine());
            }
            res.sort((x, y) -> x.charAt(0) - y.charAt(0) == 0 ? x.charAt(1) - y.charAt(1) : x.charAt(0) - y.charAt(0));
            for (int i = students; i > 0; i--) {
                System.out.println(res.remove(0));
            }
            System.out.println();
        }
        Instant end = Instant.now();
        long time = Duration.between(start, end).toMillis();
        System.out.println(time + " Milli seconds");
    }
}