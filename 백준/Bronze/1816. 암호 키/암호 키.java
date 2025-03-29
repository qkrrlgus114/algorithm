import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static boolean[] prime = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        primeCalculator();

        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            long S = Long.parseLong(bf.readLine());
            boolean status = true;

            for (int j = 2; j <= 1000000; j++) {
                if (!prime[j]) continue;
                if (S % j == 0) {
                    status = false;
                    break;
                }
            }

            if (status) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }

        System.out.println(sb);

    }

    public static void primeCalculator() {
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i <= 1000000; i++) {
            if (prime[i]) {
                for (int j = i + i; j <= 1000000; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

}