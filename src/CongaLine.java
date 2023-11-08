import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;

public class CongaLine {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Long couples = Long.parseLong((input[0]));
        Long numberOfCommands = Long.parseLong(input[1]);

        input = br.readLine().split(" ");
        Person firstPersonPointer = new Person(input[0]);
        Person lastPersonPointer = new Person(input[1]);
        firstPersonPointer.after = lastPersonPointer;
        firstPersonPointer.partner = lastPersonPointer;
        lastPersonPointer.before = firstPersonPointer;
        lastPersonPointer.partner = firstPersonPointer;

        for (long i = 1; i < couples; i++) {
            input = br.readLine().split(" ");
            Person temp1 = new Person(input[0]);
            Person temp2 = new Person(input[1]);
            lastPersonPointer.after = temp1;
            temp1.before = lastPersonPointer;
            temp1.partner = temp2;
            temp1.after = temp2;
            temp2.before = temp1;
            temp2.partner = temp1;
            lastPersonPointer = temp2;
        }

        String commands = br.readLine();

        Person currentPointer = firstPersonPointer;

        for (int i = 0; i < numberOfCommands; i++) {
            Character com = commands.charAt(i);
            if (com.equals('F')) {
                currentPointer = currentPointer.before;
            } else if (com.equals('B')) {
                currentPointer = currentPointer.after;
            } else if (com.equals('R')) {
                if (currentPointer.after == null) {
                    currentPointer = firstPersonPointer;
                } else {
                    Person temp = currentPointer;
                    currentPointer = currentPointer.after;
                    if (temp.before != null) {
                        temp.before.after = temp.after;
                    } else {
                        firstPersonPointer = temp.after;
                    }
                    temp.after.before = temp.before;
                    lastPersonPointer.after = temp;
                    temp.before = lastPersonPointer;
                    temp.after = null;
                    lastPersonPointer = temp;
                }
            } else if (com.equals('C')) {
                Person temp = currentPointer;
                if (currentPointer.after == null) {
                    currentPointer = firstPersonPointer;
                } else {
                    currentPointer = currentPointer.after;
                }
                if (temp.before != null) {
                    temp.before.after = temp.after;
                } else {
                    firstPersonPointer = temp.after;
                }
                temp.after.before = temp.before;

                if (temp.partner.after != null) {
                    temp.partner.after.before = temp;
                } else {
                    lastPersonPointer = temp;
                }
                temp.after = temp.partner.after;
                temp.partner.after = temp;
                temp.before = temp.partner;
            } else {
                pw.println(currentPointer.partner.name);
            }
        }

        pw.println();

        for (int i = 0; i < couples * 2; i++) {
            pw.println(firstPersonPointer.name);
            firstPersonPointer = firstPersonPointer.after;
        }

        pw.flush();
    }
}
class Person {
    public Person partner;
    public String name;
    public Person before;
    public Person after;
    public Person(String name) {
        this.name = name;
    }
}
