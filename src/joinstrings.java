
import java.io.*;

public class joinstrings {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int numberOfStrings = Integer.parseInt(br.readLine().split(" ")[0]);
        int lastRecordedIndex = 0;
        String[] strings = new String[numberOfStrings];
        Index[] indexes = new Index[numberOfStrings];
        for (int i = 0; i < numberOfStrings; i++) {
            strings[i] = br.readLine();
            indexes[i] = new Index(i);
            if (numberOfStrings == 0) {
                pw.println(strings[i]);
                pw.flush();
                break;
            }
        }

        for (int j = 0; j < numberOfStrings - 1; j++) {
            String[] temp = br.readLine().split(" ");
            int firstValue = Integer.parseInt(temp[0]) - 1;
            int secondValue = Integer.parseInt(temp[1]) - 1;
            indexes[indexes[firstValue].last].next = indexes[secondValue].current;
            indexes[firstValue].last = indexes[secondValue].last;
            lastRecordedIndex = firstValue;
        }

        int current = lastRecordedIndex;
        while (indexes[current].next != -1) {
            pw.print(strings[current]);
            current = indexes[indexes[current].next].current;
        }
        pw.print(strings[current]);
        pw.flush();
    }

}

class Index {
    int current;
    int last;
    int next = -1;

    public Index(int current) {
        this.current = current;
        this.last = current;
    }
}

