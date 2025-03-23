import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        dfs(N, 0);

        System.out.println(sb);
    }

    public static boolean confirmPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void dfs(int depth, int num) {
        if (depth == 0) {
            sb.append(num).append("\n");
            return;
        }

        for (int i = 1; i < 10; i++) {
            int value = num * 10 + i;
            if (confirmPrime(value)) {
                dfs(depth - 1, value);
            }
        }
    }
}