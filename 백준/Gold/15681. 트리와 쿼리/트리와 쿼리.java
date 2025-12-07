import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer>[] list;
    static int N;
    static int R;
    static int Q;
    static int[] result;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");

        N = Integer.parseInt(sa[0]);
        R = Integer.parseInt(sa[1]);
        Q = Integer.parseInt(sa[2]);

        list = new List[N + 1];
        result = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            sa = bf.readLine().split(" ");

            int s = Integer.parseInt(sa[0]);
            int e = Integer.parseInt(sa[1]);

            list[s].add(e);
            list[e].add(s);
        }

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            sb.append(result[Integer.parseInt(bf.readLine())]).append("\n");
        }

        System.out.println(sb.toString());

    }

    static void dfs(int u) {
        visited[u] = true;
        result[u] = 1;

        for (int i = 0; i < list[u].size(); i++) {
            int value = list[u].get(i);
            if (!visited[value]) {
                dfs(value);
                result[u] += result[value];
            }
        }
    }

}
