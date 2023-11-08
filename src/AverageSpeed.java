import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;

public class AverageSpeed {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        long distance = 0;
        long hours = 0;
        long mins = 0;
        long sec = 1;
        long newHours, newMins, newSec;
        long speed = 0;
        while (!(line = br.readLine()).isEmpty()) {
            newHours = Long.parseLong(line.substring(0, 2));
            newMins =  Long.parseLong(line.substring(3,5));
            newSec =  Long.parseLong(line.substring(6,8));
            distance += ((newHours - hours) + (newMins - mins)/60.0 + (newSec - sec)/3600.0) * speed;
            if (line.length() > 8) {
                speed = Long.parseLong(line.substring(9));
            } else {
                DecimalFormat df = new DecimalFormat("#.00");
                String distanceFormated = df.format(distance);
                String s = String.format("%02d", newHours);
                String w = String.format("%02d", newMins);
                String e = String.format("%02d", newSec);
                pw.println(s + ":" + w +":" + e + " " + distanceFormated + " km");
            }
            hours = newHours;
            mins = newMins;
            sec = newSec;
        }
        pw.flush();
    }
}
