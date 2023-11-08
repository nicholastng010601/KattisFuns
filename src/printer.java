import java.util.Scanner;

public class printer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int res = sc.nextInt();
        System.out.println((int) Math.ceil(Math.log(res)/ Math.log(2)) + 1);
    }
}
