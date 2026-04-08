import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int[] arr;
    static int[] temp;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    static StringBuilder tempSb = new StringBuilder();
    static boolean[] visited;
    static Set<String> set = new HashSet<>();


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        arr = new int[N];
        temp = new int[M];
        visited = new boolean[N];

        sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }
        Arrays.sort(arr);

        dfs(0);

        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                tempSb.append(temp[i]).append(" ");
            }
            if (set.contains(tempSb.toString())) {
                tempSb.setLength(0);
                return;
            }
            for (int i = 0; i < M; i++) {
                sb.append(temp[i]).append(" ");
            }
            set.add(tempSb.toString());
            tempSb.setLength(0);
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            temp[depth] = arr[i];
            visited[i] = true;
            dfs(depth + 1);
            visited[i] = false;
        }
    }

}