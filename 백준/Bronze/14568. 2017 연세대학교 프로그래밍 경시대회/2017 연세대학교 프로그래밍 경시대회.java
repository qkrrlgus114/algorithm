import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * 1. 남는 사탕 없어야 한다.
     * 2. 남규 >= 영훈 + 2
     * 3. 사탕 0개 X
     * 4. 택희 % 2 == 0
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int answer = 0;

        // i = 택희, j = 영훈, k = 남규
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (N == i + j + k && k >= j + 2 && i % 2 == 0) answer++;
                }
            }
        }

        System.out.println(answer);

    }
}
