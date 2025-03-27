import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     *
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        int value = Integer.MAX_VALUE; // 절댓값
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            sum += Integer.parseInt(bf.readLine());
            if (Math.abs(100 - sum) <= value) {
                answer = sum;
                value = Math.abs(100 - sum);
            }
        }

        System.out.println(answer);
    }
}
