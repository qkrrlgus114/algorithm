import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, answer;
    static int[] arr;
    static int[] memo;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        arr = new int[N];
        memo = new int[N];

        String[] sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sa[i]);
            memo[i] = 1;
        }


        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }

        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, memo[i]);
        }

        System.out.println(answer);
    }


}