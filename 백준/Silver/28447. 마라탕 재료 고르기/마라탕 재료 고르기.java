import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K;
    static int[][] arr;
    static boolean[] visited;
    static int answer = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        K = Integer.parseInt(sa[1]);
        visited = new boolean[N];

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            sa = bf.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(sa[j]);
            }
        }

        dfs(0, 0);

        System.out.println(answer);

    }

    private static void dfs(int depth, int choice) {
        // 종료 조건
        if (choice == K) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                if (!visited[i]) continue;
                for (int j = i + 1; j < N; j++) {
                    if (!visited[j]) continue;
                    sum += arr[i][j];
                }
            }

            answer = Math.max(answer, sum);
            return;
        }

        // 재귀 조건
        for (int i = depth; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(i + 1, choice + 1);
            visited[i] = false;
        }
    }

}


