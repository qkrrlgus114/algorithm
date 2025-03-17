import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");

        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        visited = new boolean[N + 1];
        arr = new int[M];

        recur(0, 1);

        System.out.println(sb);
    }

    public static void recur(int depth, int num) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = num; i <= N; i++) {
//            if (visited[i]) continue;
//            visited[i] = true;
            arr[depth] = i;
            recur(depth + 1, i);
//            visited[i] = false;
        }
    }
}
