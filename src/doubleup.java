//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.util.Stack;
//import java.util.StringTokenizer;
//
//public class doubleup {
//    public static int dfs(int x, int[] input, Stack<Integer> s) {
//        if (x == input.length - 1) {
//            return s.peek();
//        }
//        if (s.isEmpty()) {
//            int noUse = dfs(x + 1, input, s);
//            s.add(input[x]);
//            int use = dfs(x + 1, input, s);
//            s.pop();
//            return Math.max(use, noUse);
//        } else {
//            // use
//            if ((int) s.peek() == input[x]) {
//                s.pop();
//                s.add(input[x] * 2);
//                int use = dfs(x + 1, input, s);
//                s.pop();
//                int noUse = dfs(x + 1, input, s);
//                return Math.max(use, noUse);
//            } else {
//                s.add(input[x]);
//                int use = dfs(x + 1, input, s);
//                s.pop();
//                int noUse = dfs(x + 1, input, s);
//                return Math.max(use, noUse);
//            }
//        }
//    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int numbers = Integer.parseInt(br.readLine());
//        int[] input = new int[numbers];
//
//        StringTokenizer line = new StringTokenizer(br.readLine());
//        for (int i = 0; i < numbers; i++) {
//            input[i] = Integer.parseInt(line.nextToken());
//        }
//        System.out.print(dfs(0, input, new Stack<Integer>()));
//
//    }
//}
