import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Islands {

    public static void traversal(Character[][] map, int row, int col) {
        if (row < 0 || col < 0 || row >= map.length || col >= map[0].length || map[row][col] == 'W') {
            return;
        } else {
            map[row][col] = 'W';
            traversal(map, row - 1, col);
            traversal(map, row + 1, col);
            traversal(map, row, col - 1);
            traversal(map, row, col + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int rows = Integer.parseInt(firstLine[0]);
        int cols = Integer.parseInt(firstLine[1]);

        Character[][] map = new Character[rows][cols];
        for (int i = 0; i < rows; i++) {
            String lineI = br.readLine();
            for (int j = 0; j < cols; j++) {
                map[i][j] = lineI.charAt(j);
            }
        }

        int islands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (map[i][j] == 'L') {
                    traversal(map, i, j);
                    islands++;
                }
            }
        }
        System.out.println(islands);
    }
}
