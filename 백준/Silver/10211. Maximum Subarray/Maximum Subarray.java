import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(bf.readLine());

            int[] arr = new int[N];
            String[] sa = bf.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(sa[i]);
            }

            int answer = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = i; j < N; j++) {
                    sum += arr[j];
                    answer = Math.max(answer, sum);
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

}

