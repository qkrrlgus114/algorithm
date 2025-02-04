import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(bf.readLine());

        long result = 0;

        for (int i = 0; i < N; i++) {
            long sum = 0;
            int j = i;
            while (j < N) {
                sum += arr[j];
                if (sum > k) {
                    result += N - j;
                    break;
                } else {
                    j++;
                }
            }
        }


        System.out.println(result);
    }
}