import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int N, M;
    static boolean[] visited = new boolean[10001];
    static StringBuilder sb = new StringBuilder();
    static int[] answer;
    static int[] arr;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");

        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        answer = new int[M];
        arr = new int[N];
        visited = new boolean[N];

        sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }
        Arrays.sort(arr);

        recur(0);

        System.out.println(sb);
    }

    public static void recur(int depth) {
        if (depth == M) {
            String value = "";
            for (int i = 0; i < M; i++) {
                value += answer[i] + " ";
            }
            if (set.contains(value)) return;
            set.add(value);
            for (int i = 0; i < M; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            answer[depth] = arr[i];
            recur(depth + 1);
            visited[i] = false;
        }
    }
}
