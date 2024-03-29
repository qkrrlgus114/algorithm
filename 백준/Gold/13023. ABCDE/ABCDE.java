import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {

    static int N, M;
    static List<Integer>[] list;
    static boolean[] visited;
    static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        list = new List[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            sa = bf.readLine().split(" ");
            int start = Integer.parseInt(sa[0]);
            int end = Integer.parseInt(sa[1]);

            list[start].add(end);
            list[end].add(start);
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(0, i);
            visited[i] = false;
            if (check) break;
        }

        System.out.println(0);


    }

    public static void dfs(int depth, int next) {
        // 종료 조건
        if (depth == 4) {
            check = true;
            System.out.println("1");
            System.exit(0);
        }
        // 재귀

        for (int j = 0; j < list[next].size(); j++) {
            int temp = list[next].get(j);
            if (visited[temp]) continue;
            visited[temp] = true;
            dfs(depth + 1, temp);
            visited[temp] = false;

        }

    }

}



