import java.io.*;
import java.util.HashMap;

public class teque {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int instructions = Integer.parseInt(br.readLine().split(" ")[0]);
        HashMap<Integer, Integer> front = new HashMap<>();
        HashMap<Integer, Integer> back = new HashMap<>();
        int frontStart = -1;
        int frontEnd = 0;
        int backStart = -1;
        int backEnd = 0;

        for (int i = 0; i < instructions; i++) {
            String[] inputs = br.readLine().split(" ");
            int number = Integer.parseInt(inputs[1]);
            if (inputs[0].equalsIgnoreCase("get")) {
                if (number >= front.size()) {
                    pw.println(back.get(number - front.size() + backStart + 1));
                } else {
                    pw.println(front.get(number + frontStart + 1));
                }
            }else if (inputs[0].equalsIgnoreCase("push_back")) {
                back.put(backEnd++, number);
            } else if (inputs[0].equalsIgnoreCase("push_front")) {
                front.put(frontStart--, number);
            } else {
                front.put(frontEnd++, number);
            }
            if (back.size() > front.size()) {
                front.put(frontEnd, back.get(backStart + 1));
                frontEnd++;
                backStart++;
                back.remove(backStart);
            }

            if (front.size() - 1 > back.size()) {
                back.put(backStart, front.get(frontEnd - 1));
                backStart--;
                frontEnd--;
                front.remove(frontEnd);
            }
        }
        pw.flush();
//        mainTeque.add(0,0);
//        mainTeque.add(1,1);
    }
}

// elements  2  4  6  8  10
// /2
// where to add 1 2  3  4
//   3 5 1 9

