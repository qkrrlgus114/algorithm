import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int answer = 0;

        int[] arr = new int[1001];
        int[][] store = new int[N][2];

        int index = 0;
        for (int i = 0; i < N; i++) {
            String[] sa = bf.readLine().split(" ");
            int a = Integer.parseInt(sa[0]);
            int b = Integer.parseInt(sa[1]);
            store[i][0] = a;
            store[i][1] = b;

            for (int j = a; j < b; j++) {
                arr[j]++;
            }
        }

        for (int i = 0; i < N; i++) {
            int a = store[i][0];
            int b = store[i][1];

            for (int j = a; j < b; j++) {
                arr[j]--;
            }
            int sum = 0;
            for (int j = 0; j < 1001; j++) {
                if (arr[j] > 0) {
                    sum++;
                }
            }
            answer = Math.max(answer, sum);
            for (int j = a; j < b; j++) {
                arr[j]++;
            }

        }

        System.out.println(answer);
    }


}

