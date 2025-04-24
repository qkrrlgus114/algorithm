import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int answer = 0;
    static int N;
    static int[] arr = new int[10];

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(arr, -1);

        N = Integer.parseInt(bf.readLine());

        if (N == 0) {
            System.out.println(0);
        } else {
            back(1, 0);
            back(2, 0);
            back(3, 0);
            back(4, 0);
            back(5, 0);
            back(6, 0);
            back(7, 0);
            back(8, 0);
            back(9, 0);
            back(10, 0);
            System.out.println(-1);

        }

    }

    public static void back(int s, int index) {
        if (index == s) {
            answer++;
            if (answer == N) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] != -1) sb.append(arr[i]);
                }
                System.out.println(sb);
                System.exit(0);
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (index == 0 && i == 0 && s > 0) continue;
            if (s != 1 && index > 0 && arr[index - 1] <= i) continue;
            arr[index] = i;
            back(s, index + 1);
            arr[index] = -1;
        }
    }
}