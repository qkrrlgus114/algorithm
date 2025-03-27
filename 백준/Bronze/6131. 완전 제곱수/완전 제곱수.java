import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * A^2 = B^2 + N
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int answer = 0;
        for (int i = 1; i <= 500; i++) {
            for (int j = 1; j <= 500; j++) {
                if (i * i == (j * j) + N) answer++;
            }
        }

        System.out.println(answer);

    }
}
