import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;


public class Workstations {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out);
            String[] firstLine = br.readLine().split(" ");
            int numberOfResearchers = Integer.parseInt(firstLine[0]);
            int lockTime = Integer.parseInt(firstLine[1]);
            int count = 0;

            PriorityQueue<Researchers> queueOfResearchers = new PriorityQueue<>((x,y) -> x.arrivalTime != y.arrivalTime ? x.arrivalTime - y.arrivalTime : x.leaveTime() - y.leaveTime());
            PriorityQueue<Integer> queueOfWorkStation = new PriorityQueue<>();

            for (int i = 0; i < numberOfResearchers; i++) {
                String[] currentResearcher = br.readLine().split(" ");
                queueOfResearchers.add(new Researchers(Integer.parseInt(currentResearcher[0]), Integer.parseInt(currentResearcher[1])));
            }

            while (!queueOfResearchers.isEmpty()) {
                Researchers temp = queueOfResearchers.poll();

                while (!queueOfWorkStation.isEmpty() && temp.arrivalTime > queueOfWorkStation.peek() + lockTime) {
                    queueOfWorkStation.poll();
                }

                if (!queueOfWorkStation.isEmpty() && temp.arrivalTime <= queueOfWorkStation.peek() + lockTime && queueOfWorkStation.peek() <= temp.arrivalTime) {
                    queueOfWorkStation.poll();
                    count++;
                }

                queueOfWorkStation.add(temp.leaveTime());
            }
        pw.println(count);
        pw.flush();
    }
}

class Researchers {
    int arrivalTime;
    int stayTime;

    public Researchers(int arrivalTime, int stayTime) {
        this.arrivalTime = arrivalTime;
        this.stayTime = stayTime;
    }

    public int leaveTime() {
        return arrivalTime + stayTime;
    }
}
