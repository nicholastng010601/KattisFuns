import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MillionaireMadness {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int length = Integer.parseInt(line[0]);
        int width = Integer.parseInt(line[1]);

        int[][] grid = new int[length][width];
        boolean[][] visited = new boolean[length][width];
        PriorityQueue<coordinate> q = new PriorityQueue<>((x,y) -> x.height - y.height);

        for (int i = 0; i < length; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < width; j++) {
                grid[i][j] = Integer.parseInt(line[j]);
            }
        }
        q.add(new coordinate(0, 0, 0));
        while (true) {
            coordinate current = q.poll();
            int row = current.row;
            int col = current.col;
            int height = current.height;
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                System.out.println(height);
                break;
            }
            if (visited[row][col]) {
                continue;
            }
            visited[row][col] = true;
            if (row > 0) {
                q.add(new coordinate(row - 1, col, Math.max(height, grid[row - 1][col] - grid[row][col])));
            }
            if (col > 0) {
                q.add(new coordinate(row, col - 1, Math.max(height, grid[row][col - 1] - grid[row][col])));
            }
            if (row < grid.length - 1) {
                q.add(new coordinate(row + 1, col, Math.max(height, grid[row + 1][col] - grid[row][col])));
            }
            if (col < grid[0].length - 1) {
                q.add(new coordinate(row, col + 1, Math.max(height, grid[row][col + 1] - grid[row][col])));
            }
        }
    }
}

class coordinate {
    int row;
    int col;
    int height;

    public coordinate(int row, int col, int height) {
        this.row = row;
        this.col = col;
        this.height = height;
    }

}