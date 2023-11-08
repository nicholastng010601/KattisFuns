import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;

public class DoctorKattis {
    public static void main(String[] args) throws IOException {
        PriorityQueue<cat> q = new PriorityQueue<>((a,b) -> a.infectionLevel == b.infectionLevel ? 0 : b.infectionLevel- a.infectionLevel);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int number = Integer.parseInt(br.readLine());

        for (int i = 0; i < number; i++) {
            String[] line = br.readLine().split(" ");
            int command = Integer.parseInt(line[0]);
            if (command == 0) {
                q.add(new cat(line[1], Integer.parseInt(line[2])));
            } else if (command == 1) {
                q.remove(new cat(line[1], 0));
                q.add(new cat(line[1], Integer.parseInt(line[2])));
            } else if (command == 2){
                q.remove(new cat(line[1], 0));
            } else {
                if (q.peek() == null) {
                    pw.println("The clinic is empty");
                } else {
                    pw.println(q.peek().name);
                }
            }
        }
        pw.flush();

    }
}
class cat {
    public String name;
    public int infectionLevel;

    public cat(String name, int infectionLevel) {
        this.name = name;
        this.infectionLevel = infectionLevel;
    }


    @Override
    public boolean equals(Object x) {
        if (x == this) {
            return true;
        } else if (!(x instanceof cat)) {
            return false;
        } else {
            cat y = (cat) x;
            return y.name.equals(this.name);
        }
    }
}
