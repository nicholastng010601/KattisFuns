import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class backspace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < line.length(); i++) {
            Character x = line.charAt(i);
            if (x.equals('<')) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(x);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        System.out.println(sb);
    }
}
