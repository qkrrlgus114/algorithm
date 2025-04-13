import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, S, answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        S = Integer.parseInt(sa[1]);
        arr = new int[N];
        sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }

        permutation(0, 0, false);

        System.out.println(answer);

    }

    public static void permutation(int depth, int sum, boolean flag) {
        if (sum == S && flag) {
            answer++;
        }
        if (depth >= N) return;

        // 고르는 경우
        permutation(depth + 1, sum + arr[depth], true);
        // 안고르는 경우
        permutation(depth + 1, sum, false);
    }

}

