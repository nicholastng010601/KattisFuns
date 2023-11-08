import java.io.*;
import java.util.ArrayList;

public class coconut {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String[] firstLine = br.readLine().split(" ");
        int syllabus = Integer.parseInt(firstLine[0]);
        int totalPlayers = Integer.parseInt(firstLine[1]);
        int counter = 0;

        ArrayList<Hand> lineOfPlayers = new ArrayList<>();

        while(counter < totalPlayers) {
            lineOfPlayers.add(new Hand(counter + 1));
            counter++;
        }

        int currentHand = 0;
        while (lineOfPlayers.size() > 1) {
            for (int i = 1; i < syllabus; i++) {
                // current hand serves as a pointer, pointing at who is the current person being tagged
                // i serves as a counter, counting how many syllabus have passed
                currentHand++;
                if (currentHand == lineOfPlayers.size()) {
                    currentHand = 0;
                }
            }
            // number of syllabus stated have passed
            Hand current = lineOfPlayers.get(currentHand);
            current.tag();

            if (current.timesTagged == 1) {
                // if its his first time being tagged, add a fist
                lineOfPlayers.add(currentHand, new Hand(current.player, 1));
            } else if (current.timesTagged == 3) {
                lineOfPlayers.remove(current);
                if (currentHand == lineOfPlayers.size()) {
                    currentHand = 0;
                }
            } else {
                if(currentHand == lineOfPlayers.size() - 1) {
                    currentHand = 0;
                } else {
                    currentHand++;
                }
            }
        }
        pw.println(lineOfPlayers.get(0).player);
        pw.flush();
    }

    public static class Hand {
        public int player;
//      if a hand is tagged thrice, it is out (folded (0) -> fist(1) -> palm (2) -> out (3) )
        public int timesTagged;
        public Hand(int player) {
            this.player = player;
            this.timesTagged = 0;
        }

        public Hand(int player, int timesTagged) {
            this.player = player;
            this.timesTagged = timesTagged;
        }

        public void tag() {
            this.timesTagged = timesTagged + 1;
        }
    }

}
