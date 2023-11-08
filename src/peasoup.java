import java.util.*;
public class peasoup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int restaurants = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < restaurants; i++) {
            int items = sc.nextInt();
            sc.nextLine();
            String restaurantName = sc.nextLine();
            // boolean to check if both items appear
            boolean peasoup = false, pancakes = false;

            // while loop to iterate through items in each restaurant
            for (int count = 0; count < items; count++) {
                String item = sc.nextLine();
                if (item.equals("pea soup")) {
                    peasoup = true;
                }
                if (item.equals("pancakes")) {
                    pancakes = true;
                }
            }
            // print restaurant name only if both items appeara
            if (pancakes && peasoup) {
                System.out.println(restaurantName);
                /* end the for loop that iterates through all the through all the restaurants
                once the first restaurant with peasoup and pancakes appear*/
                return;
            }
        }
        System.out.println("Anywhere is fine I guess");
    }
}