import java.util.Scanner;
import java.util.Stack;

public class T9Spelling {
    public static void main(String[] args) {

        int[] alphabets = {-1, 0, 3, 6, 9, 12, 15, 19, 22, 26};

        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= cases; i++) {
            StringBuilder letterToNumber = new StringBuilder();
            String current = sc.nextLine();
            for (int j = 0; j < current.length(); j++) {
                    char letter = current.charAt(j);
                if (letter == ' ') {
                    if (letterToNumber.length() > 0 && letterToNumber.charAt(letterToNumber.length() - 1) == '0') {
                        letterToNumber.append(' ');
                    }
                    letterToNumber.append(0);
                    continue;
                }
                int letterNumber = letter - 'a' + 1;

                for (int k = 2; k < alphabets.length; k++) {
                    if (letterNumber <= alphabets[k]) {
                        if (letterToNumber.length() > 0 && Character.getNumericValue(letterToNumber.charAt(letterToNumber.length() - 1)) == k) {
                            letterToNumber.append(" ");
                        }
                        for (int l = 0; l < letterNumber - alphabets[k - 1]; l++) {
                            letterToNumber.append(k);
                        }
                        break;
                    }
                }
            }
            System.out.println(String.format("Case #%d: %s", i, letterToNumber.toString()));
        }
    }
}
