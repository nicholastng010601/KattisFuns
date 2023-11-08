import java.util.Scanner;

public class ColType {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (!(input.charAt(input.length() - 1) == 'O')) {
            System.out.print("INVALID");
            return;
        }
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) != 'E' && input.charAt(i) != 'O') {
                System.out.print("INVALID");
                return;
            }
            if (i > 0 && input.charAt(i) == 'O' && input.charAt(i - 1) == 'O') {
                System.out.print("INVALID");
                return;
            }
            if (i == input.length() - 2 && input.charAt(i)=='O') {
                System.out.print("INVALID");
                return;
            }
        }
        long value = 1;
        boolean solved = false;

        while (!solved) {
            value *= 2;
            long temp = value;
            for (int i = input.length() - 1; i >= 0; i--) {
                if (input.charAt(i) == 'O') {
                    if (temp == 1) {
                        break;
                    }
                    if ((temp - 1) % 3 == 0) {
                        temp = (temp - 1) / 3;
                    } else {
                        break;
                    }
                } else {
                    if ((Math.log(temp) / Math.log(2) % 1) == 0) {
                        break;
                    }
                    temp *= 2;
                }

                if (i == 0) {
                    System.out.print(temp);
                    solved = true;
                }
            }
        }
    }
}
