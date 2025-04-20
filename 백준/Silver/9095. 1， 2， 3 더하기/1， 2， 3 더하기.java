import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            answer = 0;
            int N = Integer.parseInt(bf.readLine());

            combination(0, N);

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    public static void combination(int sum, int N) {
        if (sum == N) {
            answer++;
            return;
        } else if (sum > N) {
            return;
        }

        combination(sum + 1, N);
        combination(sum + 2, N);
        combination(sum + 3, N);
    }


}