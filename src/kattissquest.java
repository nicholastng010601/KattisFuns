import java.io.*;
import java.time.DayOfWeek;
import java.util.*;

class kattisquest {
    public static void main(String[] args) throws IOException{
       PrintWriter pw = new PrintWriter(System.out);
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       long lines = Long.parseLong(br.readLine().split(" ")[0]);
       TreeMap<Quest, Long> tm = new TreeMap<>((a,b) -> a.energy == b.energy ? Long.compare(a.gold, b.gold) : Long.compare(a.energy, b.energy));

           for (int i = 0; i < lines; i++) {
           String[] line = br.readLine().split(" ");
           if (line[0].equals("add")) {
               Quest temp = new Quest(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
               if (tm.containsKey(temp)) {
                   tm.replace(temp, tm.get(temp) + 1);
               } else {
                   tm.put(temp, Long.valueOf(1));
               }
           } else {
               long energy = Integer.parseInt(line[1]);
               long gold = 0;
               while (true) {
                   Quest x = tm.floorKey(new Quest(energy, Integer.MAX_VALUE));
                   if (x == null) {
                       break;
                   }
                   gold += x.gold;
                   energy -= x.energy;
                   if (tm.get(x) == 1) {
                       tm.remove(x);
                   } else {
                       tm.replace(x, tm.get(x) - 1);
                   }
               }
               pw.println(gold);
           }
       }
        pw.flush();
    }
}

class Quest {
    public long energy;
    public long gold;

    Quest(long energy, long gold) {
        this.energy = energy;
        this.gold = gold;
    }

}
