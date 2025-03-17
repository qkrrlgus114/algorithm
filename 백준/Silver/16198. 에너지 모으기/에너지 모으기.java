import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int answer;
    static int N;
    static int[] arr;
    static boolean[] choice;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        choice = new boolean[N];
        arr = new int[N];

        String[] sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }

        dfs(0, 0);

        System.out.println(answer);

    }

    public static void dfs(int depth, int sum) {
        // depth가 N - 2면 종료
        if (depth == N - 2) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            if (choice[i]) continue;
            choice[i] = true;
            // 왼쪽을 고름
            int left = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (!choice[j]) {
                    left = arr[j];
                    break;
                }
            }
            // 오른쪽을 고름
            int right = 0;
            for (int j = i + 1; j < N; j++) {
                if (!choice[j]) {
                    right = arr[j];
                    break;
                }
            }
            dfs(depth + 1, sum + (left * right));
            choice[i] = false;
        }
    }


}
