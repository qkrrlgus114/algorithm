import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int answer = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(bf.readLine());
            visited = new boolean[n];
            String Bob = bf.readLine();
            String Alice = bf.readLine();

            int leftBob = Integer.parseInt(Bob);
            StringBuilder ssb = new StringBuilder();
            ssb.append(Bob);
            ssb.reverse();
            int rightBod = Integer.parseInt(ssb.toString());

            char[] arr = Alice.toCharArray();
            combination(new StringBuilder(), 0, n, arr, leftBob, rightBod);
            sb.append(answer).append("\n");
            answer = 0;
        }

        System.out.println(sb);
    }

    public static void combination(StringBuilder ssb, int depth, int n, char[] arr, int leftBob, int rightBob) {
        if (ssb.length() > 0) {
            int value = Integer.parseInt(ssb.toString());
            if (leftBob > value && rightBob > value) {
                answer = Math.max(answer, Integer.parseInt(ssb.toString()));
            }
        }
        if (depth == n) {
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            ssb.append(arr[i]);
            combination(ssb, depth + 1, n, arr, leftBob, rightBob);
            ssb.deleteCharAt(ssb.length() - 1);
            visited[i] = false;
        }
    }
}
