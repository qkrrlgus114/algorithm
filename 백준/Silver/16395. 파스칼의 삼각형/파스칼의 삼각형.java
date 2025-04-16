import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, K;
    static int[][] arr = new int[30][30];

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        K = Integer.parseInt(sa[1]);

        recur(0);

        System.out.println(arr[N - 1][K - 1]);
    }

    public static void recur(int depth) {
        if (depth == N) {
            return;
        }

        for (int i = 0; i <= depth; i++) {
            if (i == 0 || i == depth) {
                arr[depth][i] = 1;
            } else {
                arr[depth][i] = arr[depth - 1][i - 1] + arr[depth - 1][i];
            }
        }
        recur(depth + 1);
    }
}